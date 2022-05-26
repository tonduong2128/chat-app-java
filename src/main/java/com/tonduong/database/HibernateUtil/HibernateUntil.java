/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tonduong.database.HibernateUtil;

import com.tonduong.database.pojo.Room;
import com.tonduong.database.pojo.Joinroom;
import com.tonduong.database.pojo.Message;
import com.tonduong.database.pojo.User;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ADMIN
 */
public class HibernateUntil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            File fileConfig = new File("src/main/java/com/tonduong/database/config/hibernate.cgf.xml");
            config.configure(fileConfig);

            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(Room.class);
            config.addAnnotatedClass(Joinroom.class);
            config.addAnnotatedClass(Message.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
