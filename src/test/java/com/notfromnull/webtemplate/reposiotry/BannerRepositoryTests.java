/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.repository.BannerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ASUS
 */
@SpringBootTest
public class BannerRepositoryTests {

    @Autowired
    BannerRepository bannerRepository;

    @Test
    public void findByTemplateId_TemplateFound_True() {
        String templateId = "tes123";
        var banner = new Banner();
        banner.setTemplateId(templateId);
        bannerRepository.insert(banner);
        Assertions
                .assertTrue(bannerRepository
                        .findByTemplateId(templateId)
                        .isPresent());
        bannerRepository.delete(banner);
    }

    @Test
    public void findByTemplateId_TemplateNotFound_false() {
        String templateId = "ThereIsNoTemplateIdLikeThisBro";
        Assertions
                .assertFalse(bannerRepository
                        .findByTemplateId(templateId)
                        .isPresent());
    }

}
