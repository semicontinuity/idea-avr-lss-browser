package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

public class Psi_I_st extends Psi_I_ptr {
    public Psi_I_st(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    protected int indexOfPsiChildForPointerArgument() {
        return 0;
    }
}
