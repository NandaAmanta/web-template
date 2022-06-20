/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 *
 * @author ASUS
 */
@Service
public class TemplateBuilderService {

    private List<String> fileList = new ArrayList<String>();
    private static final String SOURCE_FOLDER = "D:\\git-project\\webtemplate\\template";
    private static final String OUTPUT = "NotFromZero_TemplateProject.zip";

    public StreamingResponseBody buildProjectTemplateZip(HttpServletResponse response) {
        generateFileList(new File(SOURCE_FOLDER));
        return zipIt(OUTPUT, response);
    }

    public StreamingResponseBody zipIt(String zipFile, HttpServletResponse response) {
        System.out.println(fileList);
        int BUFFER_SIZE = 1024;

        StreamingResponseBody streamResponseBody = out -> {

            final ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            ZipEntry zipEntry = null;
            InputStream inputStream = null;

            try {
                for (String path : fileList) {
                    File file = new File(SOURCE_FOLDER + File.separator + path);
                    zipEntry = new ZipEntry(path + File.separator + file.getName());

                    inputStream = new FileInputStream(file);

                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] bytes = new byte[BUFFER_SIZE];
                    int length;
                    while ((length = inputStream.read(bytes)) >= 0) {
                        zipOutputStream.write(bytes, 0, length);
                    }

                }
                // set zip size in response
                response.setContentLength((int) (zipEntry != null ? zipEntry.getSize() : 0));
            } catch (IOException e) {
                System.err.println("Exception while reading and streaming data " + e);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            }

        };
        return streamResponseBody;
//        byte[] buffer = new byte[1024];
//        String source = new File(SOURCE_FOLDER).getName();
//        FileOutputStream fos = null;
//        ZipOutputStream zos = null;
//        try {
//            fos = new FileOutputStream(zipFile);
//            zos = new ZipOutputStream(fos);
//
//            System.out.println("Output to Zip : " + zipFile);
//            FileInputStream in = null;
//
//            for (String file : fileListAlt) {
//                System.out.println("File Added : " + file);
//                ZipEntry ze = new ZipEntry(source + File.separator + file);
//                zos.putNextEntry(ze);
//                try {
//                    in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
//                    int len;
//                    while ((len = in.read(buffer)) > 0) {
//                        zos.write(buffer, 0, len);
//                    }
//                } finally {
//                    in.close();
//                }
//            }
//
//            zos.closeEntry();
//            System.out.println("Folder successfully compressed");
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                zos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }
}
