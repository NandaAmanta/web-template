/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.reposiotry;
import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.repository.FooterRepository;
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
public class FooterRepositoryTests {

    @Autowired
    FooterRepository footerRepository;

    @Test
    public void findByTemplateId_TemplateFound_True() {
        String templateId = "tes123";
        var footer = new Footer();
        footer.setTemplateId(templateId);
        footerRepository.insert(footer);
        Assertions
                .assertTrue(footerRepository
                        .findByTemplateId(templateId)
                        .isPresent());
        footerRepository.delete(footer);
    }

    @Test
    public void findByTemplateId_TemplateNotFound_false() {
        String templateId = "ThereIsNoTemplateIdLikeThisBro";
        Assertions
                .assertFalse(footerRepository
                        .findByTemplateId(templateId)
                        .isPresent());
    }

}
