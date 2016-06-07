package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM_mut;

public class Psi_I_out extends PsiInstruction {
    public Psi_I_out(@NotNull ASTNode astNode) {
        super(astNode);
    }

/*
    public int affectedRegisters() { return 1 << register(); }

    public int register() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }
*/
}
