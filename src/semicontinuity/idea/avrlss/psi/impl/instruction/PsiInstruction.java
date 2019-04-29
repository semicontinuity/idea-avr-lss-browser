package semicontinuity.idea.avrlss.psi.impl.instruction;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;


public class PsiInstruction extends ASTWrapperPsiElement {
    public PsiInstruction(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public static final byte FLAG_C = 1;
    public static final byte FLAG_C0 = 1;
    public static final byte FLAG_C1 = 1;
    public static final byte FLAG_Z = 1<<1;
    public static final byte FLAG_Z0 = 1<<1;
    public static final byte FLAG_Z1 = 1<<1;
    public static final byte FLAG_N = 1<<2;
    public static final byte FLAG_N0 = 1<<2;
    public static final byte FLAG_N1 = 1<<2;
    public static final byte FLAG_V = 1<<3;
    public static final byte FLAG_V0 = 1<<3;
    public static final byte FLAG_V1 = 1<<3;
    public static final byte FLAG_S = 1<<4;
    public static final byte FLAG_S0 = 1<<4;
    public static final byte FLAG_S1 = 1<<4;
    public static final byte FLAG_H = 1<<5;
    public static final byte FLAG_T = 1<<6;
    public static final byte FLAG_I = (byte) (1<<7);
    public static final byte FLAG_I1 = (byte) (1<<7);
    public static final byte FLAG_I0 = (byte) (1<<7);

    public int clobberedRegisters() { return 0; }

    public int usedRegisters() { return 0; }

    public byte clobberedFlags() { return 0; }

    public byte usedFlags() { return 0; }
}
