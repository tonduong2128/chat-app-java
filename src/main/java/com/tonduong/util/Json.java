/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Json {

    public Json() {
    }

    public static String stringify(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static JsonNode parse(String str) {
        try {
            return new ObjectMapper().readTree(str);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
