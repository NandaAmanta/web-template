/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.controllers;

import com.notfromnull.webtemplate.service.BannerService;
import com.notfromnull.webtemplate.service.FooterService;
import com.notfromnull.webtemplate.service.NavbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class ViewController {

    @Autowired
    BannerService bannerService;

    @Autowired
    FooterService footerService;

    @Autowired
    NavbarService navbarService;

    @GetMapping()
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping("/templates")
    public String getTemplatesPage(Model model) {
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("navbars", navbarService.getAllNavbar());
        model.addAttribute("footers", footerService.getAllFooter());
        return "templates";
    }

    @GetMapping("/footer")
    public String getListFooterPage(Model model) {
        model.addAttribute("footers", footerService.getAllFooter());
        return "list-footer";
    }

    @GetMapping("/navbar")
    public String getListNavberPage(Model model) {
        model.addAttribute("navbars", navbarService.getAllNavbar());
        return "list-navbar";
    }

    @GetMapping("/banner")
    public String getListBannerPage(Model model) {
        model.addAttribute("banners", bannerService.getAllBanner());
        return "list-banner";
    }

    @GetMapping("/preview")
    public String getPreviewPage(Model model) {
        return "preview";
    }
}
