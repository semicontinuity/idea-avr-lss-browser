package semicontinuity.idea.avrlss;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author max
 */
public class AvrLssLanguage extends Language {
    public static final AvrLssLanguage INSTANCE = new AvrLssLanguage();

    public AvrLssLanguage() {
        super("AvrLss", "text/lss");
        SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this, new SingleLazyInstanceSyntaxHighlighterFactory() {
            @NotNull
            protected SyntaxHighlighter createHighlighter() {
                return new AvrLssHighlighter();
            }
        });
    }
}