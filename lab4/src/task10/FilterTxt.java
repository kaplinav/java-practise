/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task10;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author User
 */

public class FilterTxt extends FileFilter {
    final static String TXT = "txt";
    
    public FilterTxt(){
        super();
    }
    
    @Override
    public boolean accept(File pathname) {
        if (pathname == null) 
            return false;
        
        if(pathname.isDirectory()) 
            return true;
        
        String extension = getExtension(pathname.getName());
        return extension == null ? false : TXT.equals(extension);
    }
    
    private String getExtension(String filename) {
        int index = filename.lastIndexOf('.');
        
        if (index > 0 && index < (filename.length() - 1) ) {
            return filename.substring(index + 1).toLowerCase();
        }
        return null;
    }
    
    @Override
    public String getDescription() {
        return "*.txt — text file";
    }
}
