package semicontinuity.idea.avrlss;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class AvrLssColorsAndFontsPage implements ColorSettingsPage {
    @NotNull
    public String getDisplayName() {
        return "AVR LSS";
    }

    @Nullable
    public Icon getIcon() {
        return IconLoader.getIcon("/fileTypes/properties.png");
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{
        new AttributesDescriptor("Register", AvrLssHighlighter.TA__REGISTER),
        new AttributesDescriptor("Number", AvrLssHighlighter.TA__NUMBER),
        new AttributesDescriptor("Operator sign", AvrLssHighlighter.TA__OPERATOR_SIGN),
        new AttributesDescriptor("Colon", AvrLssHighlighter.TA__COLON),
        new AttributesDescriptor("Dot", AvrLssHighlighter.TA__DOT),

        new AttributesDescriptor("Asm comment", AvrLssHighlighter.TA__ASM_COMMENT),
        new AttributesDescriptor("C listing", AvrLssHighlighter.TA__C_LISTING),

        new AttributesDescriptor("Opcodes for stack access", AvrLssHighlighter.TA__OP_STACK),
        new AttributesDescriptor("Opcodes for support of subroutines", AvrLssHighlighter.TA__OP_SUBROUTINE),
        new AttributesDescriptor("Opcodes for unconditional jumps", AvrLssHighlighter.TA__OP_JUMPS),
        new AttributesDescriptor("Opcodes for conditional jumps", AvrLssHighlighter.TA__OP_COND_JUMPS),
        new AttributesDescriptor("Opcodes for arithmetic operations", AvrLssHighlighter.TA__OP_ARITHMETIC),
        new AttributesDescriptor("Opcodes for data transfer", AvrLssHighlighter.TA__OP_DATA_TRANSFER),
        new AttributesDescriptor("Opcodes for MCU control", AvrLssHighlighter.TA__OP_MCU_CONTROL),
        new AttributesDescriptor("Opcodes for bit manipulation", AvrLssHighlighter.TA__OP_BIT_MANIPULATION),

        new AttributesDescriptor("Label", AvrLssHighlighter.TA__LABEL),
        new AttributesDescriptor("Label address", AvrLssHighlighter.TA__LABEL_ADDRESS),
        new AttributesDescriptor("Address", AvrLssHighlighter.TA__ADDRESS),

        new AttributesDescriptor("ASCII data", AvrLssHighlighter.TA__ASCII_DATA),
        new AttributesDescriptor("Hex data", AvrLssHighlighter.TA__HEX_DATA)
    };

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        return new AvrLssHighlighter();
    }

    @NonNls
    @NotNull
    public String getDemoText() {
        return
            "     73a:\tcf 93       \tpush\tr28\n" +
            "     73c:\tdf 93       \tpush\tr29\n" +
            "\tunsigned int value;\n" +
            "\n" +
            "\tenc_write_reg( ENC_REG_MIREGADR, phyreg );\n" +
            "     73e:\t2a 98       \tcbi\t0x05, 2\t; 5\n" +
            "     740:\t84 ed       \tldi\tr24, 0xD4\t; 212\n" +
            "     742:\t0e 94 64 03 \tcall\t0x6c8\t; 0x6c8 <enc_write_reg>\n" +
            "\tenc_write_reg( ENC_REG_MICMD, (1<<ENC_BIT_MIIRD) );\n" +
            "     746:\t61 e0       \tldi\tr22, 0x01\t; 1\n" +
            "     748:\t82 ed       \tldi\tr24, 0xD2\t; 210\n" +
            "     74a:\t0e 94 64 03 \tcall\t0x6c8\t; 0x6c8 <enc_write_reg>\n" +
            "     74e:\t8e b5       \tin\tr24, 0x2e\t; 46\n" +
            "     750:\t87 70       \tandi\tr24, 0x07\t; 7\n" +
            "\n" +
            "    for(;;) {\n" +
            "        if (blink_thread__is_runnable()) {\n" +
            "     752:\t31 f0       \tbreq\t.+12     \t; 0x114 <main+0x52>\n" +
            "     754:\t88 95       \tsleep\n" +
            "     756:\t9e 01       \tmovw\tr18, r28\n" +
            "     758:\t28 2b       \tor\tr18, r24\n" +
            "     75a:\tc9 01       \tmovw\tr24, r18\n" +
            "     75c:\tdf 91       \tpop\tr29\n" +
            "     75e:\tcf 91       \tpop\tr28\n" +
            "     760:\t08 95       \tret\n" +
            "\n" +
            "00000762 <__stop_program>:\n" +
            "     762:\tff cf       \trjmp\t.-2      \t; 0x762 <__stop_program>\n";
    }

    @Nullable
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        Map<String, TextAttributesKey> map = new HashMap<String, TextAttributesKey>();
/*
    map.put("annotation", AvrLssHighlighter.ANNOTATION);
    map.put("statmet", AvrLssHighlighter.STATIC_METHOD_ACCESS);
    map.put("statfield", AvrLssHighlighter.STATIC_FIELD);
    map.put("instfield", AvrLssHighlighter.INSTANCE_FIELD);
    map.put("gdoc", AvrLssHighlighter.DOC_COMMENT_CONTENT);
    map.put("doctag", AvrLssHighlighter.DOC_COMMENT_TAG);
    map.put("unresolved", AvrLssHighlighter.UNRESOLVED_ACCESS);
    map.put("classref", AvrLssHighlighter.CLASS_REFERENCE);
    map.put("literal", AvrLssHighlighter.LITERAL_CONVERSION);
    map.put("mapkey", AvrLssHighlighter.MAP_KEY);
    map.put("prop", AvrLssHighlighter.INSTANCE_PROPERTY_REFERENCE);
    map.put("staticprop", AvrLssHighlighter.STATIC_PROPERTY_REFERENCE);
*/
        return map;
    }
}
