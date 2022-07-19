/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.controllers;

import com.notfromnull.webtemplate.service.TemplateBuilderService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/template/build")
public class TemplateBuilderController {

    @Autowired
    TemplateBuilderService templateBuilderService;

    @GetMapping(produces = "application/zip")
    public ResponseEntity<StreamingResponseBody> buildTemplate(
            HttpServletResponse response,
            @RequestParam @Nullable String navbarId,
            @RequestParam @Nullable String bannerId,
            @RequestParam @Nullable String footerId) {
        response.setHeader("Content-Disposition", "attachment; filename=NFZero_starter-project.zip");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Expires", "0");
        var streamResult = templateBuilderService.buildProjectTemplateZip(response, navbarId, bannerId, footerId);
        return ResponseEntity.ok(streamResult);
    }

}
