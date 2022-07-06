/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
@AllArgsConstructor
public class NavbarService {

    @Autowired
    NavbarRepository navbarRepository;

    public List<Navbar> getAllNavbar() {
        return navbarRepository.findAll();
    }

    public Navbar getDetailNavbar(String id) {
        return navbarRepository.findByTemplateId(id).orElse(null);
    }
}
