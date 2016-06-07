package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class Psi_IT_rr extends PsiInstruction {
    public Psi_IT_rr(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public int firstRegister() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    public int secondRegister() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }

}
