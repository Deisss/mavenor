package com.klinq.maven.filter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Manage filter for jar files
 * 
 * @author Deisss
 */
public class FilterJar extends FileFilter {
    @Override
    public boolean accept(File f) {
        String path = f.getAbsolutePath();
        if(
                f.isDirectory() ||
                (
                    f.isFile() && 
                    path.substring(path.lastIndexOf(".")).equals(".jar")
                )
          ) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Java JAR file";
    }
    
}
