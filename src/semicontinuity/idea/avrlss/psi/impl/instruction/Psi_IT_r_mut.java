package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class Psi_IT_r_mut extends Psi_IT_r {
    public Psi_IT_r_mut(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int changedRegisters() { return 1 << register(); }
}
