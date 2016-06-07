package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;


public class PsiBlock extends ASTWrapperPsiElement {
    public PsiBlock(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public PsiBlockHeader getHeader() {
        return (PsiBlockHeader) getFirstChild();
    }

    public CharSequence getLabelAddress() {
        return getFirstChild().getChildren()[0].getText();
    }

    public String getLabel() {
        return getFirstChild().getChildren()[2].getText();
    }
}
