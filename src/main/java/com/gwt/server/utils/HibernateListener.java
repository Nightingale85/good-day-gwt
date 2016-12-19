package com.gwt.server.utils;

import com.gwt.server.dao.impl.UserDAOImpl;
import com.gwt.server.model.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Sergiy_Solovyov
 */
public class HibernateListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user1 = new User();
        user1.setLogin("ivan");
        user1.setPassword("secret");
        user1.setName("Иван");
        User user2 = new User();
        user2.setLogin("john");
        user2.setPassword("smith");
        user2.setName("John");
        userDAO.create(user1);
        userDAO.create(user2);
    }

    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.close();
    }
}