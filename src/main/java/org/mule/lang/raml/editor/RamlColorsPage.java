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
            new AttributesDescriptor("Comment", RamlSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Identifier", RamlSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Sign: brace, comma, etc", RamlSyntaxHighlighter.INTERPUNCTION),
            new AttributesDescriptor("Number", RamlSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Keyword", RamlSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("String", RamlSyntaxHighlighter.STRING),
            new AttributesDescriptor("Tag", RamlSyntaxHighlighter.TAG),
    };

    @NotNull
    @Override
    public String getDisplayName() {
        return "RAML";
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


        return "#%RAML 0.8\n" +
                "---\n" +
                "title: Jukebox API\n" +
                "baseUri: http://jukebox.api.com\n" +
                "version: v1\n" +
                "\n" +
                "schemas:\n" +
                "\t- song: !include jukebox-include-song.schema\n" +
                "\t- artist: !include jukebox-include-artist.schema\n" +
                "\t- album: !include jukebox-include-album.schema\n" +
                "\n" +
                "\n" +
                "resourceTypes:\n" +
                "\t- collection:\n" +
                "\t\t\tdescription: Collection of available <<resourcePathName>> in Jukebox.\n" +
                "\t\t\tget:\n" +
                "\t\t\t\tdescription: Get a list of <<resourcePathName>>.\n" +
                "\t\t\t\tresponses:\n" +
                "\t\t\t\t\t200:\n" +
                "\t\t\t\t\t\tbody:\n" +
                "\t\t\t\t\t\t\tapplication/json:\n" +
                "\t\t\t\t\t\t\t\texample: |\n" +
                "\t\t\t\t\t\t\t\t\t<<exampleCollection>>\n" +
                "\t\t\tpost:\n" +
                "\t\t\t\tdescription: |\n" +
                "\t\t\t\t\tAdd a new <<resourcePathName|!singularize>> to Jukebox.\n" +
                "\t\t\t\tqueryParameters:\n" +
                "\t\t\t\t\taccess_token:\n" +
                "\t\t\t\t\t\tdescription: \" The access token provided by the authentication application \"\n" +
                "\t\t\t\t\t\texample: AABBCCDD\n" +
                "\t\t\t\t\t\trequired: true\n" +
                "\t\t\t\t\t\ttype: string\n" +
                "\t\t\t\tbody:\n" +
                "\t\t\t\t\tapplication/json:\n" +
                "\t\t\t\t\t\tschema: <<resourcePathName|!singularize>>\n" +
                "\t\t\t\t\t\texample: |\n" +
                "\t\t\t\t\t\t\t<<exampleItem>>\n" +
                "\t\t\t\tresponses:\n" +
                "\t\t\t\t\t200:\n" +
                "\t\t\t\t\t\tbody:\n" +
                "\t\t\t\t\t\t\tapplication/json:\n" +
                "\t\t\t\t\t\t\t\texample: |\n" +
                "\t\t\t\t\t\t\t\t\t{ \" message \": \" The << resourcePathName | !singularize >> has been properly entered\" }\n" +
                "\t- collection-item:\n" +
                "\t\t\tdescription: Entity representing a <<resourcePathName|!singularize>>\n" +
                "\t\t\tget:\n" +
                "\t\t\t\tdescription: |\n" +
                "\t\t\t\t\tGet the <<resourcePathName|!singularize>>\n" +
                "\t\t\t\t\twith <<resourcePathName|!singularize>>Id =\n" +
                "\t\t\t\t\t{<<resourcePathName|!singularize>>Id}\n" +
                "\t\t\t\tresponses:\n" +
                "\t\t\t\t\t200:\n" +
                "\t\t\t\t\t\tbody:\n" +
                "\t\t\t\t\t\t\tapplication/json:\n" +
                "\t\t\t\t\t\t\t\texample: |\n" +
                "\t\t\t\t\t\t\t\t\t<<exampleItem>>\n" +
                "\t\t\t\t\t404:\n" +
                "\t\t\t\t\t\tbody:\n" +
                "\t\t\t\t\t\t\tapplication/json:\n" +
                "\t\t\t\t\t\t\t\texample: |\n" +
                "\t\t\t\t\t\t\t\t\t{\" message \": \" << resourcePathName | !singularize >> not found \" }\n" +
                "traits:\n" +
                "\t- orderable:\n" +
                "\t\t\tqueryParameters:\n" +
                "\t\t\t\torderBy:\n" +
                "\t\t\t\t\tdescription: |\n" +
                "\t\t\t\t\t\tOrder by field: <<fieldsList>>\n" +
                "\t\t\t\t\ttype: string\n" +
                "\t\t\t\t\trequired: false\n" +
                "\t\t\t\torder:\n" +
                "\t\t\t\t\tdescription: Order\n" +
                "\t\t\t\t\tenum: [desc, asc]\n" +
                "\t\t\t\t\tdefault: desc\n" +
                "\t\t\t\t\trequired: false\n" +
                "\t- pageable:\n" +
                "\t\t\tqueryParameters:\n" +
                "\t\t\t\toffset:\n" +
                "\t\t\t\t\tdescription: Skip over a number of elements by specifying an offset value for the query\n" +
                "\t\t\t\t\ttype: integer\n" +
                "\t\t\t\t\trequired: false\n" +
                "\t\t\t\t\texample: 20\n" +
                "\t\t\t\t\tdefault: 0\n" +
                "\t\t\t\tlimit:\n" +
                "\t\t\t\t\tdescription: Limit the number of elements on the response\n" +
                "\t\t\t\t\ttype: integer\n" +
                "\t\t\t\t\trequired: false\n" +
                "\t\t\t\t\texample: 80\n" +
                "\t\t\t\t\tdefault: 10\n" +
                "\n" +
                "/songs:\n" +
                "\ttype:\n" +
                "\t\tcollection:\n" +
                "\t\t\texampleCollection: !include jukebox-include-songs.sample\n" +
                "\t\t\texampleItem: !include jukebox-include-song-new.sample\n" +
                "\tget:\n" +
                "\t\tis: [\n" +
                "\t\t\t\t\tsearchable: {description: \"with valid searchable fields: songTitle\", example: \"[\\\"songTitle\\\", \\\"Get L\\\", \\\"like\\\"]\"},\n" +
                "\t\t\t\t\torderable: {fieldsList: \"songTitle\"},\n" +
                "\t\t\t\t\tpageable\n" +
                "\t\t\t\t]\n" +
                "\t/{songId}:\n" +
                "\t\ttype:\n" +
                "\t\t\tcollection-item:\n" +
                "\t\t\t\texampleItem: !include jukebox-include-song-retrieve.sample\n" +
                "\t\t/file-content:\n" +
                "\t\t\tdescription: The file to be reproduced by the client\n" +
                "\t\t\tget:\n" +
                "\t\t\t\tdescription: Get the file content\n" +
                "\t\t\t\tresponses:\n" +
                "\t\t\t\t\t200:\n" +
                "\t\t\t\t\t\tbody:\n" +
                "\t\t\t\t\t\t\tbinary/octet-stream:\n" +
                "\t\t\t\t\t\t\t\texample:\n" +
                "\t\t\t\t\t\t\t\t\t!include heybulldog.mp3\n" +
                "\t\t\tpost:\n" +
                "\t\t\t\tdescription: |\n" +
                "\t\t\t\t\t Enters the file content for an existing song entity.\n" +
                "\n" +
                "\t\t\t\t\t The song needs to be created for the `/songs/{songId}/file-content` to exist.\n" +
                "\t\t\t\t\t You can use this second resource to get and post the file to reproduce.\n" +
                "\n" +
                "\t\t\t\t\t Use the \"binary/octet-stream\" content type to specify the content from any consumer (excepting web-browsers).\n" +
                "\t\t\t\t\t Use the \"multipart-form/data\" content type to upload a file which content will become the file-content\n" +
                "\t\t\t\tbody:\n" +
                "\t\t\t\t\tbinary/octet-stream:\n" +
                "\t\t\t\t\tmultipart/form-data:\n" +
                "\t\t\t\t\t\tformParameters:\n" +
                "\t\t\t\t\t\t\tfile:\n" +
                "\t\t\t\t\t\t\t\tdescription: The file to be uploaded\n" +
                "\t\t\t\t\t\t\t\trequired: true\n" +
                "\t\t\t\t\t\t\t\ttype: file\n";

    }

    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
}
