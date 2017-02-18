package org.mule.tooling.esb.launcher.configuration.archive;


import com.intellij.execution.ExecutionException;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.CompilerModuleExtension;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FilenameFilter;

public class MuleAppMavenHandler implements MuleAppHandler
{

    @NotNull
    @Override
    public File getMuleApp(final Module module) throws ExecutionException
    {
        String outputPath = null;
        final File outputDir;

        final CompilerModuleExtension compilerModuleExtension = CompilerModuleExtension.getInstance(module);
        final VirtualFile moduleFile = module.getModuleFile();
        if (compilerModuleExtension != null && moduleFile != null)
        {
            //Refresh file system
            module.getModuleFile().refresh(false, true);
            VirtualFile compilerOutputPath = compilerModuleExtension.getCompilerOutputPath();

            if (compilerOutputPath != null && compilerOutputPath.getParent() != null) {
                outputPath = compilerOutputPath.getParent().getCanonicalPath();
                outputDir = new File(outputPath);
            } else {
                outputPath = module.getModuleFile().getParent().getCanonicalPath() + File.separator + "target";
                outputDir = new File(module.getModuleFile().getParent().getCanonicalPath(), "target");
            }

            File applicationZip = null;
            final File[] zips = outputDir.listFiles(new FilenameFilter()
            {
                @Override
                public boolean accept(File dir, String name)
                {
                    return name.endsWith("zip");
                }
            });
            if (zips.length > 0)
            {
                applicationZip = zips[0];
            }
            if (applicationZip == null)
            {
                throw new ExecutionException("Unable to create application. Application was not found at " + outputPath);
            }
            return applicationZip;
//            }
//            else
//            {
//                throw new ExecutionException("Unable to create application. No output path was found.");
//            }
        }
        else
        {
            throw new ExecutionException("Unable to create application. No module found.");
        }
    }


}
