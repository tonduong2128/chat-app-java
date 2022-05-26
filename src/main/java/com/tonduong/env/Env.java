/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.env;

/**
 *
 * @author ADMIN
 */
public class Env {

    public Env() {
    }
    private static final int PORT = 6000;
    private static final String IP = "192.168.1.10";
    private static final int MAXIMUM_CONNECT = 100;

    public static int getPORT() {
        return PORT;
    }

    public static String getIP() {
        return IP;
    }

    public static int getMAXIMUM_CONNECT() {
        return MAXIMUM_CONNECT;
    }

}
