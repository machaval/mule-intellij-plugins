package org.mule.tooling.esb.sdk;

import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MuleUrl {

    private static final String BASE_URL = "http://intellij-mule-runtime.s3.amazonaws.com/";
    private static List<MuleUrl> VERSIONS = null;

    private String name;
    private String url;
    private String folderName;

    public MuleUrl(String name, String url, String folderName) {
        this.name = name;
        this.url = url;
        this.folderName = folderName;
    }

    public static List<MuleUrl> getVERSIONS() {
        if (VERSIONS == null) {
            VERSIONS = loadVersions();
        }
        return VERSIONS;
    }

    private static List<MuleUrl> loadVersions() {
        List<MuleUrl> result = new ArrayList<>();
        try {

            final URL url = new URL(BASE_URL + "index.xml");
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(url.openStream());
            final NodeList nList = doc.getElementsByTagName("runtime");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                final Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) nNode;
                    final String version = eElement.getElementsByTagName("version").item(0).getTextContent();
                    final String file = eElement.getElementsByTagName("file").item(0).getTextContent();
                    result.add(new MuleUrl(version, BASE_URL + file, FilenameUtils.getBaseName(file)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getFolderName() {
        return folderName;
    }
}
