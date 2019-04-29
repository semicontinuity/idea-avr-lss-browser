package semicontinuity.idea.avrlss.psi.impl.instruction.subroutine;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_icall extends PsiInstruction {
    public Psi_I_icall(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() {
        return (1 << 30) | (1 << 31);
    }
}
