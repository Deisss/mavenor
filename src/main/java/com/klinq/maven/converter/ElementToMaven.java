package com.klinq.maven.converter;

/**
 * Convert many elements to maven string
 * 
 * @author Deisss
 */
public class ElementToMaven {
    /**
     * Convert data to maven include line ready
     * 
     * @param filepath
     * @param groupId
     * @param artifactId
     * @param version
     * @param packaging
     * @return 
     */
    public static String convert(String filepath, String groupId,
                String artifactId, String version, String packaging) {
        if(filepath == null || filepath.equals("")) {
            filepath = "{filepath}";
        }
        if(groupId == null || groupId.equals("")) {
            groupId = "{groupId}";
        }
        if(artifactId == null || artifactId.equals("")) {
            artifactId = "{artifactId}";
        }
        if(version == null || version.equals("")) {
            version = "{version}";
        }
        if(packaging == null || packaging.equals("")) {
            packaging = "{packaging}";
        }

        return    "mvn install:install-file\n"
                + " -Dfile=\"" + filepath +     "\"\n"
                + " -DgroupId=" + groupId +       "\n"
                + " -DartifactId=" + artifactId + "\n"
                + " -Dversion=" + version +       "\n"
                + " -Dpackaging=" + packaging +   "\n";
    }
}
