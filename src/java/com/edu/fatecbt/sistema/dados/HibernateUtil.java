package com.edu.fatecbt.sistema.dados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

    public static Session getSession() {
//        if (getSessionFactory().getCurrentSession() != null
//                || getSessionFactory().getCurrentSession().isOpen()) {
//            return getSessionFactory().getCurrentSession();
//        } else {
//            return getSessionFactory().openSession();
//        }
        return getSessionFactory().getCurrentSession();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}