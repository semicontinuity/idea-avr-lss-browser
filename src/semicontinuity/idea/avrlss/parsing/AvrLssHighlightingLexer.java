package semicontinuity.idea.avrlss.parsing;

import com.intellij.lexer.LayeredLexer;
import com.intellij.lexer.StringLiteralLexer;
import com.intellij.psi.tree.IElementType;


public class AvrLssHighlightingLexer extends LayeredLexer {

    public AvrLssHighlightingLexer() {
        super(new AvrLssLexer());
/*
        registerSelfStoppingLayer(new StringLiteralLexer('\"', AvrLssElementTypes.STRING_LITERAL),
            new IElementType[]{AvrLssElementTypes.STRING_LITERAL}, IElementType.EMPTY_ARRAY);

        registerSelfStoppingLayer(new StringLiteralLexer('\'', AvrLssElementTypes.CHAR_LITERAL),
            new IElementType[]{AvrLssElementTypes.CHAR_LITERAL}, IElementType.EMPTY_ARRAY);
*/
    }
}
