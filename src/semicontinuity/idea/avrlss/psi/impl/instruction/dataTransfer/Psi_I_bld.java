package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM_mut;

public class Psi_I_bld extends Psi_IT_rM_mut {
    public Psi_I_bld(@NotNull ASTNode astNode) {
        super(astNode);
    }


    @Override
    public int changedRegisters() { return 1 << register(); }

    @Override
    public byte readFlags() {
        return FLAG_T;
    }
}
