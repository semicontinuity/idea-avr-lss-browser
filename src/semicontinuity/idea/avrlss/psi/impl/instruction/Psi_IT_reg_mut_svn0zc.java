package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;

public class Psi_IT_reg_mut_svn0zc extends Psi_IT_r_mut {
    public Psi_IT_reg_mut_svn0zc(ASTNode astNode) {
        super(astNode);
    }

    @Override
    public byte changedFlags() {
        return FLAG_S | FLAG_V | FLAG_N0 | FLAG_Z | FLAG_C;
    }
}
