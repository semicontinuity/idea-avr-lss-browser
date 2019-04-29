package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

/**
 * TODO: implement
 * variants:
 * SPM
 * SPM Z+
 */
public class Psi_I_spm extends Psi_I_ptr {
    public Psi_I_spm(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() {
        //noinspection PointlessBitwiseExpression
        return super.usedRegisters() | (1 << 0) | (1 << 1);
    }

    @Override
    public int clobberedRegisters() {
        return super.clobberedRegisters() | (1 << register());
    }

    @Override
    protected int indexOfPsiChildForPointerArgument() {
        return 1;
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }
}
