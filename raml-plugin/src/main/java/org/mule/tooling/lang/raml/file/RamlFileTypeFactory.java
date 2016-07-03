package org.mule.tooling.lang.raml.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class RamlFileTypeFactory extends FileTypeFactory
{
    public void createFileTypes(@NotNull FileTypeConsumer consumer)
    {
        consumer.consume(RamlFileType.INSTANCE, RamlFileType.EXTENSIONS);
    }
}
