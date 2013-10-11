package semicontinuity.idea.avrlss;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.encoding.EncodingManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;
import java.nio.charset.Charset;


public class AvrLssFileType extends LanguageFileType {
    public static final Icon FILE_ICON = IconLoader.getIcon("/fileTypes/properties.png");
    public static final LanguageFileType FILE_TYPE = new AvrLssFileType();
    @NonNls
    public static final String DEFAULT_EXTENSION = "lss";


    private AvrLssFileType() {
        super(AvrLssLanguage.INSTANCE);
    }

    @NotNull
    public String getName() {
        return "AVR LSS";
    }

    @NotNull
    public String getDescription() {
        return "AVR LSS";
    }

    @NotNull
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    public Icon getIcon() {
        return FILE_ICON;
    }

    public String getCharset(@NotNull VirtualFile file, final byte[] content) {
        Charset charset = EncodingManager.getInstance().getDefaultCharsetForPropertiesFiles(file);
        return charset == null ? CharsetToolkit.getDefaultSystemCharset().name() : charset.name();
    }
}