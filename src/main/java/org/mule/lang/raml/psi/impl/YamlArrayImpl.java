package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import org.mule.lang.raml.psi.YamlArray;
import org.mule.lang.raml.psi.YamlKey;
import org.mule.lang.raml.psi.YamlValue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class YamlArrayImpl extends YamlPsiElementImpl implements YamlArray {
	public YamlArrayImpl(@NotNull ASTNode astNode) {
		super(astNode);
	}

	public String toString() {
		return "Yaml array";
	}

	@Override
	public boolean isList() {
		boolean isList = true;

		// TODO

		return isList;
	}

	@Override
	public boolean isHashMap() {
		boolean isHashMap = true;

		// TODO

		return isHashMap;
	}

	@Override
	public List<YamlValue> getValues() {
		ArrayList<YamlValue> result = new ArrayList<YamlValue>();

		// TODO

		return result;
	}

	@Override
	public List<YamlKey> getKeys() {
		ArrayList<YamlKey> result = new ArrayList<YamlKey>();

		// TODO

		return result;
	}

	@Override
	public HashMap<String, YamlValue> getMap() {
		HashMap<String, YamlValue> result = new HashMap<String, YamlValue>();

		// TODO

		return result;
	}

}
