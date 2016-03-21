package org.mule.lang.raml.editor;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;


/**
 * Settings dialog for colors
 */
public class RamlColorsPage implements ColorSettingsPage {
	public static final AttributesDescriptor[] ATTRS = {
			new AttributesDescriptor("Bad character", RamlSyntaxHighlighter.UNKNOWN),
			new AttributesDescriptor("Comment",       RamlSyntaxHighlighter.COMMENT),
			new AttributesDescriptor("Identifier",    RamlSyntaxHighlighter.IDENTIFIER),
			new AttributesDescriptor("Sign: brace, comma, etc", RamlSyntaxHighlighter.INTERPUNCTION),
			new AttributesDescriptor("Number",        RamlSyntaxHighlighter.NUMBER),
			new AttributesDescriptor("Keyword",       RamlSyntaxHighlighter.KEYWORD),
			new AttributesDescriptor("String",        RamlSyntaxHighlighter.STRING),
			new AttributesDescriptor("Tag",           RamlSyntaxHighlighter.TAG),
	};

	@NotNull
	@Override
	public String getDisplayName() {
		return "YAML/Ansible";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return ATTRS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return new ColorDescriptor[0];
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new RamlSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return "%YAML 1.2\n" +
				"---\n" +
				"\n" +
				"common:\n" +
				"\tdebug: msg=\"Output of {{ var }}\"\n" +
				"\tparameters:\n" +
				"\t\tdays: [ Mon, Tue, Wed ]\n" +
				"\t\tdays2:\n" +
				"\t\t\t- Mon # Monday\n" +
				"\t\t\t- Tue\n" +
				"\t\t\t- Wed\n" +
				"\n" +
				"\t\t# Third type\n" +
				"\t\tdayNames: { mon: Monday, tue: Tuesday }\n" +
				"\n" +
				"\t\taddress:\n" +
				"\t\t\tstreet: 742 Evergreen Terrace\n" +
				"\t\t\tcity: Springfield\n" +
				"\t\t\tcountry: USA\n" +
				"\n" +
				"\t\tphones: { home: 555-6528, work: 555-7334 }\n" +
				"\t\tphp:\n" +
				"\t\t\tdate.timezone: Europe/Prague\n" +
				"\t\t\tzlib.output_compression: yes  # use gzip\n" +
				"\n" +
				"\t\tchildren:\n" +
				"\t\t\t- Bart\n" +
				"\t\t\t- Lisa\n" +
				"\t\t\t- %children.third%\n" +
				"\n" +
				"\t\tentity: Column(type=\"integer\")\n" +
				"\n" +
				"\tservices:\n" +
				"\t\tmyService: Nette\\Object(\"AHOJ\")\n" +
				"\t\tmyService2: Nette\\Something(@myService, 1)\n" +
				"\n" +
				"\n" +
				"production < common:\n" +
				"\tservices:\n" +
				"\t\tauthenticator: Nette\\Authenticator(@db)\n" +
				"\n" +
				"development < common:\n";
	}

	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}
}
