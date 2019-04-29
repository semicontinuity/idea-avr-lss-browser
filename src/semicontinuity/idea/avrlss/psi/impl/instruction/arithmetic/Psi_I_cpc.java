package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr;

public class Psi_I_cpc extends Psi_IT_rr {
    public Psi_I_cpc(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() {
        return (1 << firstRegister()) | (1 << secondRegister());
    }

    @Override
    public byte readFlags() {
        return FLAG_C;
    }

    @Override
    public byte changedFlags() {
        return FLAG_H | FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }
}
