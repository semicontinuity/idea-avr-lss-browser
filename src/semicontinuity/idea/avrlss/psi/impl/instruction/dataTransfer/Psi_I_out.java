package semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_out extends PsiInstruction {
    public Psi_I_out(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int usedRegisters() { return 1 << register(); }

    public int register() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }
}
