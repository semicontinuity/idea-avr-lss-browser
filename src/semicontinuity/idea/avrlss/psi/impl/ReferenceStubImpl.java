package semicontinuity.idea.avrlss.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import semicontinuity.idea.avrlss.parsing.AvrLssElementTypes;
import semicontinuity.idea.avrlss.psi.Reference;
import semicontinuity.idea.avrlss.psi.ReferenceStub;

public class ReferenceStubImpl extends StubBase<Reference> implements ReferenceStub {
    public ReferenceStubImpl(final StubElement parent) {
        super(parent, AvrLssElementTypes.REFERENCE);
        System.out.println("Created ReferenceStubImpl");
    }
}