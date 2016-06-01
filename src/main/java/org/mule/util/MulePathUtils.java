package org.mule.util;

public class MulePathUtils
{
    public static String escape(String name)
    {
        // This is to differentiate '/' that belong to the name and the ones that are used in mule paths as separators.
        StringBuilder builder = new StringBuilder(name.length() * 2);
        char previous = ' ';
        for (char c : name.toCharArray())
        {
            builder.append(c == '/' && previous != '\\' ? "\\/" : c);
            previous = c;
        }
        return builder.toString();
    }

    public static String unescape(String name)
    {
        return name.replaceAll("\\\\/", "/");
    }
}
