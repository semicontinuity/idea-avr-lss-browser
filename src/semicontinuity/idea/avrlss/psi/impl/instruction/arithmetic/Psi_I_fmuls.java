package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_fmuls extends PsiInstruction {
    public Psi_I_fmuls(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int clobberedRegisters() {
        //noinspection PointlessBitwiseExpression
        return (1 << 0) | (1 << 1); }

    @Override
    public int usedRegisters() {
        return (1 << firstRegister()) | (1 << secondRegister());
    }

    private int firstRegister() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    private int secondRegister() {
        return Integer.parseInt(getChildren()[1].getText().substring(1));
    }

    @Override
    public byte clobberedFlags() {
        return FLAG_Z | FLAG_C;
    }
}
