/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity(name = "Room")
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "name")
    private String name;

    @Column(name = "port")
    private int port;

    public Room() {
    }

    public Room(String id, String ip, String name, int port) {
        this.id = id;
        this.ip = ip;
        this.name = name;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return port;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", ip=" + ip + ", name=" + name + ", port=" + port + '}';
    }
}
