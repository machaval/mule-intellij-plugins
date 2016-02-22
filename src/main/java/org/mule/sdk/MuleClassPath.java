package org.mule.sdk;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Constructs a default set of JAR Urls located under Mule home folder.
 */
public class MuleClassPath {

    private List<File> urls = new ArrayList<>();

    /**
     * Constructs a new MuleClassPath.
     *
     * @param muleHome Mule home directory
     */
    public MuleClassPath(File muleHome) {
        for (String muleFolder : MuleSdk.MULE_JARS_FOLDERS) {
            final File userDir = new File(muleHome, muleFolder);
            this.addFile(userDir);
            this.addFiles(this.listJars(userDir));
        }
    }

    /**
     * @return A copy of 'urls'.
     */
    public List<File> getJars() {
        return new ArrayList<>(this.urls);
    }


    public void addFiles(List<File> files) {
        for (File file : files) {
            this.addFile(file);
        }
    }

    public void addFile(File jar) {
        this.urls.add(jar);

    }

    /**
     * Find and if necessary filter the jars for classpath.
     *
     * @return a list of {@link File}s
     */
    protected List<File> listJars(File path) {
        File[] jars = path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                try {
                    //Filter mmc
                    return !pathname.getName().startsWith("mmc") && pathname.getCanonicalPath().endsWith(".jar");
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        });

        if (jars == null) {
            return Collections.emptyList();
        } else {
            return Arrays.<File>asList(jars);
        }
    }
}