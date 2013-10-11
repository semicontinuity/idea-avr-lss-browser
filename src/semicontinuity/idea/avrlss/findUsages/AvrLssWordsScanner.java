package semicontinuity.idea.avrlss.findUsages;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.psi.tree.TokenSet;
import semicontinuity.idea.avrlss.parsing.AvrLssLexer;
import semicontinuity.idea.avrlss.parsing.AvrLssTokenTypes;

public class AvrLssWordsScanner extends DefaultWordsScanner {
  public AvrLssWordsScanner() {
    super(new AvrLssLexer(),
        TokenSet.create(AvrLssTokenTypes.REGISTER, AvrLssTokenTypes.LABEL),
        AvrLssTokenTypes.COMMENTS,
        TokenSet.create(AvrLssTokenTypes.INTEGER_LITERAL));
  }
}
