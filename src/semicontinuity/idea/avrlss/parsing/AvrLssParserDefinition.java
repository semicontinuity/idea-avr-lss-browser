package semicontinuity.idea.avrlss.parsing;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import semicontinuity.idea.avrlss.psi.impl.AvrLssFileImpl;
import semicontinuity.idea.avrlss.psi.impl.ReferenceImpl;
import org.jetbrains.annotations.NotNull;

public class AvrLssParserDefinition implements ParserDefinition {

    @NotNull
    public Lexer createLexer(final Project project) {
        return new AvrLssLexer();
    }

    public IFileElementType getFileNodeType() {
        return AvrLssTokenTypes.FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return AvrLssTokenTypes.WHITESPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return AvrLssTokenTypes.COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new AvrLssParser();
    }

    public PsiFile createFile(final FileViewProvider viewProvider) {
        return new AvrLssFileImpl(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(final ASTNode node) {
        return new ASTWrapperPsiElement(node);
    }
}