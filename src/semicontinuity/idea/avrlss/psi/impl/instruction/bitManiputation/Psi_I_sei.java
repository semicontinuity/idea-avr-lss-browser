package semicontinuity.idea.avrlss.psi.impl.instruction.bitManiputation;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_sei extends PsiInstruction {
    public Psi_I_sei(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte changedFlags() {
        return FLAG_I1;
    }
}
