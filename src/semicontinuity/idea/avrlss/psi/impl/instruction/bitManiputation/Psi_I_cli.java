package semicontinuity.idea.avrlss.psi.impl.instruction.bitManiputation;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_cli extends PsiInstruction {
    public Psi_I_cli(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte changedFlags() {
        return FLAG_I0;
    }
}
