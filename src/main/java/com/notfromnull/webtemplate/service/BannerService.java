/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.entity.Banner;
import com.notfromnull.webtemplate.repository.BannerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class BannerService {

    @Autowired
    BannerRepository bannerRepository;

    public List<Banner> getAllBanner() {
        return bannerRepository.findAll();
    }

    public Banner getDetailBanner(String id) {
        return bannerRepository.findByTemplateId(id).orElse(null);
    }
}
