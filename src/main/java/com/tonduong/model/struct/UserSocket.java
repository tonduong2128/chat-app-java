/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.model.struct;

import java.io.BufferedWriter;

/**
 *
 * @author ADMIN
 */
public class UserSocket {

    private String id;
    private BufferedWriter bw;

    public UserSocket() {
    }

    public UserSocket(String id, BufferedWriter bw) {
        this.id = id;
        this.bw = bw;
    }

    public String getId() {
        return id;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

}
