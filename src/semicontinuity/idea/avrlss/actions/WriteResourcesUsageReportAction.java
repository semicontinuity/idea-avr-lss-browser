package semicontinuity.idea.avrlss.actions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

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
        
        visitDocument(document, project);
    }

    private void visitDocument(Document document, Project project) {
        final PsiDocumentManager psiDocMgr = PsiDocumentManager.getInstance (project);
        final PsiFile psiFile = psiDocMgr.getCachedPsiFile (document);
        if (psiFile == null) return;
        if (!(psiFile instanceof AvrLssFileImpl)) return;

        PsiFile file = psiFile.getContainingFile();
        VirtualFile virtualFile = file.getVirtualFile();
        String canonicalPath = virtualFile.getCanonicalPath();

        writeFile(
                canonicalPath + ".read.report",
                summary(psiFile, PsiInstruction::readRegisters, PsiInstruction::readFlags)
        );
        writeFile(
                canonicalPath + ".changed.report",
                summary(psiFile, PsiInstruction::changedRegisters, PsiInstruction::changedFlags)
        );
        writeFile(
                canonicalPath + ".used.report",
                summary(psiFile, PsiInstruction::usedRegisters, PsiInstruction::usedFlags)
        );
    }

    private static void writeFile(String fileName, String text) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private String summary(
            final PsiElement psiFile,
            final Function<PsiInstruction, Integer> registersF,
            final Function<PsiInstruction, Byte> flagsF)
    {
        final StringBuilder b = new StringBuilder();
        psiFile.acceptChildren(new PsiElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                if (element instanceof PsiBlock) {
                    PsiBlock block = (PsiBlock) element;
                    PsiBlockHeader blockHeader = block.getHeader();
                    ComputeSummary visitor = new ComputeSummary(registersF, flagsF);
                    block.acceptChildren(visitor);

                    b
                            .append(registersAsString(visitor.registers))
                            .append('\t')
                            .append(flagsAsString(visitor.flags))
                            .append('\t')
                            .append(blockHeader.getBlockName().getText())
                            .append('\n')
                            ;
                }
            }

            @NotNull
            private String flagsAsString(byte flags) {
                StringBuilder b = new StringBuilder();
                b.append((flags & PsiInstruction.FLAG_I) != 0 ? 'I' : '.');
                b.append((flags & PsiInstruction.FLAG_T) != 0 ? 'T' : '.');
                b.append((flags & PsiInstruction.FLAG_H) != 0 ? 'H' : '.');
                b.append((flags & PsiInstruction.FLAG_S) != 0 ? 'S' : '.');
                b.append((flags & PsiInstruction.FLAG_V) != 0 ? 'V' : '.');
                b.append((flags & PsiInstruction.FLAG_N) != 0 ? 'N' : '.');
                b.append((flags & PsiInstruction.FLAG_Z) != 0 ? 'C' : '.');
                b.append((flags & PsiInstruction.FLAG_C) != 0 ? 'Z' : '.');
                return b.toString();
            }

            @NotNull
            private String registersAsString(int registers) {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < 32; i++) {
                    b.append((registers & (1<<i)) != 0 ? String.format("%02d", i) : "__");
                    b.append(' ');
                }
                return b.toString();
            }
        });
        return b.toString();
    }


    private static final class ComputeSummary extends PsiElementVisitor {
        int registers;
        byte flags;

        final Function<PsiInstruction, Integer> registersF;
        final Function<PsiInstruction, Byte> flagsF;

        private ComputeSummary(Function<PsiInstruction, Integer> registersF, Function<PsiInstruction, Byte> flagsF) {
            this.registersF = registersF;
            this.flagsF = flagsF;
        }


        @Override
        public void visitElement(PsiElement element) {
            if (element instanceof PsiLine) {
                PsiLine line = (PsiLine) element;
                PsiElement lastChild = line.getLastChild();
                if (lastChild instanceof PsiInstruction) {
                    PsiInstruction instruction = (PsiInstruction) lastChild;
                    int ar = registersF.apply(instruction);
                    byte af = flagsF.apply(instruction);
                    registers |= ar;
                    flags |= af;
                }
            }
        }
    }
}
