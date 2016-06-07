package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;

public class Psi_IT_r extends PsiInstruction {
    public Psi_IT_r(ASTNode astNode) {
        super(astNode);
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }
}
