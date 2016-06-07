package semicontinuity.idea.avrlss.psi.impl.instruction.subroutine;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_reti extends PsiInstruction {
    public Psi_I_reti(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte affectedFlags() {
        return FLAG_I1;
    }
}
