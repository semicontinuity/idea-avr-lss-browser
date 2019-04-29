package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public abstract class Psi_I_ptr extends PsiInstruction {
    public Psi_I_ptr(ASTNode astNode) {
        super(astNode);
    }

    @Override
    public int changedRegisters() {
        int register = clobberedPointerRegisterOrMinusOne();
        return register == -1 ? 0 : (1 << register) | (1 << register + 1);
    }

    @Override
    public int readRegisters() {
        int register = pointerRegisterOrMinusOne();
        return register == -1 ? 0 : (1 << register) | (1 << register + 1);
    }

    private int clobberedPointerRegisterOrMinusOne() {
        PsiElement[] children = getChildren();
        if (children.length == 0) return -1;
        String r = children[indexOfPsiChildForPointerArgument()].getText();
        if (r.contains("+") || r.contains("-")) {
            return parse(r);
        } else {
            return -1;
        }
    }

    private int pointerRegisterOrMinusOne() {
        PsiElement[] children = getChildren();
        if (children.length == 0) return -1;
        String r = children[indexOfPsiChildForPointerArgument()].getText();
        return parse(r);
    }

    private static int parse(String r) {
        if (r.contains("X"))
            return 26;
        else if (r.contains("Y"))
            return 28;
        else if (r.contains("Z"))
            return 30;
        else
            throw new IllegalStateException(r);
    }


    protected abstract int indexOfPsiChildForPointerArgument();
}
