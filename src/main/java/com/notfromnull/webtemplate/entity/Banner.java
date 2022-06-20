/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ASUS
 */
@Document(collection = "Banner")
public class Banner {

    /**
     * @return the html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html the html to set
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * @return the css
     */
    public String getCss() {
        return css;
    }

    /**
     * @param css the css to set
     */
    public void setCss(String css) {
        this.css = css;
    }

    /**
     * @return the images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * @return the js
     */
    public String getJs() {
        return js;
    }

    /**
     * @param js the js to set
     */
    public void setJs(String js) {
        this.js = js;
    }

    private String html;
    private String css;
    private List<String> images;
    private String js;
}
