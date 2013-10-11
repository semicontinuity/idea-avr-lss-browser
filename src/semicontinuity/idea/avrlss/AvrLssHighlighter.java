package semicontinuity.idea.avrlss;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.parsing.AvrLssHighlightingLexer;
import semicontinuity.idea.avrlss.parsing.AvrLssTokenTypes;

import java.util.Map;

public class AvrLssHighlighter extends SyntaxHighlighterBase {
    private static final Map<IElementType, TextAttributesKey> keys1;

    @NotNull
    public Lexer getHighlightingLexer() {
        return new AvrLssHighlightingLexer();
    }


    public static final TextAttributesKey TA__REGISTER = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.REGISTER",
        HighlighterColors.TEXT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__NUMBER = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.NUMBER",
        SyntaxHighlighterColors.NUMBER.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OPERATOR_SIGN = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OPERATOR_SIGN",
        SyntaxHighlighterColors.OPERATION_SIGN.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__COLON = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.COLON",
        SyntaxHighlighterColors.DOT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__DOT = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.DOT",
        SyntaxHighlighterColors.DOT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__ASM_COMMENT = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.ASM_COMMENT",
        SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__C_LISTING = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.C_LISTING",
        SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes()
    );

    public static final TextAttributesKey TA__OP_STACK = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_STACK",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_SUBROUTINE = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_SUBROUTINE",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_JUMPS = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_JUMPS",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_COND_JUMPS = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_COND_JUMPS",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_ARITHMETIC = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_ARITHMETIC",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_DATA_TRANSFER = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_DATA_TRANSFER",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_MCU_CONTROL = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_MCU_CONTROL",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__OP_BIT_MANIPULATION = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.OP_BIT_MANIPULATION",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );


    public static final TextAttributesKey TA__LABEL = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.LABEL",
        HighlighterColors.TEXT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__LABEL_ADDRESS = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.LABEL_ADDRESS",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__ADDRESS = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.ADDRESS",
        SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );


    public static final TextAttributesKey TA__ASCII_DATA = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.ASCII_DATA",
        SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes()
    );
    public static final TextAttributesKey TA__HEX_DATA = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.HEX_DATA",
        SyntaxHighlighterColors.JAVA_BLOCK_COMMENT.getDefaultAttributes()
    );


    public static final TextAttributesKey TA__BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
        "AVRLSS.BAD_CHARACTER",
        HighlighterColors.BAD_CHARACTER.getDefaultAttributes()
    );


    static {
        keys1 = new THashMap<IElementType, TextAttributesKey>();

        keys1.put(AvrLssTokenTypes.REGISTER, TA__REGISTER);

        keys1.put(AvrLssTokenTypes.INTEGER_LITERAL, TA__NUMBER);

        keys1.put(AvrLssTokenTypes.PLUS, TA__OPERATOR_SIGN);
        keys1.put(AvrLssTokenTypes.MINUS, TA__OPERATOR_SIGN);
        keys1.put(AvrLssTokenTypes.COLON, TA__COLON);
        keys1.put(AvrLssTokenTypes.DOT, TA__DOT);
        keys1.put(AvrLssTokenTypes.END_OF_LINE_COMMENT, TA__ASM_COMMENT);
        keys1.put(AvrLssTokenTypes.BLOCK_COMMENT, TA__C_LISTING);

        keys1.put(AvrLssTokenTypes.OP_STACK, TA__OP_STACK);
        keys1.put(AvrLssTokenTypes.OP_SUBROUTINE, TA__OP_SUBROUTINE);
        keys1.put(AvrLssTokenTypes.OP_JUMPS, TA__OP_JUMPS);
        keys1.put(AvrLssTokenTypes.OP_COND_JUMPS, TA__OP_COND_JUMPS);
        keys1.put(AvrLssTokenTypes.OP_ARITHMETIC, TA__OP_ARITHMETIC);
        keys1.put(AvrLssTokenTypes.OP_DATA_TRANSFER, TA__OP_DATA_TRANSFER);
        keys1.put(AvrLssTokenTypes.OP_MCU_CONTROL, TA__OP_MCU_CONTROL);
        keys1.put(AvrLssTokenTypes.OP_BIT_MANIPULATION, TA__OP_BIT_MANIPULATION);

        keys1.put(AvrLssTokenTypes.LABEL, TA__LABEL);
        keys1.put(AvrLssTokenTypes.LABEL_ADDRESS, TA__LABEL_ADDRESS);
        keys1.put(AvrLssTokenTypes.ADDRESS, TA__ADDRESS);

        keys1.put(AvrLssTokenTypes.ASCII_DATA, TA__ASCII_DATA);
        keys1.put(AvrLssTokenTypes.HEX_DATA, TA__HEX_DATA);

        keys1.put(TokenType.BAD_CHARACTER, TA__BAD_CHARACTER);
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
        return pack(keys1.get(tokenType));
    }
}