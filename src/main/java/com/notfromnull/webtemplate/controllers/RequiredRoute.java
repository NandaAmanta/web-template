/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.notfromnull.webtemplate.controllers;

import com.notfromnull.webtemplate.dto.ResponseListData;
import com.notfromnull.webtemplate.dto.ResponseSingleData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ASUS
 * @param <T> Response
 */
public interface RequiredRoute<T> {

    @GetMapping("/")
    public ResponseListData<T> getAllData();

    @GetMapping("/{id}")
    public ResponseSingleData<T> getDetailData(@PathVariable String id);

}
