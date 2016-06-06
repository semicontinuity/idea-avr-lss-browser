package semicontinuity.idea.avrlss.parsing;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public interface AvrLssElementTypes {
    IStubElementType REFERENCE = new ReferenceStubElementType();

    IElementType SYMBOL_LINE = new AvrLssElementType("SYMBOL_LINE");
    IElementType LINE = new AvrLssElementType("LINE");
    IElementType OCTETS = new AvrLssElementType("OCTETS");
    IElementType INSTRUCTION = new AvrLssElementType("INSTRUCTION");
    IElementType TEXT = new AvrLssElementType("TEXT");
}
