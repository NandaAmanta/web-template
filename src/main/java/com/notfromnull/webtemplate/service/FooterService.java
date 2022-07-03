/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.entity.Footer;
import com.notfromnull.webtemplate.repository.FooterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class FooterService {

    @Autowired
    FooterRepository footerRepository;

    public List<Footer> getAllFooter() {
        return footerRepository.findAll();
    }

    public Footer getDetailFooter(String id) {
        return footerRepository.findByTemplateId(id).orElse(null);
    }
}
