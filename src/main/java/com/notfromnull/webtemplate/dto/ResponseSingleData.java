/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.dto;

import lombok.Data;
import org.apache.catalina.connector.Response;

/**
 *
 * @author ASUS
 */
@Data
public class ResponseSingleData<T> extends Response{
    private T data;
}
