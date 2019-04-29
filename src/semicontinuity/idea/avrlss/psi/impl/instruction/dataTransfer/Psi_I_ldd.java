package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

public class Psi_I_ldd extends Psi_I_ptr {
    public Psi_I_ldd(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int changedRegisters() {
        return super.changedRegisters() | (1 << register());
    }

    @Override
    protected int indexOfPsiChildForPointerArgument() {
        return 1;
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }
}
