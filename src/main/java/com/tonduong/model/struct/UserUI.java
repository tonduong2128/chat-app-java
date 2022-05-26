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
