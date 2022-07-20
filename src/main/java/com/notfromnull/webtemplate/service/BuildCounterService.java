/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.entity.WebTemplate;
import com.notfromnull.webtemplate.repository.BannerRepository;
import com.notfromnull.webtemplate.repository.FooterRepository;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
@Configurable
public class BuildCounterService extends Thread {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private NavbarRepository navbarRepository;

    @Autowired
    private FooterRepository footerRepository;

    private List<WebTemplate> listWebTemplate;

    public BuildCounterService(BannerRepository bannerRepository, NavbarRepository navbarRepository, FooterRepository footerRepository, List<WebTemplate> listWebTemplate) {
        this.bannerRepository = bannerRepository;
        this.navbarRepository = navbarRepository;
        this.footerRepository = footerRepository;
        this.listWebTemplate = listWebTemplate;
    }

    @Override
    public void run() {
        for (WebTemplate webTemplate : listWebTemplate) {
            System.out.println("Hai");
            if (webTemplate instanceof Banner) {
                webTemplate.setBuildCount(webTemplate.getBuildCount() + 1);
                bannerRepository.save((Banner) webTemplate);
                continue;
            }

            if (webTemplate instanceof Navbar) {
                webTemplate.setBuildCount(webTemplate.getBuildCount() + 1);
                navbarRepository.save((Navbar) webTemplate);
                continue;
            }

            if (webTemplate instanceof Footer) {
                webTemplate.setBuildCount(webTemplate.getBuildCount() + 1);
                footerRepository.save((Footer) webTemplate);
                continue;
            }
        }
    }
}
