/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.model.struct;

/**
 *
 * @author ADMIN
 */
public class UserUI {

    public UserUI() {
    }
    private static String id;
    private static String nickname;
    private static int port;
    private static String ip;

    public static void setIp(String ip) {
        UserUI.ip = ip;
    }

    public  static String getIp() {
        return UserUI.ip;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        UserUI.port = port;
    }
    
    public static void setNickname(String nickname) {
        UserUI.nickname = nickname;
    }

    public static String getNickname() {
        return nickname;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserUI.id = id;
    }
}
