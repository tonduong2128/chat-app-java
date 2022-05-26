/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.model.struct;

/**
 *
 * @author ADMIN
 */
public class Action<T> {

    private TypeAction type;
    private T payload;

    public Action() {
    }

    public Action(TypeAction type, T payload) {
        this.type = type;
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public TypeAction getType() {
        return type;
    }

    public void setType(TypeAction type) {
        this.type = type;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
