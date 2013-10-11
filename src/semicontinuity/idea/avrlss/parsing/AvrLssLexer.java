package semicontinuity.idea.avrlss.parsing;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class AvrLssLexer extends FlexAdapter {
    public AvrLssLexer() {
        super(new _AvrLssLexer((Reader) null));
    }
}
