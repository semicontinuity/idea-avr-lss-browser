package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public abstract class Psi_I_ptr extends PsiInstruction {
    public Psi_I_ptr(ASTNode astNode) {
        super(astNode);
    }

    public int affectedRegisters() {
        int register = register();
        return register == -1 ? 0 : (1 << register) | (1 << register + 1);
    }

    private int register() {
        PsiElement[] children = getChildren();
        if (children.length == 0) return 0;
        String r = children[pointerChild()].getText();
        if (r.contains("+") || r.contains("-")) {
            if (r.contains("X"))
                return 26;
            else if (r.contains("Y"))
                return 28;
            else if (r.contains("Z"))
                return 30;
            else
                throw new IllegalStateException(r);
        } else {
            return -1;
        }
    }

    protected abstract int pointerChild();
}
