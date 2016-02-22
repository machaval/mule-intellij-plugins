package org.mule.lang.mel;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.util.MuleIcons;

import javax.swing.*;


public class MelFileType extends LanguageFileType {

    private static MelFileType instance = new MelFileType();

    protected MelFileType() {
        super(MelLanguage.getInstance());
    }

    @NotNull
    @Override
    public String getName() {
        return "Mel";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Mel";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "mel";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MuleIcons.MelFIleType;
    }

    public static MelFileType getInstance(){
        return instance;
    }
}
