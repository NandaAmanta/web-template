/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import org.junit.jupiter.api.AfterAll;
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
public class NavbarRepositoryTests {

    @Autowired
    NavbarRepository navbarRepository;

    private Navbar navbar;
    private final String templateId = "tes123";

    @BeforeAll
    public void setUp() {
        this.navbar = new Navbar();
        this.navbar.setTemplateId(templateId);
    }

    @AfterAll
    public void clear() {
        navbarRepository.delete(this.navbar);
    }

    @Test
    public void findByTemplateId_TemplateFound_True() {
        // Given
        navbarRepository.insert(navbar);

        // When
        boolean result = navbarRepository
                .findByTemplateId(templateId)
                .isPresent();

        // Given
        Assertions
                .assertTrue(result);
    }

    @Test
    public void findByTemplateId_TemplateNotFound_false() {
        // Given
        String randomTemplateId = "ThereIsNoTemplateIdLikeThisBro";

        // When
        boolean result = navbarRepository
                .findByTemplateId(randomTemplateId)
                .isPresent();

        // Given
        Assertions
                .assertFalse(result);
    }

}
