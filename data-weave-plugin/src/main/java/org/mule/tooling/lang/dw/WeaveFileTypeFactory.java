package org.mule.tooling.lang.dw;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class WeaveFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        WeaveFileType weaveFileType = WeaveFileType.getInstance();

        for (String extension : weaveFileType.getExtensions())
            fileTypeConsumer.consume(weaveFileType, extension);
    }
}
