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
@Entity(name = "Joinroom")
@Table(name = "joinroom")
public class Joinroom implements Serializable{

    @Id
    @Column(name = "idUser")
    private String idUser;
    
    @Id
    @Column(name = "idGroup")
    private String idGroup;

    public String getIdUser() {
        return idUser;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Joingroup{" + "idUser=" + idUser + ", idGroup=" + idGroup + '}';
    }

}
