/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mule.tooling.esb.sdk;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.framework.MuleLibraryKind;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nik
 */
public class MuleSdk {

    private static final String BOOT_DIR = "/lib/boot";
    private static final String PATCH_DIR = "/lib/patches";
    private static final String MULE_DIR = "/lib/mule";
    private static final String USER_DIR = "/lib/user";
    private static final String OPT_DIR = "/lib/opt";
    private static final String ENDORSED_DIR = "/lib/endorsed";

    public static final String UNDEFINED_VERSION = "0.0.0";

    static List<String> MULE_JARS_FOLDERS = Arrays.asList(BOOT_DIR, ENDORSED_DIR, PATCH_DIR, MULE_DIR, USER_DIR, OPT_DIR);
    private static List<String> MULE_REQUIRED_FOLDERS = Arrays.asList(BOOT_DIR, MULE_DIR, USER_DIR, OPT_DIR);
    private static final String BIN_DIR = "/bin";
    private static final Logger LOG = Logger.getInstance("#com.intellij.appengine.sdk.impl.MuleSdk");
    private static final Pattern VERSION_NUMBER = Pattern.compile("([0-9]\\.[0-9]\\.[0-9])");

    @Tag("mule-home")
    private String muleHome;

    public MuleSdk() {
    }

    public MuleSdk(String homePath) {
        this.muleHome = homePath;
    }

    public String getMuleHome() {
        return muleHome;
    }

    public void setMuleHome(String muleHome) {
        this.muleHome = muleHome;
    }

    @NotNull
    public String getVersion() {
        final File file = new File(getMuleHome());
        final String distroName = file.getName();
        final Matcher matcher = VERSION_NUMBER.matcher(distroName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return UNDEFINED_VERSION;
    }

    @NotNull
    public List<File> getLibraryEntries() {
        final File muleHome = new File(this.muleHome);
        final List<File> muleClassPath = new MuleClassPath(muleHome).getJars();
        List<File> result = new ArrayList<>();
        for (File file : muleClassPath) {
            //No directory
            if (file.isFile()) {
                result.add(file);
            }
        }

        //We add the plugins lib
        final File pluginsFolder = new File(muleHome, "plugins");
        final File[] files = pluginsFolder.listFiles();
        if (files != null) {
            for (File plugin : files) {
                //Exclude debugger
                if (!plugin.getName().contains("debugger")) {
                    final File lib = new File(plugin, "lib");
                    if (lib.exists()) {
                        final File[] libJars = lib.listFiles();
                        for (File jar : libJars) {
                            result.add(jar);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return getVersion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MuleSdk muleSdk = (MuleSdk) o;

        return muleHome != null ? muleHome.equals(muleSdk.muleHome) : muleSdk.muleHome == null;

    }

    @Override
    public int hashCode() {
        return muleHome != null ? muleHome.hashCode() : 0;
    }


    //Helper methods

    @Nullable
    public static MuleSdk getFrom(Module module) {
        final String muleHome = getMuleHome(module);
        if (muleHome != null) {
            return new MuleSdk(muleHome);
        } else {
            return null;
        }
    }

    @Nullable
    private static String getMuleHome(@NotNull Module module) {
        if (!DumbService.isDumb(module.getProject())) {
            final OrderEnumerator enumerator = ModuleRootManager.getInstance(module)
                    .orderEntries().recursively().librariesOnly().exportedOnly();
            final String[] home = new String[1];
            enumerator.forEachLibrary(library -> {

                if (MuleLibraryKind.MULE_LIBRARY_KIND.equals(((LibraryEx) library).getKind())) {
                    home[0] = getMuleHome(library.getFiles(OrderRootType.CLASSES)[0]);
                    return false;
                } else {
                    return true;
                }
            });

            return home[0];
        }
        return null;
    }

    public static boolean isValidMuleHome(String dir) {
        if (dir == null) {
            return false;
        }
        final File muleHome = new File(dir);
        for (String muleJarsFolder : MULE_REQUIRED_FOLDERS) {
            if (!new File(muleHome, muleJarsFolder).exists()) {
                return false;
            }
        }
        //Check bin directory
        return new File(muleHome, BIN_DIR).exists();
    }


    @Nullable
    public static String getMuleHome(VirtualFile local) {
        if (local != null) {
            File parent = new File(local.getPath()).getParentFile();
            if (parent != null) {
                parent = parent.getParentFile();

                if (parent != null) {
                    if (isValidMuleHome(parent.getPath())) {
                        return parent.getPath();
                    } else if (parent.getParent() != null && isValidMuleHome(parent.getParentFile().getPath())) {
                        return parent.getParentFile().getPath();
                    }
                }
            }
        }
        return null;
    }
}
