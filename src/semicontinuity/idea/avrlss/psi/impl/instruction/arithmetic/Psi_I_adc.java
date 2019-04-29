package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr_mut;

public class Psi_I_adc extends Psi_IT_rr_mut {
    public Psi_I_adc(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() {
        return (1 << firstRegister()) | (1 << secondRegister());
    }

    @Override
    public byte usedFlags() {
        return FLAG_C;
    }

    @Override
    public byte clobberedFlags() {
        return FLAG_H | FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }
}
