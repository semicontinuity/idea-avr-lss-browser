package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_mul extends PsiInstruction {
    public Psi_I_mul(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public int affectedRegisters() { return (1 << 0) | (1 << 1); }

    public int register1() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    public int register2() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }

    @Override
    public byte affectedFlags() {
        return FLAG_Z | FLAG_C;
    }

}
