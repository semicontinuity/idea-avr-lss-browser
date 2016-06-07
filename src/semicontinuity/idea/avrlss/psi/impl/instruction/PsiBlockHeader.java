package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;


public class PsiBlockHeader extends ASTWrapperPsiElement {
    public PsiBlockHeader(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public PsiBlockAddress getBlockAddress() {
        return (PsiBlockAddress) getChildren()[0];
    }

    public PsiBlockName getBlockName() {
        return (PsiBlockName) getChildren()[1];
    }


    public CharSequence getLabelAddress() {
        return getFirstChild().getChildren()[0].getText();
    }

    public String getLabel() {
        return getFirstChild().getChildren()[2].getText();
    }
}
