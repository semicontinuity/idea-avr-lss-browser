package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr;

public class Psi_I_movw extends Psi_IT_rr {
    public Psi_I_movw(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() { return (1 << secondRegister()) | (1 << (secondRegister() + 1)); }

    @Override
    public int changedRegisters() { return (1 << firstRegister()) | (1 << (firstRegister() + 1)); }
}
