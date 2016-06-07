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
                final PsiBuilder.Marker mBlock = builder.mark();
                final PsiBuilder.Marker mBlockHeader = builder.mark();
                parseBlockHeader(builder);
                mBlockHeader.done(AvrLssElementTypes.BLOCK_HEADER);

                while (!builder.eof()) {
                    if (builder.getTokenType() != AvrLssTokenTypes.ADDRESS) break;
                    final PsiBuilder.Marker mLine = builder.mark();
                    parseLine(builder);
                    mLine.done(AvrLssElementTypes.LINE);
                }

                mBlock.done(AvrLssElementTypes.BLOCK);
            } else {
                builder.advanceLexer();
            }
        }
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }

    private void parseBlockHeader(PsiBuilder builder) {
        final PsiBuilder.Marker mAddress = builder.mark();
        builder.advanceLexer();
        mAddress.done(AvrLssElementTypes.BLOCK_ADDRESS);

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.LT) return;
        builder.advanceLexer();
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.LABEL) return;

        final PsiBuilder.Marker mName = builder.mark();
        builder.advanceLexer();
        mName.done(AvrLssElementTypes.BLOCK_NAME);

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
            IElementType tt = builder.getTokenType();
            if (tt == AvrLssTokenTypes.OP_ARITHMETIC) {
                parseArithmetic(builder);
            } else if (tt == AvrLssTokenTypes.OP_MCU_CONTROL) {
                parseMcuControl(builder);
            } else if (tt == AvrLssTokenTypes.OP_STACK) {
                parseStack(builder);
            } else if (tt == AvrLssTokenTypes.OP_SUBROUTINE) {
                parseSubroutine(builder);
            } else if (tt == AvrLssTokenTypes.OP_JUMPS) {
                parseJumps(builder);
            } else if (tt == AvrLssTokenTypes.OP_DATA_TRANSFER) {
                parseDataTransfer(builder);
            } else if (tt == AvrLssTokenTypes.OP_COND_JUMPS) {
                parseConditionalJumps(builder);
            } else if (tt == AvrLssTokenTypes.OP_BIT_MANIPULATION) {
                parseBitManipulation(builder);
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
    }

    private void parseMcuControl(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "nop":
                result = AvrLssElementTypes.NOP;
                break;
            case "sleep":
                result = AvrLssElementTypes.SLEEP;
                break;
            case "wdr":
                result = AvrLssElementTypes.WDR;
                break;
            case "break":
                result = AvrLssElementTypes.BREAK;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parseStack(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "push":
                parse_r(builder);
                result = AvrLssElementTypes.PUSH;
                break;
            case "pop":
                parse_r(builder);
                result = AvrLssElementTypes.POP;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }

    private void parseSubroutine(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "call":
                parse_offset(builder);
                result = AvrLssElementTypes.CALL;
                break;
            case "icall":
                result = AvrLssElementTypes.ICALL;
                break;
            case "rcall":
                parse_offset(builder);
                result = AvrLssElementTypes.RCALL;
                break;
            case "ret":
                result = AvrLssElementTypes.RET;
                break;
            case "reti":
                result = AvrLssElementTypes.RETI;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parseJumps(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "jmp":
                parse_offset(builder);
                result = AvrLssElementTypes.JMP;
                break;
            case "ijmp":
                result = AvrLssElementTypes.IJMP;
                break;
            case "rjmp":
                parse_offset(builder);
                result = AvrLssElementTypes.RJMP;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parseBitManipulation(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "bset":
            case "bclr":
            case "bst":
            case "bld":
            case "sec":
            case "clc":
            case "sen":
            case "cln":
            case "sez":
            case "clz":
            case "ses":
            case "cls":
            case "sev":
            case "clv":
            case "set":
            case "clt":
            case "seh":
            case "clh":
                throw new UnsupportedOperationException(op);
            case "sbi":
            case "cbi":
                parse_II(builder);
                result = AvrLssElementTypes.DUMMY;
                break;
            case "sei":
                result = AvrLssElementTypes.FLAG_MUT_I1;
                break;
            case "cli":
                result = AvrLssElementTypes.FLAG_MUT_I0;
                break;
            case "lsl":
            case "rol":
                parse_r(builder);
                result = AvrLssElementTypes.REG_MUT_HSVNZC;
                break;
            case "lsr":
                parse_r(builder);
                result = AvrLssElementTypes.REG_MUT_SVN0ZC;
                break;
            case "ror":
            case "asr":
                parse_r(builder);
                result = AvrLssElementTypes.REG_MUT_SVNZC;
                break;
            case "swap":
                parse_r(builder);
                result = AvrLssElementTypes.REG_MUT;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parseConditionalJumps(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "brbs":
            case "brbc":
                throw new UnsupportedOperationException(op);
            case "breq":
            case "brne":
            case "brcs":
            case "brcc":
            case "brsh":
            case "brlo":
            case "brmi":
            case "brpl":
            case "brge":
            case "brlt":
            case "brhs":
            case "brhc":
            case "brts":
            case "brtc":
            case "brvs":
            case "brvc":
            case "brie":
            case "brid":
                parse_offset(builder);
                result = AvrLssElementTypes.BR;
                break;
            case "cpse":
                parse_rr(builder);
                result = AvrLssElementTypes.CP_SKIP;
                break;
            case "sbrc":
            case "sbrs":
                parse_rM(builder);
                result = AvrLssElementTypes.CP_SKIP;
                break;
            case "sbic":
            case "sbis":
                parse_II(builder);
                result = AvrLssElementTypes.CP_SKIP;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parseDataTransfer(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "mov":
                parse_rr(builder);
                result = AvrLssElementTypes.MOV;
                break;
            case "movw":
                parse_rr(builder);
                result = AvrLssElementTypes.MOVW;
                break;
            case "ld":
                parse_r(builder);
                builder.advanceLexer(); // eat comma
                parse_pointer_expr(builder);
                result = AvrLssElementTypes.LD;
                break;
            case "ldd":
                parse_r(builder);
                builder.advanceLexer(); // eat comma
                parse_pointer_expr(builder);
                result = AvrLssElementTypes.LDD;
                break;
            case "ldi":
                parse_rM(builder);
                result = AvrLssElementTypes.LDI;
                break;
            case "st":
                parse_pointer_expr(builder);
                builder.advanceLexer(); // eat comma
                parse_r(builder);
                result = AvrLssElementTypes.ST;
                break;
            case "std":
                parse_pointer_expr(builder);
                builder.advanceLexer(); // eat comma
                parse_r(builder);
                result = AvrLssElementTypes.STD;
                break;
            case "in":
                parse_rM(builder);
                result = AvrLssElementTypes.IN;
                break;
            case "out":
                parse_Mr(builder);
                result = AvrLssElementTypes.OUT;
                break;
            case "lds":
                parse_rM(builder);
                result = AvrLssElementTypes.LDS;
                break;
            case "sts":
                parse_Mr(builder);
                result = AvrLssElementTypes.STS;
                break;
            case "lpm":
                if (builder.getTokenType() == AvrLssTokenTypes.REGISTER) {
                    parse_r(builder);
                    builder.advanceLexer(); // eat comma
                    parse_pointer_expr(builder);
                }
                result = AvrLssElementTypes.LPM;
                break;
            case "spm":
                if (builder.getTokenType() == AvrLssTokenTypes.REGISTER) {
                    parse_pointer_expr(builder);
                }
                result = AvrLssElementTypes.SPM;
                break;
            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }

    private void parseArithmetic(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        final String op = builder.getTokenText();
        builder.advanceLexer();
        IElementType result;
        switch (op) {
            case "cp":
                parse_rr(builder);
                result = AvrLssElementTypes.CP;
                break;
            case "cpc":
                parse_rr(builder);
                result = AvrLssElementTypes.CPC;
                break;
            case "cpi":
                parse_rM(builder);
                result = AvrLssElementTypes.CPI;
                break;
            case "add":
                parse_rr(builder);
                result = AvrLssElementTypes.ADD;
                break;
            case "adc":
                parse_rr(builder);
                result = AvrLssElementTypes.ADC;
                break;
            case "adiw":
                parse_wI(builder);
                result = AvrLssElementTypes.ADIW;
                break;
            case "sub":
                parse_rr(builder);
                result = AvrLssElementTypes.SUB;
                break;
            case "subi":
                parse_rM(builder);
                result = AvrLssElementTypes.SUBI;
                break;
            case "sbc":
                parse_rr(builder);
                result = AvrLssElementTypes.SBC;
                break;
            case "sbci":
                parse_rM(builder);
                result = AvrLssElementTypes.SBCI;
                break;
            case "sbiw":
                parse_wI(builder); ;
                result = AvrLssElementTypes.SBIW;
                break;
            case "and":
                parse_rr(builder);
                result = AvrLssElementTypes.AND;
                break;
            case "andi":
                parse_rM(builder);
                result = AvrLssElementTypes.ANDI;
                break;
            case "or":
                parse_rr(builder);
                result = AvrLssElementTypes.OR;
                break;
            case "ori":
                parse_rM(builder);
                result = AvrLssElementTypes.ORI;
                break;
            case "eor":
                parse_rr(builder);
                result = AvrLssElementTypes.EOR;
                break;
            case "com":
                parse_r(builder);
                result = AvrLssElementTypes.COM;
                break;
            case "neg":
                parse_r(builder);
                result = AvrLssElementTypes.NEG;
                break;
            case "sbr":
                parse_dM(builder);
                result = AvrLssElementTypes.SBR;
                break;
            case "cbr":
                parse_dM(builder);
                result = AvrLssElementTypes.CBR;
                break;
            case "inc":
                parse_r(builder);
                result = AvrLssElementTypes.INC;
                break;
            case "dec":
                parse_r(builder);
                result = AvrLssElementTypes.DEC;
                break;
            case "tst":
                parse_r(builder);
                result = AvrLssElementTypes.TST;
                break;
            case "clr":
                parse_r(builder);
                result = AvrLssElementTypes.CLR;
                break;
            case "ser":
                parse_r(builder);
                result = AvrLssElementTypes.SER;
                break;
            case "mul":
                parse_rr(builder);
                result = AvrLssElementTypes.MUL;
                break;
            case "muls":
                parse_rr(builder);
                result = AvrLssElementTypes.MULS;
                break;
            case "mulsu":
                parse_rr(builder);
                result = AvrLssElementTypes.MULSU;
                break;
            case "fmul":
                parse_rr(builder);
                result = AvrLssElementTypes.FMUL;
                break;
            case "fmuls":
                parse_rr(builder);
                result = AvrLssElementTypes.FMULS;
                break;
            case "fmulsu":
                parse_rr(builder);
                result = AvrLssElementTypes.FMULSU;
                break;

            default:
                result = AvrLssElementTypes.INSTRUCTION;
        }

        m.done(result);
    }


    private void parse_pointer_expr(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        try {
            if (builder.eof())
                throw new IllegalStateException();

            boolean autoDecrement = builder.getTokenType() == AvrLssTokenTypes.MINUS;
            if (autoDecrement)
                builder.advanceLexer();

            if (builder.getTokenType() != AvrLssTokenTypes.REGISTER)
                throw new IllegalStateException();
            builder.advanceLexer();

            if (builder.getTokenType() == AvrLssTokenTypes.PLUS) {
                if (autoDecrement) throw new IllegalStateException();
                builder.advanceLexer();

                // for LDD, STD
                if (builder.getTokenType() == AvrLssTokenTypes.INTEGER_LITERAL) {
                    builder.advanceLexer();
                }
            }

            m.done(AvrLssElementTypes.IMMEDIATE);
        } catch (IllegalStateException e) {
            m.drop();
        }
    }

    private void parse_offset(PsiBuilder builder) {
        final PsiBuilder.Marker m = builder.mark();
        try {
            if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.DOT)
                throw new IllegalStateException();
            builder.advanceLexer();
            if (builder.eof() || (builder.getTokenType() != AvrLssTokenTypes.PLUS && builder.getTokenType() != AvrLssTokenTypes.MINUS))
                throw new IllegalStateException();
            builder.advanceLexer();
            if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.INTEGER_LITERAL)
                throw new IllegalStateException();
            builder.advanceLexer();
            m.done(AvrLssElementTypes.IMMEDIATE);
        } catch (IllegalStateException e) {
            m.drop();
        }
    }

    private void parse_dM(PsiBuilder builder) {
        parse_rM(builder);  // fake TODO
    }

    private void parse_r(PsiBuilder builder) {
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.REGISTER) return;
        final PsiBuilder.Marker mr1 = builder.mark();
        builder.advanceLexer();
        mr1.done(AvrLssElementTypes.REGISTER_A);
    }

    private void parse_wI(PsiBuilder builder) {
        parse_rM(builder);  // fake TODO
    }

    private void parse_rr(PsiBuilder builder) {
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.REGISTER) return;
        final PsiBuilder.Marker mr1 = builder.mark();
        builder.advanceLexer();
        mr1.done(AvrLssElementTypes.REGISTER_A);

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COMMA) return;
        builder.advanceLexer();

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.REGISTER) return;
        final PsiBuilder.Marker mr2 = builder.mark();
        builder.advanceLexer();
        mr2.done(AvrLssElementTypes.REGISTER_B);
    }

    private void parse_rM(PsiBuilder builder) {
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.REGISTER) return;
        final PsiBuilder.Marker mr1 = builder.mark();
        builder.advanceLexer();
        mr1.done(AvrLssElementTypes.REGISTER_A);

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COMMA) return;
        builder.advanceLexer();

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.INTEGER_LITERAL) return;
//        final PsiBuilder.Marker mValue = builder.mark();
        builder.advanceLexer();
//        mValue.done(AvrLssElementTypes.IMMEDIATE);
    }


    private void parse_II(PsiBuilder builder) {
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.INTEGER_LITERAL) return;
//        final PsiBuilder.Marker mValue = builder.mark();
        builder.advanceLexer();

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COMMA) return;
        builder.advanceLexer();

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.INTEGER_LITERAL) return;
//        final PsiBuilder.Marker mValue = builder.mark();
        builder.advanceLexer();
//        mValue.done(AvrLssElementTypes.IMMEDIATE);
    }

    private void parse_Mr(PsiBuilder builder) {
        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.INTEGER_LITERAL)
            throw new IllegalArgumentException();
        final PsiBuilder.Marker m1 = builder.mark();
        builder.advanceLexer();
        m1.done(AvrLssElementTypes.IMMEDIATE);

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.COMMA)
            throw new IllegalArgumentException();
        builder.advanceLexer();

        if (builder.eof() || builder.getTokenType() != AvrLssTokenTypes.REGISTER)
            throw new IllegalArgumentException();
        final PsiBuilder.Marker m2 = builder.mark();
        builder.advanceLexer();
        m2.done(AvrLssElementTypes.REGISTER_A);
    }

}
