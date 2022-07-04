/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.controllers;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.entity.WebTemplate;
import com.notfromnull.webtemplate.service.BannerService;
import com.notfromnull.webtemplate.service.FooterService;
import com.notfromnull.webtemplate.service.NavbarService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/services/web-template-builder")
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
    
    @GetMapping("/donation")
    public String getDonationPage(Model model) {
        return "donation";
    }

    @GetMapping("/preview")
    public String getPreviewPage(
            Model model,
            @RequestParam @Nullable String navbarId,
            @RequestParam @Nullable String bannerId,
            @RequestParam @Nullable String footerId) {
        Navbar navbar = new Navbar();
        Banner banner = new Banner();
        Footer footer = new Footer();

        if (navbarId != null) {
            navbar = navbarService.getDetailNavbar(navbarId);
        }

        if (bannerId != null) {
            banner = bannerService.getDetailBanner(bannerId);
        }

        if (footerId != null) {
            footer = footerService.getDetailFooter(footerId);
        }
        
        model.addAttribute("banner", banner);
        model.addAttribute("navbar", navbar);
        model.addAttribute("footer", footer);

        return "preview";
    }
}
