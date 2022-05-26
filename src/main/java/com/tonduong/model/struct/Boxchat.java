/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.model.struct;

import com.tonduong.database.pojo.Message;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Boxchat {

    private String id;
    private String name;
    private List<Message> listMessage;

    public Boxchat() {
    }

    public Boxchat(String id, String name, List<Message> listMessage) {
        this.id = id;
        this.name = name;
        this.listMessage = listMessage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }
}
