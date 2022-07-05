/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.repository.BannerRepository;
import com.notfromnull.webtemplate.repository.FooterRepository;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import com.notfromnull.webtemplate.util.Generator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 *
 * @author ASUS
 */
@Service
public class TemplateBuilderService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private FooterRepository footerRepository;

    @Autowired
    private NavbarRepository navbarRepository;

    @Autowired
    private Generator generator;

    private List<String> fileList = new ArrayList<String>();
    private static final String SOURCE_FOLDER = "D:\\git-project\\webtemplate\\tess\\Project";

    // main method
    public StreamingResponseBody buildProjectTemplateZip(HttpServletResponse response, String navbarId, String bannerId, String footerId) {
        generateFileList(new File(SOURCE_FOLDER));
        generateProject(navbarId, bannerId, footerId);
        return zipIt(response);
    }

    public StreamingResponseBody zipIt(HttpServletResponse response) {
        int BUFFER_SIZE = 1024;

        StreamingResponseBody streamResponseBody = out -> {
            List<String> fileListAlt = new ArrayList<>(fileList);
            fileList = new ArrayList<>();
            final ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            ZipEntry zipEntry = null;
            InputStream inputStream = null;

            try {
                for (String path : fileListAlt) {
                    File file = new File(SOURCE_FOLDER + File.separator + path);
                    zipEntry = new ZipEntry(path);
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
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
            fileList.add(generator.generateZipEntry(node.toString(), SOURCE_FOLDER));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private void generateProject(String navbarId, String bannerId, String footerId) {
        Banner banner = null;
        Navbar navbar = null;
        Footer footer = null;
        try {
// ----------- Html
            File fileHtml = new File("D:\\git-project\\webtemplate\\tess" + File.separator + "Project" + File.separator + "index.html");
            BufferedWriter bwHtml = new BufferedWriter(new FileWriter(fileHtml, false));
            bwHtml.write("<!doctype html>\n"
                    + "<html lang=\"en\">\n"
                    + "  <head>\n"
                    + "    <!-- Required meta tags -->\n"
                    + "    <meta charset=\"utf-8\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "\n"
                    + "    <!-- Bootstrap CSS -->\n"
                    + "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" integrity=\"sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/\" crossorigin=\"anonymous\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\n"
                    + "    <link rel=\"stylesheet\" href=\"./css/not-from-zero.css\" type=\"text/css\">\n"
                    + "\n"
                    + "    <title>Starter Project!</title>\n"
                    + "  </head>\n"
                    + "  <body>");
            bwHtml.newLine();

            if (navbarId != null) {
                navbar = navbarRepository.findByTemplateId(navbarId).orElseThrow();
                bwHtml.write(navbar.getHtml());
                bwHtml.newLine();
            }

            if (bannerId != null) {
                banner = bannerRepository.findByTemplateId(bannerId).orElseThrow();
                System.out.println(banner.getTemplateId());
                bwHtml.write(banner.getHtml());
                bwHtml.newLine();
            }

            if (footerId != null) {
                footer = footerRepository.findByTemplateId(footerId).orElseThrow();
                bwHtml.write(footer.getHtml());
                bwHtml.newLine();
            }

            bwHtml.write("<script src=\"./script/not-from-zero.js\" ></script>\n"
                    + "  </body>\n"
                    + "</html>");
            bwHtml.close();
// ------------ end Html

// ------------ Css
            File fileCSS = new File("D:\\git-project\\webtemplate\\tess" + File.separator + "Project" + File.separator + "css" + File.separator + "not-from-zero.css");
            BufferedWriter bwCSS = new BufferedWriter(new FileWriter(fileCSS, false));

            if (navbar != null && navbar.getCss() != null) {
                bwCSS.write(navbar.getCss());
                bwCSS.newLine();
            }

            if (banner != null && banner.getCss() != null) {
                bwCSS.write(banner.getCss());
                bwCSS.newLine();
            }

            if (footer != null && footer.getCss() != null) {
                bwCSS.write(footer.getCss());
                bwCSS.newLine();
            }

            bwCSS.close();
// ------------ end Css

// ------------ Js
            File fileJs = new File("D:\\git-project\\webtemplate\\tess" + File.separator + "Project" + File.separator + "script" + File.separator + "not-from-zero.js");
            BufferedWriter bwJs = new BufferedWriter(new FileWriter(fileJs, false));
            if (navbar != null && navbar.getJs() != null) {
                bwJs.write(navbar.getJs());
                bwJs.newLine();
            }

            if (banner != null && banner.getJs() != null) {
                bwJs.write(banner.getJs());
                bwJs.newLine();
            }

            if (footer != null && footer.getJs() != null) {
                bwJs.write(footer.getJs());
                bwJs.newLine();
            }

            bwJs.close();
// ------------ end Js

        } catch (IOException err) {
            System.out.print("---------------------------------------------> ");
            System.out.print(err.getMessage());
        }
    }
}
