package semicontinuity.idea.avrlss;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class AvrLssFileTypeFactory extends FileTypeFactory {
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(AvrLssFileType.FILE_TYPE, AvrLssFileType.DEFAULT_EXTENSION);
    }
}