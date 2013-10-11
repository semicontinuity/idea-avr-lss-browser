package semicontinuity.idea.avrlss.parsing;

import com.intellij.psi.tree.IElementType;
import semicontinuity.idea.avrlss.AvrLssLanguage;

public class AvrLssElementType extends IElementType {
    public AvrLssElementType(String debugName) {
        super(debugName, AvrLssLanguage.INSTANCE);
    }

    public String toString() {
        return "Literal:" + super.toString();
    }
}