/* The following code was generated by JFlex 1.4.3 on 11.10.13 12:07 */

package semicontinuity.idea.avrlss.parsing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11.10.13 12:07 from the specification file
 * <tt>C:/projects/idea-avr-lss-browser/src/semicontinuity/idea/avrlss/parsing/AvrLss.flex</tt>
 */
class _AvrLssLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int ASM_LISTING_ASCII = 10;
  public static final int LABEL = 2;
  public static final int ASM_LISTING_COMMENT = 14;
  public static final int YYINITIAL = 0;
  public static final int LISTING = 4;
  public static final int ASM_LISTING_OP = 12;
  public static final int ASM_LISTING_ADDRESS = 6;
  public static final int ASM_LISTING_DUMP = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\6\1\17\1\2\2\0\1\1\16\6\4\0\1\10\3\0\1\4"+
    "\6\0\1\50\1\52\1\51\1\3\1\0\1\11\11\7\1\16\1\53"+
    "\1\14\1\0\1\15\2\0\6\12\21\5\1\13\2\5\4\0\1\5"+
    "\1\0\1\27\1\36\1\26\1\43\1\32\1\45\1\41\1\23\1\25"+
    "\1\34\1\46\1\30\1\35\1\40\1\24\1\20\1\37\1\31\1\22"+
    "\1\33\1\21\1\42\1\44\1\13\1\5\1\47\4\0\41\6\2\0"+
    "\4\4\4\0\1\4\2\0\1\6\7\0\1\4\4\0\1\4\5\0"+
    "\27\4\1\0\37\4\1\0\u01ca\4\4\0\14\4\16\0\5\4\7\0"+
    "\1\4\1\0\1\4\21\0\160\6\5\4\1\0\2\4\2\0\4\4"+
    "\10\0\1\4\1\0\3\4\1\0\1\4\1\0\24\4\1\0\123\4"+
    "\1\0\213\4\1\0\5\6\2\0\236\4\11\0\46\4\2\0\1\4"+
    "\7\0\47\4\11\0\55\6\1\0\1\6\1\0\2\6\1\0\2\6"+
    "\1\0\1\6\10\0\33\4\5\0\3\4\15\0\4\6\7\0\1\4"+
    "\4\0\13\6\5\0\53\4\37\6\4\0\2\4\1\6\143\4\1\0"+
    "\1\4\10\6\1\0\6\6\2\4\2\6\1\0\4\6\2\4\12\6"+
    "\3\4\2\0\1\4\17\0\1\6\1\4\1\6\36\4\33\6\2\0"+
    "\131\4\13\6\1\4\16\0\12\6\41\4\11\6\2\4\4\0\1\4"+
    "\5\0\26\4\4\6\1\4\11\6\1\4\3\6\1\4\5\6\22\0"+
    "\31\4\3\6\244\0\4\6\66\4\3\6\1\4\22\6\1\4\7\6"+
    "\12\4\2\6\2\0\12\6\1\0\7\4\1\0\7\4\1\0\3\6"+
    "\1\0\10\4\2\0\2\4\2\0\26\4\1\0\7\4\1\0\1\4"+
    "\3\0\4\4\2\0\1\6\1\4\7\6\2\0\2\6\2\0\3\6"+
    "\1\4\10\0\1\6\4\0\2\4\1\0\3\4\2\6\2\0\12\6"+
    "\4\4\7\0\1\4\5\0\3\6\1\0\6\4\4\0\2\4\2\0"+
    "\26\4\1\0\7\4\1\0\2\4\1\0\2\4\1\0\2\4\2\0"+
    "\1\6\1\0\5\6\4\0\2\6\2\0\3\6\3\0\1\6\7\0"+
    "\4\4\1\0\1\4\7\0\14\6\3\4\1\6\13\0\3\6\1\0"+
    "\11\4\1\0\3\4\1\0\26\4\1\0\7\4\1\0\2\4\1\0"+
    "\5\4\2\0\1\6\1\4\10\6\1\0\3\6\1\0\3\6\2\0"+
    "\1\4\17\0\2\4\2\6\2\0\12\6\1\0\1\4\17\0\3\6"+
    "\1\0\10\4\2\0\2\4\2\0\26\4\1\0\7\4\1\0\2\4"+
    "\1\0\5\4\2\0\1\6\1\4\7\6\2\0\2\6\2\0\3\6"+
    "\10\0\2\6\4\0\2\4\1\0\3\4\2\6\2\0\12\6\1\0"+
    "\1\4\20\0\1\6\1\4\1\0\6\4\3\0\3\4\1\0\4\4"+
    "\3\0\2\4\1\0\1\4\1\0\2\4\3\0\2\4\3\0\3\4"+
    "\3\0\14\4\4\0\5\6\3\0\3\6\1\0\4\6\2\0\1\4"+
    "\6\0\1\6\16\0\12\6\11\0\1\4\7\0\3\6\1\0\10\4"+
    "\1\0\3\4\1\0\27\4\1\0\12\4\1\0\5\4\3\0\1\4"+
    "\7\6\1\0\3\6\1\0\4\6\7\0\2\6\1\0\2\4\6\0"+
    "\2\4\2\6\2\0\12\6\22\0\2\6\1\0\10\4\1\0\3\4"+
    "\1\0\27\4\1\0\12\4\1\0\5\4\2\0\1\6\1\4\7\6"+
    "\1\0\3\6\1\0\4\6\7\0\2\6\7\0\1\4\1\0\2\4"+
    "\2\6\2\0\12\6\1\0\2\4\17\0\2\6\1\0\10\4\1\0"+
    "\3\4\1\0\51\4\2\0\1\4\7\6\1\0\3\6\1\0\4\6"+
    "\1\4\10\0\1\6\10\0\2\4\2\6\2\0\12\6\12\0\6\4"+
    "\2\0\2\6\1\0\22\4\3\0\30\4\1\0\11\4\1\0\1\4"+
    "\2\0\7\4\3\0\1\6\4\0\6\6\1\0\1\6\1\0\10\6"+
    "\22\0\2\6\15\0\60\4\1\6\2\4\7\6\4\0\10\4\10\6"+
    "\1\0\12\6\47\0\2\4\1\0\1\4\2\0\2\4\1\0\1\4"+
    "\2\0\1\4\6\0\4\4\1\0\7\4\1\0\3\4\1\0\1\4"+
    "\1\0\1\4\2\0\2\4\1\0\4\4\1\6\2\4\6\6\1\0"+
    "\2\6\1\4\2\0\5\4\1\0\1\4\1\0\6\6\2\0\12\6"+
    "\2\0\2\4\42\0\1\4\27\0\2\6\6\0\12\6\13\0\1\6"+
    "\1\0\1\6\1\0\1\6\4\0\2\6\10\4\1\0\44\4\4\0"+
    "\24\6\1\0\2\6\5\4\13\6\1\0\44\6\11\0\1\6\71\0"+
    "\53\4\24\6\1\4\12\6\6\0\6\4\4\6\4\4\3\6\1\4"+
    "\3\6\2\4\7\6\3\4\4\6\15\4\14\6\1\4\17\6\2\0"+
    "\46\4\12\0\53\4\1\0\1\4\3\0\u0149\4\1\0\4\4\2\0"+
    "\7\4\1\0\1\4\1\0\4\4\2\0\51\4\1\0\4\4\2\0"+
    "\41\4\1\0\4\4\2\0\7\4\1\0\1\4\1\0\4\4\2\0"+
    "\17\4\1\0\71\4\1\0\4\4\2\0\103\4\2\0\3\6\40\0"+
    "\20\4\20\0\125\4\14\0\u026c\4\2\0\21\4\1\0\32\4\5\0"+
    "\113\4\3\0\3\4\17\0\15\4\1\0\4\4\3\6\13\0\22\4"+
    "\3\6\13\0\22\4\2\6\14\0\15\4\1\0\3\4\1\0\2\6"+
    "\14\0\64\4\40\6\3\0\1\4\3\0\2\4\1\6\2\0\12\6"+
    "\41\0\3\6\2\0\12\6\6\0\130\4\10\0\51\4\1\6\1\4"+
    "\5\0\106\4\12\0\35\4\3\0\14\6\4\0\14\6\12\0\12\6"+
    "\36\4\2\0\5\4\13\0\54\4\4\0\21\6\7\4\2\6\6\0"+
    "\12\6\46\0\27\4\5\6\4\0\65\4\12\6\1\0\35\6\2\0"+
    "\13\6\6\0\12\6\15\0\1\4\130\0\5\6\57\4\21\6\7\4"+
    "\4\0\12\6\21\0\11\6\14\0\3\6\36\4\12\6\3\0\2\4"+
    "\12\6\6\0\46\4\16\6\14\0\44\4\24\6\10\0\12\6\3\0"+
    "\3\4\12\6\44\4\122\0\3\6\1\0\25\6\4\4\1\6\4\4"+
    "\1\6\15\0\300\4\47\6\25\0\4\6\u0116\4\2\0\6\4\2\0"+
    "\46\4\2\0\6\4\2\0\10\4\1\0\1\4\1\0\1\4\1\0"+
    "\1\4\1\0\37\4\2\0\65\4\1\0\7\4\1\0\1\4\3\0"+
    "\3\4\1\0\7\4\3\0\4\4\2\0\6\4\4\0\15\4\5\0"+
    "\3\4\1\0\7\4\16\0\5\6\32\0\5\6\20\0\2\4\23\0"+
    "\1\4\13\0\5\6\5\0\6\6\1\0\1\4\15\0\1\4\20\0"+
    "\15\4\3\0\32\4\26\0\15\6\4\0\1\6\3\0\14\6\21\0"+
    "\1\4\4\0\1\4\2\0\12\4\1\0\1\4\3\0\5\4\6\0"+
    "\1\4\1\0\1\4\1\0\1\4\1\0\4\4\1\0\13\4\2\0"+
    "\4\4\5\0\5\4\4\0\1\4\21\0\51\4\u0a77\0\57\4\1\0"+
    "\57\4\1\0\205\4\6\0\4\4\3\6\16\0\46\4\12\0\66\4"+
    "\11\0\1\4\17\0\1\6\27\4\11\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0"+
    "\7\4\1\0\40\6\57\0\1\4\u01d5\0\3\4\31\0\11\4\6\6"+
    "\1\0\5\4\2\0\5\4\4\0\126\4\2\0\2\6\2\0\3\4"+
    "\1\0\132\4\1\0\4\4\5\0\51\4\3\0\136\4\21\0\33\4"+
    "\65\0\20\4\u0200\0\u19b6\4\112\0\u51cc\4\64\0\u048d\4\103\0\56\4"+
    "\2\0\u010d\4\3\0\20\4\12\6\2\4\24\0\57\4\1\6\14\0"+
    "\2\6\1\0\31\4\10\0\120\4\2\6\45\0\11\4\2\0\147\4"+
    "\2\0\4\4\1\0\2\4\16\0\12\4\120\0\10\4\1\6\3\4"+
    "\1\6\4\4\1\6\27\4\5\6\20\0\1\4\7\0\64\4\14\0"+
    "\2\6\62\4\21\6\13\0\12\6\6\0\22\6\6\4\3\0\1\4"+
    "\4\0\12\6\34\4\10\6\2\0\27\4\15\6\14\0\35\4\3\0"+
    "\4\6\57\4\16\6\16\0\1\4\12\6\46\0\51\4\16\6\11\0"+
    "\3\4\1\6\10\4\2\6\2\0\12\6\6\0\27\4\3\0\1\4"+
    "\1\6\4\0\60\4\1\6\1\4\3\6\2\4\2\6\5\4\2\6"+
    "\1\4\1\6\1\4\30\0\3\4\43\0\6\4\2\0\6\4\2\0"+
    "\6\4\11\0\7\4\1\0\7\4\221\0\43\4\10\6\1\0\2\6"+
    "\2\0\12\6\6\0\u2ba4\4\14\0\27\4\4\0\61\4\u2104\0\u012e\4"+
    "\2\0\76\4\2\0\152\4\46\0\7\4\14\0\5\4\5\0\1\4"+
    "\1\6\12\4\1\0\15\4\1\0\5\4\1\0\1\4\1\0\2\4"+
    "\1\0\2\4\1\0\154\4\41\0\u016b\4\22\0\100\4\2\0\66\4"+
    "\50\0\15\4\3\0\20\6\20\0\7\6\14\0\2\4\30\0\3\4"+
    "\31\0\1\4\6\0\5\4\1\0\207\4\2\0\1\6\4\0\1\4"+
    "\13\0\12\6\7\0\32\4\4\0\1\4\1\0\32\4\13\0\131\4"+
    "\3\0\6\4\2\0\6\4\2\0\6\4\2\0\3\4\3\0\2\4"+
    "\3\0\2\4\22\0\3\6\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\0\1\2\1\3\1\4\2\0\1\5\5\1"+
    "\1\6\2\7\2\10\1\11\1\12\1\13\1\14\2\2"+
    "\1\3\1\15\1\4\1\11\1\16\1\7\1\17\1\20"+
    "\1\21\1\11\1\21\21\20\1\22\1\23\1\24\1\25"+
    "\2\5\3\1\1\10\1\26\1\27\1\0\6\20\1\30"+
    "\3\20\1\31\1\20\1\30\1\31\7\20\1\30\17\20"+
    "\1\1\1\32\1\10\2\21\1\20\1\33\1\30\1\20"+
    "\1\34\1\31\1\34\1\31\4\20\1\35\1\36\1\31"+
    "\1\30\10\20\1\37\1\1\2\32\1\10\1\21\1\40"+
    "\1\35\1\31\1\20\1\1\1\10\1\21\1\1\1\10"+
    "\1\21\1\1\1\10\1\21\1\1\1\41\1\21\1\1"+
    "\1\21\1\1\1\21\2\1\3\42";

  private static int [] zzUnpackAction() {
    int [] result = new int[162];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\130\0\204\0\260\0\334\0\u0108\0\u0134"+
    "\0\u0160\0\u018c\0\u01b8\0\u01e4\0\u0210\0\u01b8\0\u023c\0\u01b8"+
    "\0\u0268\0\u0294\0\u02c0\0\u01b8\0\u01b8\0\u01b8\0\u02ec\0\u01b8"+
    "\0\u0318\0\u01b8\0\u0344\0\u0370\0\u039c\0\u03c8\0\u01b8\0\u03f4"+
    "\0\u0420\0\u044c\0\u0478\0\u04a4\0\u04d0\0\u04fc\0\u0528\0\u0554"+
    "\0\u0580\0\u05ac\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688\0\u06b4"+
    "\0\u06e0\0\u070c\0\u0738\0\u0764\0\u01b8\0\u01b8\0\u01b8\0\u01b8"+
    "\0\u0790\0\u01b8\0\u07bc\0\u07e8\0\u0814\0\u0840\0\u0370\0\u01b8"+
    "\0\u086c\0\u0898\0\u08c4\0\u08f0\0\u091c\0\u0948\0\u0974\0\u09a0"+
    "\0\u09cc\0\u09f8\0\u0a24\0\u0a50\0\u0a7c\0\u0aa8\0\u0ad4\0\u0b00"+
    "\0\u0b2c\0\u0b58\0\u0b84\0\u0bb0\0\u0bdc\0\u0c08\0\u0c34\0\u0c60"+
    "\0\u0c8c\0\u0cb8\0\u0ce4\0\u0d10\0\u0d3c\0\u0d68\0\u0d94\0\u0dc0"+
    "\0\u0dec\0\u0e18\0\u0e44\0\u0aa8\0\u0e70\0\u0e9c\0\u0ec8\0\u0ef4"+
    "\0\u0f20\0\u0f4c\0\u086c\0\u0f78\0\u03f4\0\u03f4\0\u0fa4\0\u03f4"+
    "\0\u03f4\0\u0fd0\0\u0ffc\0\u1028\0\u1054\0\u1080\0\u10ac\0\u10d8"+
    "\0\u03f4\0\u1104\0\u1130\0\u115c\0\u1188\0\u11b4\0\u0ffc\0\u11e0"+
    "\0\u120c\0\u1238\0\u1264\0\u03f4\0\u1290\0\u12bc\0\u01b8\0\u12e8"+
    "\0\u1314\0\u03f4\0\u03f4\0\u1340\0\u136c\0\u1398\0\u13c4\0\u13f0"+
    "\0\u141c\0\u1448\0\u1474\0\u14a0\0\u14cc\0\u14f8\0\u1524\0\u0268"+
    "\0\u1550\0\u157c\0\u15a8\0\u15d4\0\u01b8\0\u1600\0\u162c\0\u1658"+
    "\0\u1684\0\u01b8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[162];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\11\1\12\1\13\4\11\1\14\1\15\2\14\13\11"+
    "\2\14\2\11\1\14\3\11\1\14\4\11\1\14\1\11"+
    "\1\14\6\11\1\16\1\17\1\20\1\21\1\16\1\21"+
    "\1\16\1\22\1\23\2\22\1\21\1\24\1\25\1\26"+
    "\1\16\6\21\2\22\2\21\1\22\3\21\1\22\4\21"+
    "\1\22\1\21\1\22\2\21\4\16\1\3\1\27\1\30"+
    "\51\3\7\16\1\31\1\23\2\31\3\16\1\26\1\32"+
    "\6\16\2\31\2\16\1\31\3\16\1\31\4\16\1\31"+
    "\1\16\1\31\15\16\1\33\1\34\2\33\13\16\2\33"+
    "\2\16\1\33\3\16\1\33\4\16\1\33\1\16\1\33"+
    "\6\16\1\35\1\36\1\20\51\35\1\16\1\17\1\20"+
    "\1\37\2\40\1\16\1\41\1\42\1\43\2\40\3\16"+
    "\1\42\1\44\1\40\1\45\1\40\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\40\1\61\2\40\1\62\1\63\1\64\2\40\1\65"+
    "\1\66\1\67\1\70\1\10\1\71\1\72\51\10\1\11"+
    "\1\12\1\13\51\11\2\0\1\13\125\0\1\11\1\12"+
    "\1\13\4\11\1\73\1\11\2\73\13\11\2\73\2\11"+
    "\1\73\3\11\1\73\4\11\1\73\1\11\1\73\7\11"+
    "\1\12\1\13\4\11\1\74\1\15\2\74\3\11\1\75"+
    "\7\11\2\74\2\11\1\74\3\11\1\74\4\11\1\74"+
    "\1\11\1\74\6\11\2\0\1\20\54\0\1\21\1\0"+
    "\1\21\1\0\1\21\1\0\3\21\4\0\30\21\7\0"+
    "\1\21\1\0\1\21\1\0\1\76\1\0\2\76\1\21"+
    "\4\0\6\21\2\76\2\21\1\76\3\21\1\76\4\21"+
    "\1\76\1\21\1\76\2\21\14\0\1\23\45\0\1\30"+
    "\60\0\1\31\1\0\2\31\13\0\2\31\2\0\1\31"+
    "\3\0\1\31\4\0\1\31\1\0\1\31\15\0\1\33"+
    "\1\0\2\33\13\0\2\33\2\0\1\33\3\0\1\33"+
    "\4\0\1\33\1\0\1\33\16\0\1\77\6\0\1\100"+
    "\34\0\2\35\1\0\53\35\1\20\51\35\4\0\4\40"+
    "\1\0\3\40\4\0\30\40\13\0\1\41\1\0\1\41"+
    "\52\0\1\42\6\0\1\42\47\0\1\101\44\0\4\40"+
    "\1\0\3\40\4\0\1\40\1\102\2\40\1\103\23\40"+
    "\10\0\4\40\1\0\3\40\4\0\1\104\1\105\6\40"+
    "\1\106\1\40\1\107\1\110\2\40\1\111\5\40\1\112"+
    "\3\40\10\0\4\40\1\0\3\40\4\0\1\40\1\113"+
    "\7\40\1\114\16\40\10\0\4\40\1\0\3\40\4\0"+
    "\6\40\1\115\5\40\1\56\3\40\1\116\7\40\10\0"+
    "\4\40\1\0\3\40\4\0\1\117\3\40\1\120\2\40"+
    "\1\121\1\107\5\40\1\122\11\40\10\0\4\40\1\0"+
    "\3\40\4\0\2\40\1\123\15\40\1\124\2\40\1\125"+
    "\4\40\10\0\4\40\1\0\3\40\4\0\1\104\1\40"+
    "\1\126\20\40\1\127\4\40\10\0\4\40\1\0\3\40"+
    "\4\0\4\40\1\126\1\40\1\115\3\40\1\130\1\40"+
    "\1\56\13\40\10\0\4\40\1\0\3\40\4\0\4\40"+
    "\1\131\23\40\10\0\4\40\1\0\3\40\4\0\2\40"+
    "\1\132\25\40\10\0\4\40\1\0\3\40\4\0\15\40"+
    "\1\133\12\40\10\0\4\40\1\0\3\40\4\0\1\40"+
    "\1\134\2\40\1\135\23\40\10\0\4\40\1\0\3\40"+
    "\4\0\2\40\1\136\3\40\1\137\1\40\1\140\1\141"+
    "\16\40\10\0\4\40\1\0\3\40\4\0\4\40\1\142"+
    "\5\40\1\143\15\40\10\0\4\40\1\0\3\40\4\0"+
    "\12\40\1\144\15\40\10\0\4\40\1\0\3\40\4\0"+
    "\23\40\1\145\4\40\10\0\4\40\1\0\3\40\4\0"+
    "\15\40\1\146\12\40\6\0\1\72\51\0\1\11\1\12"+
    "\1\13\4\11\1\147\1\11\2\147\13\11\2\147\2\11"+
    "\1\147\3\11\1\147\4\11\1\147\1\11\1\147\7\11"+
    "\1\12\1\13\4\11\1\74\1\11\2\74\3\11\1\75"+
    "\7\11\2\74\2\11\1\74\3\11\1\74\4\11\1\74"+
    "\1\11\1\74\7\11\1\12\1\13\14\11\1\150\34\11"+
    "\3\0\1\21\1\0\1\21\1\0\1\151\1\0\2\151"+
    "\1\21\4\0\6\21\2\151\2\21\1\151\3\21\1\151"+
    "\4\21\1\151\1\21\1\151\2\21\13\0\1\152\1\0"+
    "\1\153\1\152\13\0\2\152\2\0\1\152\3\0\1\152"+
    "\4\0\1\152\1\0\1\152\12\0\4\40\1\0\3\40"+
    "\4\0\2\40\1\154\25\40\10\0\4\40\1\0\3\40"+
    "\4\0\1\155\27\40\10\0\4\40\1\0\3\40\4\0"+
    "\15\40\1\156\12\40\10\0\4\40\1\0\3\40\4\0"+
    "\16\40\1\114\11\40\10\0\4\40\1\0\3\40\4\0"+
    "\12\40\1\157\15\40\10\0\4\40\1\0\3\40\4\0"+
    "\2\40\2\160\1\40\2\160\2\40\1\161\1\40\1\160"+
    "\4\40\1\160\1\40\1\160\4\40\1\160\10\0\4\40"+
    "\1\0\3\40\4\0\2\40\1\156\20\40\1\156\4\40"+
    "\10\0\4\40\1\0\3\40\4\0\5\40\1\162\1\114"+
    "\2\40\1\163\16\40\10\0\4\40\1\0\3\40\4\0"+
    "\7\40\1\164\20\40\10\0\4\40\1\0\3\40\4\0"+
    "\13\40\1\156\14\40\10\0\4\40\1\0\3\40\4\0"+
    "\5\40\1\161\22\40\10\0\4\40\1\0\3\40\4\0"+
    "\7\40\1\121\20\40\10\0\4\40\1\0\3\40\4\0"+
    "\6\40\1\161\21\40\10\0\4\40\1\0\3\40\4\0"+
    "\2\40\1\165\2\40\2\161\21\40\10\0\4\40\1\0"+
    "\3\40\4\0\15\40\1\161\12\40\10\0\4\40\1\0"+
    "\3\40\4\0\10\40\1\166\17\40\10\0\4\40\1\0"+
    "\3\40\4\0\5\40\1\160\3\40\1\161\16\40\10\0"+
    "\4\40\1\0\3\40\4\0\11\40\1\160\16\40\10\0"+
    "\4\40\1\0\3\40\4\0\23\40\1\114\4\40\10\0"+
    "\4\40\1\0\3\40\4\0\5\40\1\167\1\161\14\40"+
    "\1\161\4\40\10\0\4\40\1\0\3\40\4\0\10\40"+
    "\2\160\16\40\10\0\4\40\1\0\3\40\4\0\2\40"+
    "\1\156\2\40\1\156\15\40\1\156\4\40\10\0\4\40"+
    "\1\0\3\40\4\0\13\40\1\170\14\40\10\0\4\40"+
    "\1\0\3\40\4\0\11\40\1\161\16\40\10\0\4\40"+
    "\1\0\3\40\4\0\13\40\1\161\14\40\10\0\4\40"+
    "\1\0\3\40\4\0\1\171\27\40\10\0\4\40\1\0"+
    "\3\40\4\0\10\40\1\172\17\40\10\0\4\40\1\0"+
    "\3\40\4\0\22\40\1\173\5\40\10\0\4\40\1\0"+
    "\3\40\4\0\12\40\1\174\1\160\14\40\10\0\4\40"+
    "\1\0\3\40\4\0\10\40\1\123\17\40\10\0\4\40"+
    "\1\0\3\40\4\0\23\40\1\160\4\40\10\0\4\40"+
    "\1\0\3\40\4\0\1\175\1\40\1\176\1\177\1\40"+
    "\1\200\1\177\1\40\1\201\1\40\1\202\1\177\1\40"+
    "\1\203\1\177\1\40\2\165\1\177\5\40\10\0\4\40"+
    "\1\0\3\40\4\0\1\204\27\40\10\0\4\40\1\0"+
    "\3\40\4\0\21\40\1\161\6\40\10\0\4\40\1\0"+
    "\3\40\4\0\11\40\1\204\16\40\10\0\4\40\1\0"+
    "\3\40\4\0\1\40\1\134\26\40\4\0\1\11\1\12"+
    "\1\13\4\11\1\205\1\11\2\205\13\11\2\205\2\11"+
    "\1\205\3\11\1\205\4\11\1\205\1\11\1\205\6\11"+
    "\1\150\1\206\1\207\51\150\3\0\1\21\1\0\1\21"+
    "\1\0\1\210\1\0\2\210\1\21\4\0\6\21\2\210"+
    "\2\21\1\210\3\21\1\210\4\21\1\210\1\21\1\210"+
    "\2\21\13\0\1\211\1\0\2\211\13\0\2\211\2\0"+
    "\1\211\3\0\1\211\4\0\1\211\1\0\1\211\12\0"+
    "\4\40\1\0\3\40\4\0\3\40\1\155\24\40\10\0"+
    "\4\40\1\0\3\40\4\0\12\40\1\142\15\40\10\0"+
    "\4\40\1\0\3\40\4\0\2\40\1\212\3\40\1\212"+
    "\15\40\1\161\3\40\10\0\4\40\1\0\3\40\4\0"+
    "\2\40\1\212\3\40\1\212\21\40\10\0\4\40\1\0"+
    "\3\40\4\0\1\160\27\40\10\0\4\40\1\0\3\40"+
    "\4\0\12\40\1\212\15\40\10\0\4\40\1\0\3\40"+
    "\4\0\10\40\1\213\17\40\10\0\4\40\1\0\3\40"+
    "\4\0\24\40\1\161\3\40\10\0\4\40\1\0\3\40"+
    "\4\0\5\40\1\213\22\40\10\0\4\40\1\0\3\40"+
    "\4\0\2\40\1\214\25\40\10\0\4\40\1\0\3\40"+
    "\4\0\24\40\1\156\3\40\10\0\4\40\1\0\3\40"+
    "\4\0\13\40\1\160\14\40\10\0\4\40\1\0\3\40"+
    "\4\0\10\40\1\212\17\40\10\0\4\40\1\0\3\40"+
    "\4\0\3\40\1\212\24\40\10\0\4\40\1\0\3\40"+
    "\4\0\12\40\1\212\10\40\1\212\4\40\10\0\4\40"+
    "\1\0\3\40\4\0\4\40\1\212\6\40\1\212\14\40"+
    "\10\0\4\40\1\0\3\40\4\0\7\40\1\215\7\40"+
    "\1\212\10\40\10\0\4\40\1\0\3\40\4\0\5\40"+
    "\1\212\22\40\4\0\1\11\1\12\1\13\4\11\1\216"+
    "\1\11\2\216\13\11\2\216\2\11\1\216\3\11\1\216"+
    "\4\11\1\216\1\11\1\216\6\11\2\0\1\207\54\0"+
    "\1\21\1\0\1\21\1\0\1\217\1\0\2\217\1\21"+
    "\4\0\6\21\2\217\2\21\1\217\3\21\1\217\4\21"+
    "\1\217\1\21\1\217\2\21\13\0\1\220\1\0\2\220"+
    "\13\0\2\220\2\0\1\220\3\0\1\220\4\0\1\220"+
    "\1\0\1\220\12\0\4\40\1\0\3\40\4\0\1\40"+
    "\1\161\26\40\10\0\4\40\1\0\3\40\4\0\26\40"+
    "\1\204\1\40\4\0\1\11\1\12\1\13\4\11\1\221"+
    "\1\11\2\221\13\11\2\221\2\11\1\221\3\11\1\221"+
    "\4\11\1\221\1\11\1\221\6\11\3\0\1\21\1\0"+
    "\1\21\1\0\1\222\1\0\2\222\1\21\4\0\6\21"+
    "\2\222\2\21\1\222\3\21\1\222\4\21\1\222\1\21"+
    "\1\222\2\21\13\0\1\223\1\0\2\223\13\0\2\223"+
    "\2\0\1\223\3\0\1\223\4\0\1\223\1\0\1\223"+
    "\6\0\1\11\1\12\1\13\4\11\1\224\1\11\2\224"+
    "\13\11\2\224\2\11\1\224\3\11\1\224\4\11\1\224"+
    "\1\11\1\224\6\11\3\0\1\21\1\0\1\21\1\0"+
    "\1\225\1\0\2\225\1\21\4\0\6\21\2\225\2\21"+
    "\1\225\3\21\1\225\4\21\1\225\1\21\1\225\2\21"+
    "\13\0\1\226\1\0\2\226\13\0\2\226\2\0\1\226"+
    "\3\0\1\226\4\0\1\226\1\0\1\226\6\0\1\11"+
    "\1\12\1\13\4\11\1\227\1\11\2\227\13\11\2\227"+
    "\2\11\1\227\3\11\1\227\4\11\1\227\1\11\1\227"+
    "\6\11\3\0\1\21\1\0\1\21\1\0\1\230\1\0"+
    "\2\230\1\21\4\0\6\21\2\230\2\21\1\230\3\21"+
    "\1\230\4\21\1\230\1\21\1\230\2\21\13\0\1\231"+
    "\1\0\2\231\13\0\2\231\2\0\1\231\3\0\1\231"+
    "\4\0\1\231\1\0\1\231\6\0\1\11\1\12\1\13"+
    "\5\11\1\232\43\11\7\0\1\233\1\0\2\233\13\0"+
    "\2\233\2\0\1\233\3\0\1\233\4\0\1\233\1\0"+
    "\1\233\6\0\1\11\1\12\1\13\11\11\1\234\37\11"+
    "\7\0\1\235\1\0\2\235\13\0\2\235\2\0\1\235"+
    "\3\0\1\235\4\0\1\235\1\0\1\235\6\0\1\11"+
    "\1\12\1\13\1\236\1\11\1\236\1\11\1\236\1\11"+
    "\3\236\4\11\30\236\5\11\1\12\1\13\1\236\1\11"+
    "\1\236\1\11\1\236\1\11\3\236\1\11\1\237\2\11"+
    "\30\236\5\11\1\12\1\13\13\11\1\240\36\11\1\241"+
    "\1\242\51\11\2\0\1\242\51\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5808];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\0\3\1\2\0\3\1\1\11\2\1\1\11"+
    "\1\1\1\11\3\1\3\11\1\1\1\11\1\1\1\11"+
    "\4\1\1\11\25\1\4\11\1\1\1\11\5\1\1\11"+
    "\1\0\105\1\1\11\25\1\1\11\4\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[162];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  _AvrLssLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _AvrLssLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2190) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 22: 
          { yybegin(ASM_LISTING_ASCII); return AvrLssTokenTypes.WHITE_SPACE;
          }
        case 35: break;
        case 21: 
          { yybegin(ASM_LISTING_COMMENT); yypushback(yytext().length());
          }
        case 36: break;
        case 10: 
          { return AvrLssTokenTypes.LT;
          }
        case 37: break;
        case 13: 
          { yybegin(ASM_LISTING_DUMP); return AvrLssTokenTypes.WHITE_SPACE;
          }
        case 38: break;
        case 15: 
          { return AvrLssTokenTypes.DOT;
          }
        case 39: break;
        case 16: 
          { return AvrLssTokenTypes.REGISTER;
          }
        case 40: break;
        case 12: 
          { return AvrLssTokenTypes.COLON;
          }
        case 41: break;
        case 27: 
          { return AvrLssTokenTypes.OP_STACK;
          }
        case 42: break;
        case 14: 
          { return AvrLssTokenTypes.ASCII_DATA;
          }
        case 43: break;
        case 34: 
          { yypushback(yytext().length()); yybegin(LABEL);
          }
        case 44: break;
        case 7: 
          { yybegin(YYINITIAL); return AvrLssTokenTypes.WHITE_SPACE;
          }
        case 45: break;
        case 1: 
          { yypushback(yytext().length()); yybegin(LISTING);
          }
        case 46: break;
        case 30: 
          { return AvrLssTokenTypes.OP_JUMPS;
          }
        case 47: break;
        case 2: 
          { yybegin(YYINITIAL); return AvrLssTokenTypes.BLOCK_COMMENT;
          }
        case 48: break;
        case 6: 
          { return com.intellij.psi.TokenType.BAD_CHARACTER;
          }
        case 49: break;
        case 11: 
          { return AvrLssTokenTypes.GT;
          }
        case 50: break;
        case 31: 
          { return AvrLssTokenTypes.OP_MCU_CONTROL;
          }
        case 51: break;
        case 4: 
          { return AvrLssTokenTypes.HEX_DATA;
          }
        case 52: break;
        case 33: 
          { return AvrLssTokenTypes.LABEL_ADDRESS;
          }
        case 53: break;
        case 18: 
          { return AvrLssTokenTypes.PLUS;
          }
        case 54: break;
        case 23: 
          { yybegin(ASM_LISTING_OP); return AvrLssTokenTypes.WHITE_SPACE;
          }
        case 55: break;
        case 32: 
          { return AvrLssTokenTypes.OP_COND_JUMPS;
          }
        case 56: break;
        case 24: 
          { return AvrLssTokenTypes.OP_DATA_TRANSFER;
          }
        case 57: break;
        case 9: 
          { return AvrLssTokenTypes.WHITE_SPACE;
          }
        case 58: break;
        case 26: 
          { yypushback(yytext().length()); yybegin(ASM_LISTING_ADDRESS);
          }
        case 59: break;
        case 28: 
          { return AvrLssTokenTypes.OP_BIT_MANIPULATION;
          }
        case 60: break;
        case 25: 
          { return AvrLssTokenTypes.OP_ARITHMETIC;
          }
        case 61: break;
        case 20: 
          { return AvrLssTokenTypes.COMMA;
          }
        case 62: break;
        case 17: 
          { return AvrLssTokenTypes.INTEGER_LITERAL;
          }
        case 63: break;
        case 5: 
          { yybegin(YYINITIAL); return AvrLssTokenTypes.END_OF_LINE_COMMENT;
          }
        case 64: break;
        case 3: 
          { return AvrLssTokenTypes.ADDRESS;
          }
        case 65: break;
        case 8: 
          { return AvrLssTokenTypes.LABEL;
          }
        case 66: break;
        case 29: 
          { return AvrLssTokenTypes.OP_SUBROUTINE;
          }
        case 67: break;
        case 19: 
          { return AvrLssTokenTypes.MINUS;
          }
        case 68: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}