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
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import semicontinuity.idea.avrlss.psi.impl.AvrLssFileImpl;

public class DumpRegisterUsageReportAction extends AnAction {

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
        dumpDocument ((AvrLssFileImpl) psiFile);
    }

    private void dumpDocument(AvrLssFileImpl psiFile) {

        final StringBuilder b = new StringBuilder();
        psiFile.accept(new PsiElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                b.append(element.toString()).append('\n');
            }
        });
        try {
            FileWriter fileWriter = new FileWriter("c:\\tmp\\1");
            fileWriter.write(b.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
