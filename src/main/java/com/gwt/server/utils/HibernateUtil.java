package com.gwt.server.utils;


import com.gwt.server.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Sergiy_Solovyov
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);
    static {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(User.class).configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            LOGGER.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void close(){
        sessionFactory.close();
    }
}