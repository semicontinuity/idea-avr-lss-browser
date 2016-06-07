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
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import semicontinuity.idea.avrlss.psi.impl.AvrLssFileImpl;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlock;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlockAddress;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlockHeader;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlockName;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiLine;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_r_mut;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_reg_mut_hsvnzc;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_reg_mut_svn0zc;
import semicontinuity.idea.avrlss.psi.impl.instruction.Psi_IT_reg_mut_svnzc;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_adc;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_add;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_adiw;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_and;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_andi;
import semicontinuity.idea.avrlss.psi.impl.instruction.subroutine.Psi_I_call;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_cbr;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_clr;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_com;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_cp;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_cpc;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_cpi;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_dec;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_eor;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_fmul;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_fmuls;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_fmulsu;
import semicontinuity.idea.avrlss.psi.impl.instruction.subroutine.Psi_I_icall;
import semicontinuity.idea.avrlss.psi.impl.instruction.jumps.Psi_I_ijmp;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_in;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_inc;
import semicontinuity.idea.avrlss.psi.impl.instruction.jumps.Psi_I_jmp;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_ld;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_ldd;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_ldi;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_lds;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_lpm;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_mov;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_movw;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_mul;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_muls;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_mulsu;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_neg;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_or;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_ori;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_out;
import semicontinuity.idea.avrlss.psi.impl.instruction.stack.Psi_I_pop;
import semicontinuity.idea.avrlss.psi.impl.instruction.stack.Psi_I_push;
import semicontinuity.idea.avrlss.psi.impl.instruction.subroutine.Psi_I_rcall;
import semicontinuity.idea.avrlss.psi.impl.instruction.subroutine.Psi_I_ret;
import semicontinuity.idea.avrlss.psi.impl.instruction.subroutine.Psi_I_reti;
import semicontinuity.idea.avrlss.psi.impl.instruction.jumps.Psi_I_rjmp;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_sbc;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_sbci;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_sbiw;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_sbr;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_ser;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_spm;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_st;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_std;
import semicontinuity.idea.avrlss.psi.impl.instruction.dataTransfer.Psi_I_sts;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_sub;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_subi;
import semicontinuity.idea.avrlss.psi.impl.instruction.arithmetic.Psi_I_tst;
import semicontinuity.idea.avrlss.psi.impl.instruction.bitManiputation.Psi_I_cli;
import semicontinuity.idea.avrlss.psi.impl.instruction.bitManiputation.Psi_I_sei;

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
        if (node.getElementType() == AvrLssElementTypes.BLOCK)
            return new PsiBlock(node);
        else if (node.getElementType() == AvrLssElementTypes.BLOCK_HEADER)
            return new PsiBlockHeader(node);
        else if (node.getElementType() == AvrLssElementTypes.BLOCK_ADDRESS)
            return new PsiBlockAddress(node);
        else if (node.getElementType() == AvrLssElementTypes.BLOCK_NAME)
            return new PsiBlockName(node);
        else if (node.getElementType() == AvrLssElementTypes.LINE)
            return new PsiLine(node);
        else if (node.getElementType() == AvrLssElementTypes.REGISTER_A)
            return new ASTWrapperPsiElement(node);
        else if (node.getElementType() == AvrLssElementTypes.REGISTER_B)
            return new ASTWrapperPsiElement(node);
        else if (node.getElementType() == AvrLssElementTypes.IMMEDIATE)
            return new ASTWrapperPsiElement(node);
        else if (node.getElementType() == AvrLssElementTypes.CP)
            return new Psi_I_cp(node);
        else if (node.getElementType() == AvrLssElementTypes.CPC)
            return new Psi_I_cpc(node);
        else if (node.getElementType() == AvrLssElementTypes.CPI)
            return new Psi_I_cpi(node);
        else if (node.getElementType() == AvrLssElementTypes.ADD)
            return new Psi_I_add(node);
        else if (node.getElementType() == AvrLssElementTypes.ADC)
            return new Psi_I_adc(node);
        else if (node.getElementType() == AvrLssElementTypes.ADIW)
            return new Psi_I_adiw(node);
        else if (node.getElementType() == AvrLssElementTypes.SUB)
            return new Psi_I_sub(node);
        else if (node.getElementType() == AvrLssElementTypes.SUBI)
            return new Psi_I_subi(node);
        else if (node.getElementType() == AvrLssElementTypes.SBC)
            return new Psi_I_sbc(node);
        else if (node.getElementType() == AvrLssElementTypes.SBCI)
            return new Psi_I_sbci(node);
        else if (node.getElementType() == AvrLssElementTypes.SBIW)
            return new Psi_I_sbiw(node);
        else if (node.getElementType() == AvrLssElementTypes.AND)
            return new Psi_I_and(node);
        else if (node.getElementType() == AvrLssElementTypes.ANDI)
            return new Psi_I_andi(node);
        else if (node.getElementType() == AvrLssElementTypes.OR)
            return new Psi_I_or(node);
        else if (node.getElementType() == AvrLssElementTypes.ORI)
            return new Psi_I_ori(node);
        else if (node.getElementType() == AvrLssElementTypes.EOR)
            return new Psi_I_eor(node);
        else if (node.getElementType() == AvrLssElementTypes.COM)
            return new Psi_I_com(node);
        else if (node.getElementType() == AvrLssElementTypes.NEG)
            return new Psi_I_neg(node);
        else if (node.getElementType() == AvrLssElementTypes.SBR)
            return new Psi_I_sbr(node);
        else if (node.getElementType() == AvrLssElementTypes.CBR)
            return new Psi_I_cbr(node);
        else if (node.getElementType() == AvrLssElementTypes.INC)
            return new Psi_I_inc(node);
        else if (node.getElementType() == AvrLssElementTypes.DEC)
            return new Psi_I_dec(node);
        else if (node.getElementType() == AvrLssElementTypes.TST)
            return new Psi_I_tst(node);
        else if (node.getElementType() == AvrLssElementTypes.CLR)
            return new Psi_I_clr(node);
        else if (node.getElementType() == AvrLssElementTypes.SER)
            return new Psi_I_ser(node);
        else if (node.getElementType() == AvrLssElementTypes.MUL)
            return new Psi_I_mul(node);
        else if (node.getElementType() == AvrLssElementTypes.MULS)
            return new Psi_I_muls(node);
        else if (node.getElementType() == AvrLssElementTypes.MULSU)
            return new Psi_I_mulsu(node);
        else if (node.getElementType() == AvrLssElementTypes.FMUL)
            return new Psi_I_fmul(node);
        else if (node.getElementType() == AvrLssElementTypes.FMULS)
            return new Psi_I_fmuls(node);
        else if (node.getElementType() == AvrLssElementTypes.FMULSU)
            return new Psi_I_fmulsu(node);
        else if (node.getElementType() == AvrLssElementTypes.NOP)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.SLEEP)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.WDR)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.BREAK)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.PUSH)
            return new Psi_I_push(node);
        else if (node.getElementType() == AvrLssElementTypes.POP)
            return new Psi_I_pop(node);
        else if (node.getElementType() == AvrLssElementTypes.ICALL)
            return new Psi_I_icall(node);
        else if (node.getElementType() == AvrLssElementTypes.CALL)
            return new Psi_I_call(node);
        else if (node.getElementType() == AvrLssElementTypes.RCALL)
            return new Psi_I_rcall(node);
        else if (node.getElementType() == AvrLssElementTypes.RET)
            return new Psi_I_ret(node);
        else if (node.getElementType() == AvrLssElementTypes.RETI)
            return new Psi_I_reti(node);
        else if (node.getElementType() == AvrLssElementTypes.IJMP)
            return new Psi_I_ijmp(node);
        else if (node.getElementType() == AvrLssElementTypes.JMP)
            return new Psi_I_jmp(node);
        else if (node.getElementType() == AvrLssElementTypes.RJMP)
            return new Psi_I_rjmp(node);
        else if (node.getElementType() == AvrLssElementTypes.MOV)
            return new Psi_I_mov(node);
        else if (node.getElementType() == AvrLssElementTypes.MOVW)
            return new Psi_I_movw(node);
        else if (node.getElementType() == AvrLssElementTypes.LD)
            return new Psi_I_ld(node);
        else if (node.getElementType() == AvrLssElementTypes.LDD)
            return new Psi_I_ldd(node);
        else if (node.getElementType() == AvrLssElementTypes.LDI)
            return new Psi_I_ldi(node);
        else if (node.getElementType() == AvrLssElementTypes.ST)
            return new Psi_I_st(node);
        else if (node.getElementType() == AvrLssElementTypes.STD)
            return new Psi_I_std(node);
        else if (node.getElementType() == AvrLssElementTypes.IN)
            return new Psi_I_in(node);
        else if (node.getElementType() == AvrLssElementTypes.OUT)
            return new Psi_I_out(node);
        else if (node.getElementType() == AvrLssElementTypes.LDS)
            return new Psi_I_lds(node);
        else if (node.getElementType() == AvrLssElementTypes.STS)
            return new Psi_I_sts(node);
        else if (node.getElementType() == AvrLssElementTypes.LPM)
            return new Psi_I_lpm(node);
        else if (node.getElementType() == AvrLssElementTypes.SPM)
            return new Psi_I_spm(node);

        else if (node.getElementType() == AvrLssElementTypes.BR)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.CP_SKIP)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.SKIP_IF_BIT)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.DUMMY)
            return new PsiInstruction(node);
        else if (node.getElementType() == AvrLssElementTypes.REG_MUT)
            return new Psi_IT_r_mut(node);
        else if (node.getElementType() == AvrLssElementTypes.REG_MUT_HSVNZC)
            return new Psi_IT_reg_mut_hsvnzc(node);
        else if (node.getElementType() == AvrLssElementTypes.REG_MUT_SVNZC)
            return new Psi_IT_reg_mut_svnzc(node);
        else if (node.getElementType() == AvrLssElementTypes.REG_MUT_SVN0ZC)
            return new Psi_IT_reg_mut_svn0zc(node);
        else if (node.getElementType() == AvrLssElementTypes.REG_MUT_SVN0ZC)
            return new Psi_IT_reg_mut_svn0zc(node);
        else if (node.getElementType() == AvrLssElementTypes.FLAG_MUT_I0)
            return new Psi_I_cli(node);
        else if (node.getElementType() == AvrLssElementTypes.FLAG_MUT_I1)
            return new Psi_I_sei(node);

        else
            return new ASTWrapperPsiElement(node);
    }
}
