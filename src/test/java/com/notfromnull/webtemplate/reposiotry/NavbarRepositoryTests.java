/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ASUS
 */
@SpringBootTest
public class NavbarRepositoryTests {

    @Autowired
    NavbarRepository navbarRepository;

    @Test
    public void findByTemplateId_TemplateFound_True() {
        String templateId = "tes123";
        var navbar = new Navbar();
        navbar.setTemplateId(templateId);
        navbarRepository.insert(navbar);
        Assertions
                .assertTrue(navbarRepository
                        .findByTemplateId(templateId)
                        .isPresent());
        navbarRepository.delete(navbar);
    }

    @Test
    public void findByTemplateId_TemplateNotFound_false() {
        String templateId = "ThereIsNoTemplateIdLikeThisBro";
        Assertions
                .assertFalse(navbarRepository
                        .findByTemplateId(templateId)
                        .isPresent());
    }

}
