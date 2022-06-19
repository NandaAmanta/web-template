/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.dto;

import java.util.List;
import lombok.Data;
import org.apache.catalina.connector.Response;

/**
 *
 * @author ASUS
 */
@Data
public class ResponseListData<T> extends Response{
    private List<T> data;
}
