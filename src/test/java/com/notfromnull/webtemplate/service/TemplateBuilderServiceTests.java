/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.service;

import com.notfromnull.webtemplate.repository.BannerRepository;
import com.notfromnull.webtemplate.repository.FooterRepository;
import com.notfromnull.webtemplate.repository.NavbarRepository;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 *
 * @author ASUS
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TemplateBuilderServiceTests {

    @Mock
    private BannerRepository bannerRepository;

    @Mock
    private NavbarRepository navbarRepository;

    @Mock
    private FooterRepository footerRepository;

    private final HttpServletResponse httpServletResponse = new MockHttpServletResponse();

    private TemplateBuilderService templateBuilderServiceUnderTest;

    @BeforeEach
    public void setUp() {
        templateBuilderServiceUnderTest = new TemplateBuilderService(bannerRepository, footerRepository, navbarRepository);
    }

    @Test
    public void buildProjectTemplateZip_SuccessBuildTemplateWithoutTemplate_StreamingResponseBody() {
        templateBuilderServiceUnderTest.buildProjectTemplateZip(httpServletResponse, "p", "asd", "as");
    }

}
