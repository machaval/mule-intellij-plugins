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
package org.mule.sdk;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.launcher.configuration.runner.MuleRunnerCommandLine;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nik
 */
public class MuleSdk {

    protected static final String BOOT_DIR = "/lib/boot";
    protected static final String PATCH_DIR = "/lib/patches";
    protected static final String MULE_DIR = "/lib/mule";
    protected static final String USER_DIR = "/lib/user";
    protected static final String OPT_DIR = "/lib/opt";
    
    protected static final String ENDORSED_DIR = "/lib/endorsed";
    
    public static final String UNDEFINED_VERSION = "0.0.0";

    public static List<String> MULE_JARS_FOLDERS = Arrays.asList(BOOT_DIR, ENDORSED_DIR, PATCH_DIR, MULE_DIR, USER_DIR, OPT_DIR);
    public static List<String> MULE_REQUIRED_FOLDERS = Arrays.asList(BOOT_DIR, MULE_DIR, USER_DIR, OPT_DIR);
    protected static final String BIN_DIR = "/bin";
    private static final Logger LOG = Logger.getInstance("#com.intellij.appengine.sdk.impl.MuleSdk");

    private final String muleHome;
    private MuleClassPath classPath;
    public static final Pattern VERSION_NUMBER = Pattern.compile("([0-9]\\.[0-9]\\.[0-9])");


    public MuleSdk(String homePath) {
        muleHome = homePath;
        this.classPath = new MuleClassPath(new File(muleHome));
    }

    public static boolean isValidMuleHome(String dir) {
        final File muleHome = new File(dir);
        for (String muleJarsFolder : MULE_REQUIRED_FOLDERS) {
            if (!new File(muleHome, muleJarsFolder).exists()) {
                return false;
            }
        }
        //Check bin directory
        return new File(muleHome, BIN_DIR).exists();
    }

    @NotNull
    public String getSdkHomePath() {
        return muleHome;
    }

    @NotNull
    public String getVersion() {
        final File file = new File(getSdkHomePath());
        final String distroName = file.getName();
        final Matcher matcher = VERSION_NUMBER.matcher(distroName);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return UNDEFINED_VERSION;
    }

    @NotNull
    public List<File> getLibs() {
        return classPath.getJars();
    }


    @Nullable
    public static MuleSdk getFrom(Module module) {
        final String muleHome = getMuleHome(module);
        if (muleHome != null) {
            return new MuleSdk(muleHome);
        }else {
            return null;
        }
    }


    @Nullable
    private static String getMuleHome(@NotNull Module module) {
        if (!DumbService.isDumb(module.getProject())) {
            final VirtualFile local = LibraryUtil.findJarWithClass(module, MuleRunnerCommandLine.MAIN_CLASS);
            String parent = getMuleHome(local);
            if (parent != null)
                return parent;
        }
        return null;
    }

    @Nullable
    public static String getMuleHome(VirtualFile local) {
        if (local != null) {
            VirtualFile parent = local.getParent();
            if (parent != null) {
                parent = parent.getParent();
                if (parent != null) {
                    if ("lib".equals(parent.getName()) && parent.getParent() != null && isValidMuleHome(parent.getParent().getPath())) {
                        return parent.getParent().getPath();
                    }
                }
            }
        }
        return null;
    }
}
