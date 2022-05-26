/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.dao;

import com.tonduong.database.HibernateUtil.HibernateUntil;
import com.tonduong.database.pojo.Message;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class DMessage {

    public static void add(Message message) {
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static List<Message> find(String idGroup) {
        List<Message> listGroup = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select M from Message AS M WHERE M.idGroup=:idGroup ORDER BY M.time";
            listGroup = session.createQuery(query)
                    .setParameter("idGroup", idGroup)
                    .list();
            session.getTransaction().commit();
            session.close();
        }
        return listGroup;
    }
}
