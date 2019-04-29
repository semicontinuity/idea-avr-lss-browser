package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class Psi_IT_rM_mut extends Psi_IT_rM {
    public Psi_IT_rM_mut(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int clobberedRegisters() { return 1 << register(); }
}
