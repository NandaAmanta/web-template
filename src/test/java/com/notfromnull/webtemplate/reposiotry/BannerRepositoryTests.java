/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.repository.BannerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ASUS
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BannerRepositoryTests {

    @Autowired
    BannerRepository bannerRepository;

    private Banner banner;
    private final String templateId = "tes123";

    @BeforeAll
    public void setUp() {
        // SetUp Data
        this.banner = new Banner();
        this.banner.setTemplateId(templateId);
    }

    @AfterAll
    public void clear() {
        bannerRepository.delete(banner);
    }

    @Test
    public void findByTemplateId_TemplateFound_True() {
        // Given 
        bannerRepository.insert(banner);
        
        // When
        boolean result = bannerRepository
                .findByTemplateId(templateId)
                .isPresent();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    public void findByTemplateId_TemplateNotFound_false() {
        // Given
        String randomTemplateId = "ThereIsNoTemplateIdLikeThisBro";

        // When 
        boolean result = bannerRepository
                .findByTemplateId(randomTemplateId)
                .isPresent();

        // Then
        Assertions.assertFalse(result);
    }

}
