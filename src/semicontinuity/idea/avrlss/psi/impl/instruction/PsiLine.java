package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.parsing.AvrLssTokenTypes;


public class PsiLine extends ASTWrapperPsiElement {
    public PsiLine(@NotNull ASTNode astNode) {
        super(astNode);
    }
}
