package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r_mut;

public class Psi_I_clr extends Psi_IT_r_mut {
    public Psi_I_clr(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte changedFlags() {
        return FLAG_S0 | FLAG_V0 | FLAG_N0 | FLAG_Z1;
    }
}
