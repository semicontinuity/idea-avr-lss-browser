package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;


public class PsiBlockName extends ASTWrapperPsiElement {
    public PsiBlockName(@NotNull ASTNode astNode) {
        super(astNode);
    }
}
