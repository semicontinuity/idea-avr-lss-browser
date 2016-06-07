package semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;

public class Psi_I_adiw extends PsiInstruction {
    public Psi_I_adiw(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public int affectedRegisters() { return (1 << register()) | (1 << (register() + 1)); }

    public int register() {
        return Integer.parseInt(getChildren()[0].getText().substring(1));
    }

    @Override
    public byte affectedFlags() {
        return FLAG_S | FLAG_V | FLAG_N | FLAG_Z | FLAG_C;
    }

}
