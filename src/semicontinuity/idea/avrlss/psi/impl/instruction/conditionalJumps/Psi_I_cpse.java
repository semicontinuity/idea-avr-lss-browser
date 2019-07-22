package semicontinuity.idea.avrlss.psi.impl.instruction.conditionalJumps;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr;

public class Psi_I_cpse extends Psi_IT_rr {
    public Psi_I_cpse(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() {
        return (1 << firstRegister()) | (1 << secondRegister());
    }
}
