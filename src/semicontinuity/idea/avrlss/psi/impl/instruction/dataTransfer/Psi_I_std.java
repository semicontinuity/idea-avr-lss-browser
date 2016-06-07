package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

public class Psi_I_std extends Psi_I_ptr {
    public Psi_I_std(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    protected int pointerChild() {
        return 0;
    }
}
