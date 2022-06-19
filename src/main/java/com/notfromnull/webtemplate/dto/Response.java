/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.dto;

import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class Response {
    private boolean ok;
    private String statusCode;
    private String message;;
}
