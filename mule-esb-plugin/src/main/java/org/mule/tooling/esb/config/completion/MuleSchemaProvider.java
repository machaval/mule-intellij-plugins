package org.mule.tooling.esb.config.completion;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.meta.PsiMetaData;
import com.intellij.psi.util.*;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlFile;
import com.intellij.xml.XmlElementDescriptor;
import com.intellij.xml.XmlSchemaProvider;
import com.intellij.xml.impl.schema.XmlNSDescriptorImpl;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.*;

public class MuleSchemaProvider extends XmlSchemaProvider {

    private static final Logger LOG = Logger.getInstance(MuleSchemaProvider.class.getName());
    private static final Key<CachedValue<Map<String, XmlFile>>> SCHEMAS_BUNDLE_KEY = Key.create("spring_schemas");
    private static final Key<ParameterizedCachedValue<Map<String, String>, Module>> SPRING_SCHEMA_NAMES_KEY = Key.create("SPRING.SCHEMA.NAMES");

    @Override
    public boolean isAvailable(@NotNull XmlFile file) {
        return MuleConfigUtils.isMuleFile(file);
    }

    /**
     * Looks for the schema file to handle the given namespace (url) within the schemas supported by this provider.
     * These schemas are read from spring.schemas file and searched in project files and dependencies. If a schema
     * declared in spring.schemas is not present within project files and project dependencies it will not be resolved.
     *
     * @param url      the url of the namespace
     * @param module   the module where the baseFile is
     * @param baseFile the file where the namespace is declared
     * @return the schema file for the given url if it is supported by this provider (declared in spring.schemas), otherwise null
     */
    @Override
    public XmlFile getSchema(@NotNull @NonNls String url, @Nullable final Module module, @NotNull PsiFile baseFile) throws ProcessCanceledException {
        if (module == null) {
            return null;
        }
        try {
            Map<String, XmlFile> schemas = getSchemas(module);
            if (schemas != null)
                return schemas.get(url);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return null;
    }

    @NotNull
    public Set<String> getAvailableNamespaces(@NotNull XmlFile file, @Nullable String tagName) {
        final Module module = ModuleUtil.findModuleForPsiElement(file);
        Map<String, XmlFile> schemas = getSchemas(module);
        Set<String> namespaces = new HashSet<>();

        try {
            for (XmlFile xsd : schemas.values()) {
                final XmlDocument document = xsd.getDocument();
                if (document != null) {
                    final PsiMetaData metaData = document.getMetaData();
                    if (metaData instanceof XmlNSDescriptorImpl) {
                        XmlNSDescriptorImpl descriptor = (XmlNSDescriptorImpl)metaData;
                        if (StringUtils.isNotEmpty(tagName)) {
                            XmlElementDescriptor elementDescriptor = descriptor.getElementDescriptor(tagName, descriptor.getDefaultNamespace());
                            if (elementDescriptor != null) {
                                namespaces.add(descriptor.getDefaultNamespace());
                            }
                        } else {
                            namespaces.add(descriptor.getDefaultNamespace());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return namespaces;
    }

    public Set<String> getLocations(@NotNull @NonNls final String namespace, @NotNull final XmlFile context) throws ProcessCanceledException {
        Set<String> locations = new HashSet<>();
        final Module module = ModuleUtil.findModuleForPsiElement(context);
        if (module == null) {
            return null;
        }
        try {
            final Map<String, XmlFile> schemas = getSchemas(module);
            for (Map.Entry<String, XmlFile> entry : schemas.entrySet()) {
                final String s = getNamespace(entry.getValue(), context.getProject());
                if (s != null && s.equals(namespace)) {
                    locations.add(entry.getKey());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    @NotNull
    public Map<String, XmlFile> getSchemas(@NotNull final Module module) throws ProcessCanceledException {
        final Project project = module.getProject();
        final CachedValuesManager manager = CachedValuesManager.getManager(project);
        final Map<String, XmlFile> bundle = manager.getCachedValue(module, SCHEMAS_BUNDLE_KEY, new CachedValueProvider<Map<String, XmlFile>>() {
            public Result<Map<String, XmlFile>> compute() {
                try {
                    return computeSchemas(module);
                } catch (ProcessCanceledException pce) {
                    throw pce;
                } catch (Exception e) {
                    //e.printStackTrace();
                    return null;
                }
            }
        }, false);
        return bundle == null ? Collections.<String, XmlFile>emptyMap() : bundle;
    }

    //============================================================================================================
    @NotNull
    private CachedValueProvider.Result<Map<String, XmlFile>> computeSchemas(@NotNull Module module) throws Exception {
        final Project project = module.getProject();
        final CachedValuesManager manager = CachedValuesManager.getManager(project);

        Map<String, XmlFile> schemas = new HashMap<String, XmlFile>();

        ArrayList<Object> dependencies = new ArrayList<Object>();
        dependencies.add(ProjectRootManager.getInstance(project));

        Map<String, String> schemaUrlsAndFileNames = manager.getParameterizedCachedValue(module, SPRING_SCHEMA_NAMES_KEY, new SchemaFileNamesCachedProvider(), false, module);

        //Iterate through the classpath
        LibraryTable libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTableByLevel(LibraryTablesRegistrar.PROJECT_LEVEL, module.getProject());
        for (Library lib : libraryTable.getLibraries()) {
            VirtualFile[] files = lib.getFiles(OrderRootType.CLASSES);
            for (VirtualFile jarFile : files) {
                for (String url : schemaUrlsAndFileNames.keySet()) {
                    String fileName = schemaUrlsAndFileNames.get(url);
                    VirtualFile schemaFile = VfsUtil.findRelativeFile(fileName, jarFile);
                    if (schemaFile != null) {
                        //LOG.warn("Found " + fileName + " in " + jarFile.getUrl());
                        PsiFile psiFile = PsiManager.getInstance(project).findFile(schemaFile);
                        final XmlFile xmlFile = (XmlFile) psiFile.copy();
                        if (xmlFile != null) {
                            schemas.put(url, xmlFile);
                        }
                    }
                }
            }
        }

        return new CachedValueProvider.Result<Map<String, XmlFile>>(schemas, dependencies.toArray());
    }

    @Nullable
    private static String getNamespace(final XmlFile xmlFile, final Project project) {
        final XmlDocument document = xmlFile.getDocument();
        if (document != null) {
            final PsiMetaData metaData = document.getMetaData();
            if (metaData instanceof XmlNSDescriptorImpl) {
                return ((XmlNSDescriptorImpl) metaData).getDefaultNamespace();
            }
        }
        return null;
    }

    /*********************************************************************************************************************************************************
     Provides Map of schema url -> XSD name per Module
     *********************************************************************************************************************************************************/
    private class SchemaFileNamesCachedProvider implements ParameterizedCachedValueProvider<Map<String, String>, Module> {
        @Nullable
        @Override
        public CachedValueProvider.Result<Map<String, String>> compute(Module module) {
            try {
                ArrayList<Object> dependencies = new ArrayList<Object>();
                dependencies.add(ProjectRootManager.getInstance(module.getProject()));

                //final ClassLoader cl = ClasspathUtils.getModuleClassLoader(module, this.getClass().getClassLoader());
                Map<String, String> schemas = getSchemasFromSpringSchemas(module);
                return CachedValueProvider.Result.create(schemas, dependencies);
            } catch (Exception e) {
                return null;
            }
        }

        private Map<String, String> parseSpringSchemas(String springSchemasContent) {
            BidiMap schemaUrlsAndFileNames = new TreeBidiMap();
            for (String line : springSchemasContent.split("\n")) {
                if (line != null && !line.startsWith("#") && line.contains("=")) {
                    String url = line.substring(0, line.indexOf("=")).replaceAll("\\\\", "");
                    String fileName = line.substring(line.indexOf("=") + 1);

                    if (schemaUrlsAndFileNames.containsValue(fileName)) {
                        if (url.contains("current")) { //Avoid duplicates and prefer URL with "current"
                            schemaUrlsAndFileNames.removeValue(fileName);
                            schemaUrlsAndFileNames.put(url, fileName);
                        }
                    } else {
                        schemaUrlsAndFileNames.put(url, fileName);
                    }
                }
            }
            return schemaUrlsAndFileNames;
        }

        private Map<String, String> getSchemasFromSpringSchemas(@NotNull Module module) throws Exception {
            //LOG.warn("Loading schemas for module " + module.getName());
            Map<String, String> schemasMap = new HashMap<>();

            LibraryTable libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTableByLevel(LibraryTablesRegistrar.PROJECT_LEVEL, module.getProject());
            for (Library lib : libraryTable.getLibraries()) {
                VirtualFile[] files = lib.getFiles(OrderRootType.CLASSES);
                for (VirtualFile jarFile : files) {
                    VirtualFile springSchemasFile = VfsUtil.findRelativeFile("META-INF/spring.schemas", jarFile);
                    if (springSchemasFile != null) {
                        String springSchemasContent = new String(springSchemasFile.contentsToByteArray());
                        schemasMap.putAll(parseSpringSchemas(springSchemasContent));
                    }
                }
            }
            //LOG.warn("Schemas map for module " + module.getName() + " is " + schemasMap);

            return schemasMap;
        }
    }

    /*********************************************************************************************************************************************************
     Provides cached XSD file
     *********************************************************************************************************************************************************/
    //private class SchemaFileCachedProvider implements

}