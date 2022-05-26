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
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private int port;

    @Column(name = "isOnline")
    private Boolean isOnline;

    public User() {
    }

    public User(String id, String username, String password, String nickname, String ip, int port) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.ip = ip;
        this.port = port;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public User(String id, String username, String password, String nickname, String ip, int port, Boolean isOnline) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.ip = ip;
        this.port = port;
        this.isOnline = isOnline;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname + ", ip=" + ip + ", port=" + port + '}';
    }
}
