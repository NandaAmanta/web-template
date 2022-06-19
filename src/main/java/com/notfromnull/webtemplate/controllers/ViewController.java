/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class ViewController {

    @GetMapping
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping("/templates")
    public String getTemplatesPage(Model model) {
        return "templates";
    }

    @GetMapping("/footer")
    public String getListFooterPage(Model model) {
        return "list-footer";
    }

    @GetMapping("/navbar")
    public String getListNavberPage(Model model) {
        return "list-navbar";
    }

    @GetMapping("/banner")
    public String getListBannerPage(Model model) {
        return "list-banner";
    }

    
    @GetMapping("/preview")
    public String getPreviewPage(Model model) {
        return "preview";
    }
}
