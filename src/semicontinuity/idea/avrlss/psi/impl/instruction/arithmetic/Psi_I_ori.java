package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_rM_mut;

public class Psi_I_ori extends Psi_IT_rM_mut {
    public Psi_I_ori(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte affectedFlags() {
        return FLAG_S | FLAG_V/*0*/ | FLAG_N | FLAG_Z;
    }

}
