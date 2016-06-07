package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r_mut;

public class Psi_I_dec extends Psi_IT_r_mut {
    public Psi_I_dec(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte affectedFlags() {
        return FLAG_S | FLAG_V | FLAG_N | FLAG_Z;
    }
}
