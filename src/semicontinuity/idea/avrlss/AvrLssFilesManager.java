package semicontinuity.idea.avrlss;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class AvrLssFilesManager extends AbstractProjectComponent {
    public static AvrLssFilesManager getInstance(Project project) {
        return project.getComponent(AvrLssFilesManager.class);
    }

    public AvrLssFilesManager(Project project) {
        super(project);
    }

    @NotNull
    public String getComponentName() {
        return "AvrLssFilesManager";
    }
}