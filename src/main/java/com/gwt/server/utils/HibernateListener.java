package com.gwt.server.utils;

import com.gwt.server.dao.impl.UserDAOImpl;
import com.gwt.server.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static com.gwt.server.utils.HibernateUtil.*;

/**
 * @author Sergiy_Solovyov
 */
public class HibernateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
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

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        close();
    }
}
