package org.mule.config.completion;

import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.XmlTagInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.RangeMarker;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.IncorrectOperationException;
import com.intellij.xml.XmlElementDescriptor;
import com.intellij.xml.XmlExtension;
import com.intellij.xml.XmlNamespaceHelper;
import com.intellij.xml.XmlSchemaProvider;
import com.intellij.xml.impl.schema.AnyXmlElementDescriptor;
import org.jetbrains.annotations.Nullable;
import org.mule.util.MuleSchemaUtils;

import java.util.Collections;
import java.util.Set;

public class MuleElementInsertHandler extends XmlTagInsertHandler {

    private static final Logger LOG = Logger.getInstance(MuleElementInsertHandler.class.getName());

    private String localName;
    private String prefix;
    private String namespace;
    private String locationLookup;

    public MuleElementInsertHandler(String localName, String prefix, String namespace, String locationLookup) {
        this.localName = localName;
        this.prefix = prefix;
        this.namespace = namespace;
        this.locationLookup = locationLookup;
    }

    @Override
    public void handleInsert(final InsertionContext context, final LookupElement item) {
        final XmlFile contextFile = (XmlFile) context.getFile();
        final XmlExtension extension = XmlExtension.getExtension(contextFile);
        final XmlFile file = extension.getContainingFile(contextFile);
        final Project project = context.getProject();

        assert file != null;
        final PsiElement psiElement = file.findElementAt(context.getStartOffset());
        assert psiElement != null;
        if (isNamespaceBound(psiElement)) {
            doDefault(context, item);
            return;
        }

        final Editor editor = context.getEditor();
        final Document document = editor.getDocument();
        PsiDocumentManager.getInstance(project).commitDocument(document);

        final int caretOffset = editor.getCaretModel().getOffset();
        final RangeMarker caretMarker = document.createRangeMarker(caretOffset, caretOffset);
        caretMarker.setGreedyToRight(true);

        final XmlNamespaceHelper.Runner<String, IncorrectOperationException> runAfter =
                new XmlNamespaceHelper.Runner<String, IncorrectOperationException>() {

                    @Override
                    public void run(final String namespacePrefix) {

                        PsiDocumentManager.getInstance(project).commitDocument(document);
                        final PsiElement element = file.findElementAt(context.getStartOffset());
                        if (element != null) {
                            qualifyWithPrefix(namespacePrefix, element, document);
                            PsiDocumentManager.getInstance(project).commitDocument(document);
                        }
                        editor.getCaretModel().moveToOffset(caretMarker.getEndOffset());
                        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(document);
                        doDefault(context, item);
                    }
                };

        try {
            final String prefixByNamespace = getPrefixByNamespace(file, namespace);
            if (StringUtil.isEmpty(prefixByNamespace)) {
                //If it is not declared
                final String nsPrefix = prefix == null ? suggestPrefix(file, namespace) : prefix;
                final XmlNamespaceHelper helper = XmlNamespaceHelper.getHelper(file);
                helper.insertNamespaceDeclaration(file, editor, Collections.singleton(namespace), nsPrefix, runAfter);
                MuleSchemaUtils.insertSchemaLocationLookup(file, namespace, locationLookup);
            } else {
                runAfter.run(prefixByNamespace);    // qualify && complete
            }
        } catch (IncorrectOperationException e) {
            LOG.error(e);
        }
    }

    protected void doDefault(final InsertionContext context, final LookupElement item) {
        super.handleInsert(context, item);
    }

    protected boolean isNamespaceBound(PsiElement psiElement) {
        PsiElement parent = psiElement.getParent();
        if (!(parent instanceof XmlTag)) return false;
        final XmlTag tag = (XmlTag) parent;
        final XmlElementDescriptor tagDescriptor = tag.getDescriptor();
        final String tagNamespace = tag.getNamespace();
        return tagDescriptor != null && !(tagDescriptor instanceof AnyXmlElementDescriptor) && namespace.equals(tagNamespace);
    }

    @Nullable
    public static String getPrefixByNamespace(XmlFile file, final String namespace) {
        final XmlTag tag = file.getRootTag();
        return tag == null ? null : tag.getPrefixByNamespace(namespace);
    }

    @Nullable
    public static String suggestPrefix(XmlFile file, @Nullable String namespace) {
        if (namespace == null) {
            return null;
        }
        for (XmlSchemaProvider provider : XmlSchemaProvider.getAvailableProviders(file)) {
            String prefix = provider.getDefaultPrefix(namespace, file);
            if (prefix != null) {
                return prefix;
            }
        }
        return null;
    }

    protected Set<String> getNamespaces(final XmlFile file) {
        return XmlNamespaceHelper.getHelper(file).getNamespacesByTagName(localName, file);
    }

    protected void qualifyWithPrefix(final String namespacePrefix, final PsiElement element, final Document document) {
        qualifyWithPrefix(namespacePrefix, element);
    }

    public static void qualifyWithPrefix(final String namespacePrefix, final PsiElement element) {
        final PsiElement tag = element.getParent();
        if (tag instanceof XmlTag) {
            final String prefix = ((XmlTag) tag).getNamespacePrefix();
            if (!prefix.equals(namespacePrefix) && StringUtil.isNotEmpty(namespacePrefix)) {
                final String name = namespacePrefix + ":" + ((XmlTag) tag).getLocalName();
                try {
                    ((XmlTag) tag).setName(name);
                } catch (IncorrectOperationException e) {
                    LOG.error(e);
                }
            }
        }
    }
}
