package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_muls extends PsiInstruction {
    public Psi_I_muls(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int changedRegisters() { return (1 << 0) | (1 << 1); }

    @Override
    public int readRegisters() { return (1 << register1()) | (1 << register2()); }

    public int register1() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    public int register2() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }

    @Override
    public byte changedFlags() {
        return FLAG_Z | FLAG_C;
    }

}
