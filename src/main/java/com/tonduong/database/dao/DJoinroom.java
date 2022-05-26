/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.dao;

import com.tonduong.database.HibernateUtil.HibernateUntil;
import com.tonduong.database.pojo.Room;
import com.tonduong.database.pojo.Joinroom;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class DJoinroom {

    public static void add(Joinroom group) {
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static List<Joinroom> find(String idUser) {
        List<Joinroom> listGroup = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select J from Joinroom AS J WHERE J.idUser=:idUser";
            listGroup = session.createQuery(query)
                    .setParameter("idUser", idUser)
                    .list();
            session.getTransaction().commit();
            session.close();
        }
        return listGroup;
    }

    public static List<Joinroom> findByIdRoom(String idRoom) {
        List<Joinroom> listGroup = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select J from Joinroom AS J WHERE J.idGroup=:idGroup";
            listGroup = session.createQuery(query)
                    .setParameter("idGroup", idRoom)
                    .list();
            session.getTransaction().commit();
            session.close();
        }
        return listGroup;
    }

    public static List<Joinroom> findByIdRoomWithUserOnline(String idRoom) {
        List<Joinroom> listGroup = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select J from Joinroom AS J "
                    + "JOIN User AS U "
                    + "ON U.id = J.idUser "
                    + "WHERE J.idGroup=:idGroup AND U.isOnline=1";
            listGroup = session.createQuery(query)
                    .setParameter("idGroup", idRoom)
                    .list();
            session.getTransaction().commit();
            session.close();
        }
        return listGroup;
    }
}
