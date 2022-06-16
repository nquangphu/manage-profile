/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nqphu.utils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;


/**
 *
 * @author phu
 */
public class FormUtil {
    
    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> clss, HttpServletRequest request) {
        T object = null;
        try {
            object = clss.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
                
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());;
        }
        return object;
    }
    
}
