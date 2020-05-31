package com.application.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /**
     * Создает фабрику сессий
     */

    public static void buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml").build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }

    }

    /**
     * @return возвращает фабрику сессий
     */

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Метод открывает новую сессию
     *
     * @return возвращает сессию
     */

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * Метод закрывает сессию
     */

    public static void shutdown() {
        getSessionFactory().close();
    }
}
