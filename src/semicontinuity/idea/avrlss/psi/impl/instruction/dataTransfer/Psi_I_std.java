package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_I_ptr;

public class Psi_I_std extends Psi_I_ptr {
    public Psi_I_std(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() {
        return super.usedRegisters() | (1 << register());
    }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    @Override
    protected int indexOfPsiChildForPointerArgument() {
        return 0;
    }
}
