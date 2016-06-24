package org.mule.sdk;

import java.util.Arrays;
import java.util.List;

public class MuleUrl
{

    private String name;
    private String url;
    private String folderName;

    public MuleUrl(String name, String url, String folderName)
    {
        this.name = name;
        this.url = url;
        this.folderName = folderName;
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    @Override public String toString()
    {
        return name;
    }

    public static MuleUrl v3_7_3 =
            new MuleUrl("3.7.3", "https://s3.amazonaws.com/MuleEE/fe49c9b102bcce22304d198936ea663f/mule-ee-distribution-standalone-3.7.3.tar.gz", "mule-enterprise-standalone-3.7.3");
    public static MuleUrl v3_8_0 = new MuleUrl("3.8.0", "http://s3.amazonaws.com/new-mule-artifacts/mule-ee-distribution-standalone-3.8.0.tar.gz", "mule-enterprise-standalone-3.8.0");

    public static List<MuleUrl> VERSIONS = Arrays.asList(v3_8_0, v3_7_3);

    public String getFolderName()
    {
        return folderName;
    }
}
