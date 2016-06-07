package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rr_mut;

public class Psi_I_eor extends Psi_IT_rr_mut {
    public Psi_I_eor(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte affectedFlags() {
        return FLAG_S | FLAG_V/*0*/ | FLAG_N | FLAG_Z;
    }
}
