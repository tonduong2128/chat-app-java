/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.model.struct;

import java.io.BufferedWriter;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class RoomWirter {

    private String id;
    private List<BufferedWriter> listBw;

    public RoomWirter() {
    }

    public RoomWirter(String id, List<BufferedWriter> listBw) {
        this.id = id;
        this.listBw = listBw;
    }

    public String getId() {
        return id;
    }

    public List<BufferedWriter> getListBw() {
        return listBw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListBw(List<BufferedWriter> listBw) {
        this.listBw = listBw;
    }

}
