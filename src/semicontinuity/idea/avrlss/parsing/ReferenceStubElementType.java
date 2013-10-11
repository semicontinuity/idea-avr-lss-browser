package semicontinuity.idea.avrlss.parsing;

import com.intellij.psi.stubs.*;
import semicontinuity.idea.avrlss.AvrLssLanguage;
import semicontinuity.idea.avrlss.psi.Reference;
import semicontinuity.idea.avrlss.psi.ReferenceStub;
import semicontinuity.idea.avrlss.psi.impl.ReferenceImpl;
import semicontinuity.idea.avrlss.psi.impl.ReferenceStubImpl;

import java.io.IOException;

public class ReferenceStubElementType extends IStubElementType<ReferenceStub, Reference> {
    public ReferenceStubElementType() {
        super("REFERENCE", AvrLssLanguage.INSTANCE);
    }

    public Reference createPsi(final ReferenceStub stub) {
        System.out.println("createPsi");
        return new ReferenceImpl(stub);
    }

    public ReferenceStub createStub(final Reference psi, final StubElement parentStub) {
        System.out.println("createStub");
        return new ReferenceStubImpl(parentStub);
    }

    public String getExternalId() {
        return "avrlss.reference";
    }

    public void serialize(final ReferenceStub stub, final StubOutputStream dataStream) throws IOException {
    }

    public ReferenceStub deserialize(final StubInputStream dataStream, final StubElement parentStub) throws IOException {
        return new ReferenceStubImpl(parentStub);
    }

    public void indexStub(final ReferenceStub stub, final IndexSink sink) {
    }
}