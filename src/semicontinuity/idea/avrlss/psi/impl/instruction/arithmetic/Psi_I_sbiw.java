package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_sbiw extends PsiInstruction {
    public Psi_I_sbiw(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int readRegisters() { return (1 << register()) | (1 << (register() + 1)); }

    @Override
    public int changedRegisters() { return (1 << register()) | (1 << (register() + 1)); }

    private int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    @Override
    public byte changedFlags() {
        return FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }
}
