package org.mule.lang.raml.editor;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.mule.lang.raml.psi.YamlFile;
import org.jetbrains.annotations.NotNull;

/**
 * Structure view
 */
public class RamlStructureViewFactory implements PsiStructureViewFactory {
	@Override
	public StructureViewBuilder getStructureViewBuilder(final PsiFile file) {
		if ( ! (file instanceof YamlFile)) return null;

		return new TreeBasedStructureViewBuilder() {
			@NotNull
			@Override
			public StructureViewModel createStructureViewModel(Editor editor) {
				return new StructureViewModelBase(file, new RamlStructureViewElement(file));
			}

			@NotNull
			public StructureViewModel createStructureViewModel() {
				return new StructureViewModelBase(file, new RamlStructureViewElement(file));
			}
		};
	}
}
