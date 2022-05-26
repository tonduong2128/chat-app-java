/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.dao;

import com.tonduong.database.HibernateUtil.HibernateUntil;
import com.tonduong.database.pojo.User;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class DUser {

    public static void add(User user) {
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void update(User user) {
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static User find(String username, String password) {
        User user = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            String query = "Select U from User AS U WHERE U.username=:username AND password=:password";
            user = (User) session.createQuery(query)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .list().get(0);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            return null;
        }
        return user;
    }

    public static User find(String id) {
        User user = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            String query = "Select U from User AS U WHERE U.id=:id";
            user = (User) session.createQuery(query)
                    .setParameter("id", id)
                    .list().get(0);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
        return user;
    }

    public static List<User> search(String str) {
        List<User> list = null;
        try (Session session = HibernateUntil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            str = str.trim();
            String[] arr = str.split(" ");
            String query = " Select U "
                    + " from User AS U "
                    + " WHERE U.id=:id "
                    + " OR U.username=:username ";
            String temp = "";
            for (String string : arr) {
                string = string.trim();
                if (!string.equals("")) {
                    temp += " OR U.username LIKE '%" + string + "%' "
                            + " OR U.nickname LIKE '%" + string + "%' ";
                }
            }
            query += temp;
            System.err.println(query);
            list = session.createQuery(query)
                    .setParameter("id", str)
                    .setParameter("username", str)
                    .list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
        return list;
    }
}
