/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.repository;

import com.notfromnull.webtemplate.entity.Navbar;
import com.notfromnull.webtemplate.entity.WebTemplate;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface NavbarRepository extends MongoRepository<Navbar, String> {
    Optional<WebTemplate> findByTemplateId(String templateId);
}
