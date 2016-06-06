package semicontinuity.idea.avrlss.parsing;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class AvrLssParser implements PsiParser {
    private static final com.intellij.openapi.diagnostic.Logger LOGGER = Logger.getInstance(AvrLssParser.class);


    @NotNull
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        builder.setDebugMode(true);
        final PsiBuilder.Marker rootMarker = builder.mark();
        while (!builder.eof()) {
            if (builder.getTokenType() == AvrLssTokenTypes.LABEL_ADDRESS) {
                final PsiBuilder.Marker marker = builder.mark();
                parseSymbolLine(builder);
                marker.done(AvrLssElementTypes.SYMBOL_LINE);
            } else if (builder.getTokenType() == AvrLssTokenTypes.ADDRESS) {
                final PsiBuilder.Marker marker = builder.mark();
                parseLine(builder);
                marker.done(AvrLssElementTypes.LINE);
            } else {
                builder.advanceLexer();
            }
        }
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }

    private void parseSymbolLine(PsiBuilder builder) {
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.LT) return;
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.LABEL) return;
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.GT) return;
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COLON) return;
        builder.advanceLexer();
    }

    private void parseLine(PsiBuilder builder) {
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COLON) return;
        builder.advanceLexer();

        final PsiBuilder.Marker mHexData = builder.mark();
        while (!builder.eof() && builder.getTokenType() == AvrLssTokenTypes.HEX_DATA) {
            builder.advanceLexer();
        }
        mHexData.done(AvrLssElementTypes.OCTETS);

        if (builder.getTokenType() == AvrLssTokenTypes.ASCII_DATA) {
            final PsiBuilder.Marker m = builder.mark();
            while (!builder.eof() && builder.getTokenType() == AvrLssTokenTypes.ASCII_DATA) {
                builder.advanceLexer();
            }
            m.done(AvrLssElementTypes.TEXT);
        } else {
            final PsiBuilder.Marker m2 = builder.mark();
            while (!builder.eof()) {
                IElementType tokenType = builder.getTokenType();
                if (tokenType == AvrLssTokenTypes.ADDRESS || tokenType == AvrLssTokenTypes.LABEL_ADDRESS) break;
                builder.advanceLexer();
            }
            m2.done(AvrLssElementTypes.INSTRUCTION);
        }
    }

    /*
    @NotNull
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        builder.setDebugMode(true);
        final PsiBuilder.Marker rootMarker = builder.mark();
        while (!builder.eof()) {
            builder.advanceLexer();
        }
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }
*/
}
