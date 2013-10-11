package semicontinuity.idea.avrlss.psi.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import semicontinuity.idea.avrlss.AvrLssFileType;
import org.jetbrains.annotations.NotNull;

public class AvrLssFileImpl extends PsiFileBase {
    public AvrLssFileImpl(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AvrLssFileType.FILE_TYPE.getLanguage());
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AvrLssFileType.FILE_TYPE;
    }
}
