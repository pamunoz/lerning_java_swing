/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.swing.gui;

/**
 *
 * @author pablo
 */
public class Utils {
    
    public static String getFileExtension(String name) {
        
        int pointIndex = name.lastIndexOf(".");
        String subName = name.substring(pointIndex + 1, name.length());
        String result = (pointIndex == -1 || pointIndex == name.length() -1) ? null : subName;
        return result;
    }
    
}
