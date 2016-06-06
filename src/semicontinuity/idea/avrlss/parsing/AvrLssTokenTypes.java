package semicontinuity.idea.avrlss.parsing;

import com.intellij.lang.Language;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;
import semicontinuity.idea.avrlss.AvrLssLanguage;

public interface AvrLssTokenTypes {
    AvrLssLanguage LANG = Language.findInstance(AvrLssLanguage.class);
    IFileElementType FILE = new IStubFileElementType(LANG);


    IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

    IElementType REGISTER = new AvrLssElementType("IDENTIFIER");
    IElementType INTEGER_LITERAL = new AvrLssElementType("NUMBER");


    IElementType GT = new AvrLssElementType("GT");
    IElementType LT = new AvrLssElementType("LT");
    IElementType COMMA = new AvrLssElementType("COMMA");
    IElementType COLON = new AvrLssElementType("COLON");
    IElementType DOT = new AvrLssElementType("DOT");
    IElementType PLUS = new AvrLssElementType("PLUS");
    IElementType MINUS = new AvrLssElementType("MINUS");

    IElementType ADDRESS = new AvrLssElementType("ADDRESS");
    IElementType LABEL_ADDRESS = new AvrLssElementType("LABEL_ADDRESS");
    IElementType LABEL = new AvrLssElementType("LABEL");
    IElementType HEX_DATA = new AvrLssElementType("HEX_DATA");
    IElementType ASCII_DATA = new AvrLssElementType("ASCII_DATA");


    IElementType END_OF_LINE_COMMENT = new AvrLssElementType("END_OF_LINE_COMMENT");
    IElementType BLOCK_COMMENT = new AvrLssElementType("BLOCK_COMMENT");

    TokenSet COMMENTS = TokenSet.create(
        END_OF_LINE_COMMENT, BLOCK_COMMENT
    );

    TokenSet WHITESPACES = TokenSet.create(
        WHITE_SPACE
    );


    IElementType OP_STACK = new AvrLssElementType("OP_STACK");
    IElementType OP_SUBROUTINE = new AvrLssElementType("OP_SUBROUTINE");
    IElementType OP_JUMPS = new AvrLssElementType("OP_JUMPS");
    IElementType OP_COND_JUMPS = new AvrLssElementType("OP_COND_JUMPS");
    IElementType OP_ARITHMETIC = new AvrLssElementType("OP_ARITHMETIC");
    IElementType OP_DATA_TRANSFER = new AvrLssElementType("OP_DATA_TRANSFER");
    IElementType OP_MCU_CONTROL = new AvrLssElementType("OP_MCU_CONTROL");
    IElementType OP_BIT_MANIPULATION = new AvrLssElementType("OP_BIT_MANIPULATION");
}
