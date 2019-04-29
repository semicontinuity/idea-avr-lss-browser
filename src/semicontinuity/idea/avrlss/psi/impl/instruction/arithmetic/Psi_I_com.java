package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r_mut;

public class Psi_I_com extends Psi_IT_r_mut {
    public Psi_I_com(@NotNull ASTNode astNode) {
        super(astNode);
    }


    @Override
    public int readRegisters() { return 1 << register(); }

    @Override
    public byte changedFlags() {
        return FLAG_S | FLAG_V0 | FLAG_N | FLAG_Z | FLAG_C1;
    }
}
