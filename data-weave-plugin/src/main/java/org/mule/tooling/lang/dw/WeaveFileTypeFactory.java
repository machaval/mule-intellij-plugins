package org.mule.tooling.lang.dw;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class WeaveFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(WeaveFileType.getInstance(), "wev");
        fileTypeConsumer.consume(WeaveFileType.getInstance(), "dw");
    }
}
