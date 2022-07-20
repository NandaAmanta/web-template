/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.entity;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author ASUS
 */
@Data
public abstract class WebTemplate {

    @Id
    private String templateId;
    private String name;
    private String description;
    private String html;
    private String css;
    private List<String> images;
    private String js;
    private String previewImage;
    private Date createdAt;
    private int buildCount;
    
}
