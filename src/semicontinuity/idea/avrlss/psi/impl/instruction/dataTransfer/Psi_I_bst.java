package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM;

public class Psi_I_bst extends Psi_IT_rM {
    public Psi_I_bst(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() { return 1 << register(); }

    @Override
    public byte changedFlags() {
        return FLAG_T;
    }
}
