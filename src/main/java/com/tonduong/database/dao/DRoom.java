/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.dao;

import com.tonduong.database.HibernateUtil.HibernateUntil;
import com.tonduong.database.pojo.Room;
import com.tonduong.database.pojo.User;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class DRoom {

    public static void add(Room group) {
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
            session.close();
        }
    }
  public static void update(Room room ){
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.update(room);
            session.getTransaction().commit();
            session.close();
        }
    }
    public static Room find(String id) {
        Room group = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select G from Room AS G WHERE G.id=:id";
            group = (Room) session.createQuery(query)
                    .setParameter("id", id)
                    .list().get(0);

            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            return new Room();
        }
        return group;
    }
}
