package semicontinuity.idea.avrlss.parsing;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public interface AvrLssElementTypes {
    IStubElementType REFERENCE = new ReferenceStubElementType();

    IElementType BLOCK = new AvrLssElementType("BLOCK");
    IElementType BLOCK_HEADER = new AvrLssElementType("BLOCK_HEADER");
    IElementType BLOCK_ADDRESS = new AvrLssElementType("BLOCK_ADDRESS");
    IElementType BLOCK_NAME = new AvrLssElementType("BLOCK_NAME");

    IElementType LINE = new AvrLssElementType("LINE");
    IElementType OCTETS = new AvrLssElementType("OCTETS");
    IElementType INSTRUCTION = new AvrLssElementType("INSTRUCTION");
    IElementType TEXT = new AvrLssElementType("TEXT");

    IElementType CP = new AvrLssElementType("CP");
    IElementType CPC = new AvrLssElementType("CPC");
    IElementType CPI = new AvrLssElementType("CPI");
    IElementType ADD = new AvrLssElementType("ADD");
    IElementType ADC = new AvrLssElementType("ADC");
    IElementType ADIW = new AvrLssElementType("ADIW");
    IElementType SUB = new AvrLssElementType("SUB");
    IElementType SUBI = new AvrLssElementType("SUBI");
    IElementType SBC = new AvrLssElementType("SBC");
    IElementType SBCI = new AvrLssElementType("SBCI");
    IElementType SBIW = new AvrLssElementType("SBIW");
    IElementType AND = new AvrLssElementType("AND");
    IElementType ANDI = new AvrLssElementType("ANDI");
    IElementType OR = new AvrLssElementType("OR");
    IElementType ORI = new AvrLssElementType("ORI");
    IElementType EOR = new AvrLssElementType("EOR");
    IElementType COM = new AvrLssElementType("COM");
    IElementType NEG = new AvrLssElementType("NEG");
    IElementType SBR = new AvrLssElementType("SBR");
    IElementType CBR = new AvrLssElementType("CBR");
    IElementType INC = new AvrLssElementType("INC");
    IElementType DEC = new AvrLssElementType("DEC");
    IElementType TST = new AvrLssElementType("TST");
    IElementType CLR = new AvrLssElementType("CLR");
    IElementType SER = new AvrLssElementType("SER");
    IElementType MUL = new AvrLssElementType("MUL");
    IElementType MULS = new AvrLssElementType("MULS");
    IElementType MULSU = new AvrLssElementType("MULSU");
    IElementType FMUL = new AvrLssElementType("FMUL");
    IElementType FMULS = new AvrLssElementType("FMULS");
    IElementType FMULSU = new AvrLssElementType("FMULSU");

    IElementType NOP = new AvrLssElementType("NOP");
    IElementType SLEEP = new AvrLssElementType("SLEEP");
    IElementType WDR = new AvrLssElementType("WDR");
    IElementType BREAK = new AvrLssElementType("BREAK");

    IElementType PUSH = new AvrLssElementType("PUSH");
    IElementType POP = new AvrLssElementType("POP");

    IElementType ICALL = new AvrLssElementType("ICALL");
    IElementType CALL = new AvrLssElementType("CALL");
    IElementType RCALL = new AvrLssElementType("RCALL");
    IElementType RET = new AvrLssElementType("RET");
    IElementType RETI = new AvrLssElementType("RETI");

    IElementType IJMP = new AvrLssElementType("IJMP");
    IElementType JMP = new AvrLssElementType("JMP");
    IElementType RJMP = new AvrLssElementType("RJMP");

    IElementType MOV = new AvrLssElementType("MOV");
    IElementType MOVW = new AvrLssElementType("MOVW");
    IElementType LD = new AvrLssElementType("LD");
    IElementType LDD = new AvrLssElementType("LDD");
    IElementType LDI = new AvrLssElementType("LDI");
    IElementType ST = new AvrLssElementType("ST");
    IElementType STD = new AvrLssElementType("STD");
    IElementType IN = new AvrLssElementType("IN");
    IElementType OUT = new AvrLssElementType("OUT");
    IElementType LDS = new AvrLssElementType("LDS");
    IElementType STS = new AvrLssElementType("STS");
    IElementType LPM = new AvrLssElementType("LDD");
    IElementType SPM = new AvrLssElementType("LDD");

    IElementType BR = new AvrLssElementType("BR");
    IElementType CP_SKIP = new AvrLssElementType("CP_SKIP");
    IElementType SKIP_IF_BIT = new AvrLssElementType("SKIP_IF_BIT");

    IElementType DUMMY = new AvrLssElementType("DUMMY");
    IElementType REG_MUT = new AvrLssElementType("REG_MUT");
    IElementType REG_MUT_HSVNZC = new AvrLssElementType("REG_MUT_HSVNZC");
    IElementType REG_MUT_SVN0ZC = new AvrLssElementType("REG_MUT_SVN0ZC");
    IElementType REG_MUT_SVNZC = new AvrLssElementType("REG_MUT_SVNZC");

    IElementType FLAG_MUT_I1 = new AvrLssElementType("FLAG_MUT_I1");
    IElementType FLAG_MUT_I0 = new AvrLssElementType("FLAG_MUT_I0");

    IElementType REGISTER_A = new AvrLssElementType("REGISTER_A");
    IElementType REGISTER_B = new AvrLssElementType("REGISTER_B");
    IElementType IMMEDIATE = new AvrLssElementType("IMMEDIATE");
}
