package semicontinuity.idea.avrlss.parsing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

%%

%class _AvrLssLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  {return;}
%eof}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////// User code //////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

%state LABEL, LISTING
%state ASM_LISTING_ADDRESS, ASM_LISTING_DUMP, ASM_LISTING_ASCII, ASM_LISTING_OP, ASM_LISTING_COMMENT

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

LabelCharacters = [\._a-zA-Z0-9]+
LabelAddress  = {HexDigit}{HexDigit}{HexDigit}{HexDigit}{HexDigit}{HexDigit}{HexDigit}{HexDigit}
Identifier = [:jletter:][:jletterdigit:]*
Spaces = " "+

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* hex integer literals */
HexDigit          = [0-9a-fA-F]
//HexValue = 0* {HexDigit} {1,8}
HexValue = {HexDigit}*
HexIntegerLiteral = 0 [xX] 0* {HexDigit} {1,8}

/* general line patterns */
Label  = {LabelAddress} " <" {LabelCharacters} ">:" {LineTerminator}?
AsmListing  = " "+ {HexValue} ":\t" {InputCharacter}* {LineTerminator}?
Listing     = {InputCharacter}* {LineTerminator}?

/* opcodes */
OpStack             = "push"|"pop"
OpSubroutine        = "icall"|"call"|"rcall"|"ret"|"reti"
OpJumps             = "ijmp"|"jmp"|"rjmp"
OpCondJumps         = "cpse"|"sbrc"|"sbrs"|"sbic"|"sbis"|"brbs"|"brbc"|"breq"|"brne"|"brcs"|"brcc"|"brsh"|"brlo"|"brmi"|"brpl"|"brge"|"brlt"|"brhs"|"brhc"|"brts"|"brtc"|"brvs"|"brvc"|"brie"|"brid"
OpArithmetic        = "cp"|"cpc"|"cpi"|"add"|"adc"|"adiw"|"sub"|"subi"|"sbc"|"sbci"|"sbiw"|"and"|"andi"|"or"|"ori"|"eor"|"com"|"neg"|"sbr"|"cbr"|"inc"|"dec"|"tst"|"clr"|"ser"|"mul"|"muls"|"mulsu"|"fmul"|"fmuls"|"fmulsu"
OpDataTransfer      = "mov"|"movw"|"ld"|"ldi"|"ldd"|"lds"|"st"|"std"|"sts"|"lpm"|"spm"|"in"|"out"
OpMcuControl        = "nop"|"sleep"|"wdr"|"break"
OpBitManipulation   = "sbi"|"cbi"|"lsl"|"lsr"|"rol"|"ror"|"asr"|"swap"|"bset"|"bclr"|"bst"|"bld"|"sec"|"clc"|"sen"|"cln"|"sez"|"clz"|"sei"|"cli"|"ses"|"cls"|"sev"|"clv"|"set"|"clt"|"seh"|"clh"

%%


// =====================================================================================================================
// State YYINITIAL
// =====================================================================================================================

<YYINITIAL> {
{Label}             { yypushback(yytext().length()); yybegin(LABEL);}
{AsmListing}        { yypushback(yytext().length()); yybegin(ASM_LISTING_ADDRESS);}
{Listing}           { yypushback(yytext().length()); yybegin(LISTING);}
}

// =====================================================================================================================
// State LABEL
// =====================================================================================================================

<LABEL> {
">"                 { return AvrLssTokenTypes.GT; }
"<"                 { return AvrLssTokenTypes.LT; }
":"                 { return AvrLssTokenTypes.COLON; }
{Spaces}            { return AvrLssTokenTypes.WHITE_SPACE; }
{LabelAddress}      { return AvrLssTokenTypes.LABEL_ADDRESS; }
{LabelCharacters}   { return AvrLssTokenTypes.LABEL; }
{LineTerminator}    { yybegin(YYINITIAL); return AvrLssTokenTypes.WHITE_SPACE; }
}

// =====================================================================================================================
// State ASM_LISTING_ADDRESS
// =====================================================================================================================
<ASM_LISTING_ADDRESS> {
[ ]+                { return AvrLssTokenTypes.WHITE_SPACE; }
{HexValue}          { return AvrLssTokenTypes.ADDRESS; }
":"                 { return AvrLssTokenTypes.COLON; }
"\t"                { yybegin(ASM_LISTING_DUMP); return AvrLssTokenTypes.WHITE_SPACE; }
}

// =====================================================================================================================
// State ASM_LISTING_DUMP
// =====================================================================================================================
<ASM_LISTING_DUMP> {
{HexValue}          { return AvrLssTokenTypes.HEX_DATA; }
" "+ "\t"           { yybegin(ASM_LISTING_OP); return AvrLssTokenTypes.WHITE_SPACE;}
" " " "+            { yybegin(ASM_LISTING_ASCII); return AvrLssTokenTypes.WHITE_SPACE;}
" "                 { return AvrLssTokenTypes.WHITE_SPACE;}
}


// =====================================================================================================================
// State ASM_LISTING_ASCII
// =====================================================================================================================
<ASM_LISTING_ASCII> {
{LineTerminator}    { yybegin(YYINITIAL); return AvrLssTokenTypes.WHITE_SPACE; }
.+                  { return AvrLssTokenTypes.ASCII_DATA;}
}


// =====================================================================================================================
// State ASM_LISTING_OP
// =====================================================================================================================
<ASM_LISTING_OP> {
[ \t]+              { return AvrLssTokenTypes.WHITE_SPACE; }
{OpStack}           { return AvrLssTokenTypes.OP_STACK;}
{OpSubroutine}      { return AvrLssTokenTypes.OP_SUBROUTINE;}
{OpJumps}           { return AvrLssTokenTypes.OP_JUMPS;}
{OpCondJumps}       { return AvrLssTokenTypes.OP_COND_JUMPS;}
{OpArithmetic}      { return AvrLssTokenTypes.OP_ARITHMETIC;}
{OpDataTransfer}    { return AvrLssTokenTypes.OP_DATA_TRANSFER;}
{OpMcuControl}      { return AvrLssTokenTypes.OP_MCU_CONTROL;}
{OpBitManipulation} { return AvrLssTokenTypes.OP_BIT_MANIPULATION;}
{Identifier}        { return AvrLssTokenTypes.REGISTER; }

{HexIntegerLiteral} { return AvrLssTokenTypes.INTEGER_LITERAL; }
{DecIntegerLiteral} { return AvrLssTokenTypes.INTEGER_LITERAL; }

"."                 { return AvrLssTokenTypes.DOT; }
"+"                 { return AvrLssTokenTypes.PLUS; }
"-"                 { return AvrLssTokenTypes.MINUS; }
","                 { return AvrLssTokenTypes.COMMA; }

";"                 { yybegin(ASM_LISTING_COMMENT); yypushback(yytext().length()); }
{LineTerminator}    { yybegin(YYINITIAL); return AvrLssTokenTypes.WHITE_SPACE; }
}

// =====================================================================================================================
// State ASM_LISTING_COMMENT
// =====================================================================================================================

<ASM_LISTING_COMMENT> {
{Listing}           { yybegin(YYINITIAL); return AvrLssTokenTypes.END_OF_LINE_COMMENT;}
}

// =====================================================================================================================
// State LISTING
// =====================================================================================================================

<LISTING> {
{Listing}           { yybegin(YYINITIAL); return AvrLssTokenTypes.BLOCK_COMMENT;}
}

// =====================================================================================================================
// BAD_CHARACTER
// =====================================================================================================================
.|\n                { return com.intellij.psi.TokenType.BAD_CHARACTER; }
