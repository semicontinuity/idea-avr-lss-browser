package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM_mut;

public class Psi_I_ori extends Psi_IT_rM_mut {
    public Psi_I_ori(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() { return 1 << register(); }

    @Override
    public byte changedFlags() {
        return FLAG_S | FLAG_V/*0*/ | FLAG_N | FLAG_Z;
    }
}
