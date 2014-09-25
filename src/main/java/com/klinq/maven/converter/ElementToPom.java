package com.klinq.maven.converter;

/**
 * Convert element to POM.xml string
 * 
 * @author Deisss
 */
public class ElementToPom {
    /**
     * Convert data to POM.xml ready to use string
     * 
     * @param groupId The jar groupId
     * @param artifactId The jar artifactId
     * @param version The jar version
     * @return The generated string
     */
    public static String convert(String groupId, String artifactId,
                String version) {
        if(groupId == null || groupId.equals("")) {
            groupId = "{groupId}";
        }
        if(artifactId == null || artifactId.equals("")) {
            artifactId = "{artifactId}";
        }
        if(version == null || version.equals("")) {
            version = "{version}";
        }
        return    "  <dependency>\n"
                + "    <groupId>" + groupId + "</groupId>\n"
                + "    <artifactId>" + artifactId + "</artifactId>\n"
                + "    <version>" + version + "</version>\n"
                + "  </dependency>\n";
    }
}
