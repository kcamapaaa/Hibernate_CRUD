package com.vladislav.util;

import com.vladislav.model.Developer;
import com.vladislav.model.Skill;
import com.vladislav.model.Specialty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtils {
    private static final SessionFactory sessionFactory;

    private HiberUtils() {
    }

    static{
        try{
            sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(Developer.class)
                    .addAnnotatedClass(Skill.class)
                    .addAnnotatedClass(Specialty.class)
                    .buildSessionFactory();
        } catch (Throwable th) {
            System.out.println("SessionFactory creation failed");
            throw new RuntimeException(th);
        }
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

}
