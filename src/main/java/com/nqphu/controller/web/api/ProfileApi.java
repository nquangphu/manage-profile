/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nqphu.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nqphu.model.ProfileModel;
import com.nqphu.utils.HttpUtil;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phu
 */
@WebServlet(urlPatterns = {"/api-profile"})
public class ProfileApi extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BufferedReader br;
        br = req.getReader();
        HttpUtil of = HttpUtil.of(br);
        ProfileModel pro = of.toModel(ProfileModel.class);
        mapper.writeValue(resp.getOutputStream(), pro);
    }
    
}
