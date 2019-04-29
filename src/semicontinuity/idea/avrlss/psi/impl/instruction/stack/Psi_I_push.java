package semicontinuity.idea.avrlss.psi.impl.instruction.stack;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r_mut;

public class Psi_I_push extends Psi_IT_r {
    public Psi_I_push(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() { return 1 << register(); }
}
