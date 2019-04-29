package semicontinuity.idea.avrlss.actions;

import java.io.FileWriter;
import java.io.IOException;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import semicontinuity.idea.avrlss.psi.impl.AvrLssFileImpl;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlock;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiBlockHeader;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiInstruction;
import semicontinuity.idea.avrlss.psi.impl.instruction.PsiLine;

public class WriteResourcesUsageReportAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = CommonDataKeys.PROJECT.getData(anActionEvent.getDataContext());
        final FileEditorManager fileEditorManager = FileEditorManager.getInstance (project);
        final Editor selectedTextEditor = fileEditorManager.getSelectedTextEditor ();
        if (selectedTextEditor == null) return;

        Document document = selectedTextEditor.getDocument();
        
        dumpDocument(document, project);
    }

    private void dumpDocument(Document document, Project project) {
        final PsiDocumentManager psiDocMgr = PsiDocumentManager.getInstance (project);
        final PsiFile psiFile = psiDocMgr.getCachedPsiFile (document);
        if (psiFile == null) return;
        if (!(psiFile instanceof AvrLssFileImpl)) return;
        
        dumpDocument (psiFile);
    }


    private void dumpDocument(PsiElement psiFile) {
        PsiFile file = psiFile.getContainingFile();
        VirtualFile virtualFile = file.getVirtualFile();
        String canonicalPath = virtualFile.getCanonicalPath();

        final StringBuilder b = new StringBuilder();
        psiFile.acceptChildren(new PsiElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                if (element instanceof PsiBlock) {
                    PsiBlock block = (PsiBlock) element;
                    PsiBlockHeader blockHeader = block.getHeader();


//                    b.append(block.getLabelAddress()).append(':').append(block.getLabel()).append('\n');

                    ComputeAffected visitor = new ComputeAffected();
                    block.acceptChildren(visitor);

                    b
                            .append(affectedRegistersAsString(visitor.affectedRegisters))
                            .append('\t')
                            .append(affectedFlagsAsString(visitor.affectedFlags))
                            .append('\t')
                            ;
                    b.append(blockHeader.getBlockName().getText()).append('\n');
                }
            }
        });
        try {
            FileWriter fileWriter = new FileWriter(canonicalPath + ".report");
            fileWriter.write(b.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private String affectedFlagsAsString(byte affectedFlags) {
//        return String.format("%8s", Integer.toBinaryString(affectedFlags & 0xFF)).replace(' ', '.').replace('0', '.');
        StringBuilder b = new StringBuilder();
        b.append((affectedFlags & PsiInstruction.FLAG_I) != 0 ? 'I' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_T) != 0 ? 'T' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_H) != 0 ? 'H' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_S) != 0 ? 'S' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_V) != 0 ? 'V' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_N) != 0 ? 'N' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_Z) != 0 ? 'C' : '.');
        b.append((affectedFlags & PsiInstruction.FLAG_C) != 0 ? 'Z' : '.');
        return b.toString();
    }

    @NotNull
    private String affectedRegistersAsString(int affectedRegisters) {
//        return String.format("%32s", Integer.toBinaryString(affectedRegisters)).replace(' ', '.').replace('0', '.');
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            b.append((affectedRegisters & (1<<i)) != 0 ? String.format("%02d", i) : "__");
            b.append(' ');
        }
        return b.toString();


    }


    private static class ComputeAffected extends PsiElementVisitor {
        int affectedRegisters = 0;
        byte affectedFlags = 0;

        @Override
        public void visitElement(PsiElement element) {
            if (element instanceof PsiLine) {
                PsiLine line = (PsiLine) element;
//                                b.append(line.getClass().getName()).append('\n');
                PsiElement lastChild = line.getLastChild();
                if (lastChild instanceof PsiInstruction) {
                    PsiInstruction instruction = (PsiInstruction) lastChild;
                    int ar = instruction.clobberedRegisters();
                    byte af = instruction.clobberedFlags();
/*
                    b
                            .append(String.format("%32s", Integer.toBinaryString(ar)).replace(' ', '.').replace('0', '.'))
                            .append("  ")
                            .append(String.format("%8s", Integer.toBinaryString(af & 0xFF)).replace(' ', '.').replace('0', '.'))
                            .append('\t').append(instruction.getText())
                            .append('\n');
*/
                    affectedRegisters |= ar;
                    affectedFlags |= af;
                }
            }
        }
    }
}
