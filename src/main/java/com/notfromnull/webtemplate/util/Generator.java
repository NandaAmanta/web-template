/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.util;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class Generator {

    public String generateZipEntry(String file, String sourceFolder) {
        return file.substring(sourceFolder.length() + 1, file.length());
    }


}
