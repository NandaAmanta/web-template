/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.repository.BannerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ASUS
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BannerServiceTests {

    @Mock
    private BannerRepository bannerRepository;
    private BannerService bannerServiceUnserTest;

    @BeforeEach
    public void setUp() {
        bannerServiceUnserTest = new BannerService(bannerRepository);
    }

    @Test
    public void getAllBanner() {
        bannerServiceUnserTest.getAllBanner();
        Mockito.verify(bannerRepository).findAll();
    }
}
