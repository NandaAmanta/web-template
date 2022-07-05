/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;

import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.repository.FooterRepository;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ASUS
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FooterRepositoryTests {

    @Autowired
    FooterRepository footerRepository;

    private Footer footer;
    private final String templateId = "tes123";

    @BeforeAll
    public void setUp() {
        this.footer = new Footer();
        this.footer.setTemplateId(templateId);
    }

    @AfterAll
    public void clear() {
        footerRepository.delete(footer);

    }

    @Test
    public void findByTemplateId_TemplateFound_True() {
        // Given
        footerRepository.insert(footer);

        // When
        boolean result = footerRepository
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
        boolean result = footerRepository
                .findByTemplateId(randomTemplateId)
                .isPresent();

        // Then
        Assertions.assertFalse(result);
    }

}
