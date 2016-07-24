/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.swing.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author pablo
 */
public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        
        if(file.isDirectory()) return true;
        
        String name = file.getName();
        String extension = Utils.getFileExtension(name);
        return extension.equals("per");
    }
        

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
    
}
