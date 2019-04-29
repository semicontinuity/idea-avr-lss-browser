package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM;

public class Psi_I_cpi extends Psi_IT_rM {
    public Psi_I_cpi(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() { return 1 << register(); }

    @Override
    public byte changedFlags() {
        return FLAG_H | FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }
}
