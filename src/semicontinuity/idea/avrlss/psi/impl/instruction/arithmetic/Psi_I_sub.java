package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr_mut;

public class Psi_I_sub extends Psi_IT_rr_mut {
    public Psi_I_sub(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() {
        return (1 << firstRegister()) | (1 << secondRegister());
    }

    @Override
    public byte clobberedFlags() {
        return FLAG_H | FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }
}
