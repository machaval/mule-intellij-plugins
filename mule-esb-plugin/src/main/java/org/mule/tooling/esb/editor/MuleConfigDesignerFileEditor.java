package org.mule.tooling.esb.editor;

import com.intellij.ide.structureView.StructureViewBuilder;

import com.intellij.openapi.graph.builder.util.GraphViewUtil;
import com.intellij.openapi.graph.view.Graph2DView;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.ui.PerspectiveFileEditor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;


public class MuleConfigDesignerFileEditor extends PerspectiveFileEditor {

  private MuleConfigDesignerComponent myComponent;
  private final XmlFile myXmlFile;

  public MuleConfigDesignerFileEditor(final Project project, final VirtualFile file) {
    super(project, file);

    final PsiFile psiFile = getPsiFile();
    assert psiFile instanceof XmlFile;

    myXmlFile = (XmlFile) psiFile;
  }


  @Nullable
  protected DomElement getSelectedDomElement() {
    final List<XmlTag> selectedDomElements = getJpdlDesignerComponent().getSelectedDomElements();

    return  null;
  }

  protected void setSelectedDomElement(final DomElement domElement) {
    if(domElement instanceof XmlTag) {
      getJpdlDesignerComponent().setSelectedDomElement((XmlTag) domElement);
    }
  }

  @NotNull
  protected JComponent createCustomComponent() {
    return getJpdlDesignerComponent();
  }

  @Nullable
  public JComponent getPreferredFocusedComponent() {
    return ((Graph2DView) getJpdlDesignerComponent().getBuilder().getGraph().getCurrentView()).getJComponent();
  }

  public void commit() {
  }

  public void reset() {
    getJpdlDesignerComponent().getBuilder().queueUpdate();
  }

  @NotNull
  public String getName() {
    return "Mule Editor";
  }

  public StructureViewBuilder getStructureViewBuilder() {
    return GraphViewUtil.createStructureViewBuilder(getJpdlDesignerComponent().getOverview());
  }

  private MuleConfigDesignerComponent getJpdlDesignerComponent() {
    if (myComponent == null) {
      final MuleConfigDesignerComponent[] graphComponent = {null};
      ProgressManager.getInstance().runProcessWithProgressSynchronously(new Runnable() {
        public void run() {
          graphComponent[0] = new MuleConfigDesignerComponent(myXmlFile);
        }
      }, "Editor", false, myXmlFile.getProject());


      myComponent = graphComponent[0];
      Disposer.register(this, myComponent);
    }
    return myComponent;
  }
}
