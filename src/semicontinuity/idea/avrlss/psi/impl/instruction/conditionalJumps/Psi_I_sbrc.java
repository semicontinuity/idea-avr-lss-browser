package semicontinuity.idea.avrlss.psi.impl.instruction.conditionalJumps;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM;

public class Psi_I_sbrc extends Psi_IT_rM {
    public Psi_I_sbrc(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() {
        return 1 << register();
    }
}
