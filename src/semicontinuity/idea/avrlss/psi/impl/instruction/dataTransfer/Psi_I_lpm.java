package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

/**
 * TODO: implement?
 * LPM
 * LPM Rd, Z
 * LPM Rd, Z+
 */
public class Psi_I_lpm extends Psi_I_ptr {
    public Psi_I_lpm(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() {
        int usedRegisters = super.readRegisters();
        return usedRegisters == 0 ? ((1 << 30) | (1 << 31)) : usedRegisters;
    }

    @Override
    public int changedRegisters() {
        // register is optional, R0 if not specified
        return super.changedRegisters() | (1 << register());
    }

    @Override
    protected int indexOfPsiChildForPointerArgument() {
        return 1;
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }
}
