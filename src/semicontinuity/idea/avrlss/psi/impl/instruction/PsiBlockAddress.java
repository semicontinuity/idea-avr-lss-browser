package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;


public class PsiBlockAddress extends ASTWrapperPsiElement {
    public PsiBlockAddress(@NotNull ASTNode astNode) {
        super(astNode);
    }
}
