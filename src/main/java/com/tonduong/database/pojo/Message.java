/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity(name = "Message")
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "idUser")
    private String idUser;

    @Column(name = "idGroup")
    private String idGroup;

    @Column(name = "content")
    private String content;

    @Column(name = "time")
    private Timestamp time;

    public Message() {
    }

    public Message(String id, String idUser, String idGroup, String content, Timestamp time) {
        this.id = id;
        this.idUser = idUser;
        this.idGroup = idGroup;
        this.content = content;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", idUser=" + idUser + ", idGroup=" + idGroup + ", content=" + content + ", time=" + time + '}';
    }
    
}
