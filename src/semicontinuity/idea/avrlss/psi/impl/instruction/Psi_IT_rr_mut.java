package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class Psi_IT_rr_mut extends Psi_IT_rr {
    public Psi_IT_rr_mut(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public int affectedRegisters() { return 1 << firstRegister(); }
}
