package semicontinuity.idea.avrlss.parsing;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public interface AvrLssElementTypes {
    IStubElementType REFERENCE = new ReferenceStubElementType();
}
