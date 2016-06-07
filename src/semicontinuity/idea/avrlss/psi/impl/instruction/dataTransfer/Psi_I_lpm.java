package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM_mut;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

public class Psi_I_lpm extends Psi_I_ptr {
    public Psi_I_lpm(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public int affectedRegisters() {
        return super.affectedRegisters() | (1 << register());
    }

    @Override
    protected int pointerChild() {
        return 1;
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

}
