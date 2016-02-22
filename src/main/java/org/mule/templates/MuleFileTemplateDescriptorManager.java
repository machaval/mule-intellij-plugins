package org.mule.templates;


import com.intellij.ide.fileTemplates.FileTemplateDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import org.mule.util.MuleIcons;

public class MuleFileTemplateDescriptorManager implements FileTemplateGroupDescriptorFactory {
    public static final String MULE_CONFIGURATION_FILE = "Mule Config";
    public static final String DATA_WEAVE_FILE = "Data Weave";
    public static final String MEL_FILE = "Mel File";

    @Override
    public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
        final FileTemplateGroupDescriptor group = new FileTemplateGroupDescriptor("Mule", MuleIcons.MuleIcon);
        group.addTemplate(new FileTemplateDescriptor(MULE_CONFIGURATION_FILE, MuleIcons.MuleFileType));
        group.addTemplate(new FileTemplateDescriptor(DATA_WEAVE_FILE, MuleIcons.DataFileType));
        return group;
    }
}
