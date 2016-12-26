package com.gwt.server.dao.impl;

import com.gwt.server.model.User;
import com.gwt.server.utils.HibernateUtil;
import com.gwt.server.utils.SecureUtil;
import com.gwt.server.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * @author Sergiy_Solovyov
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        user.setPassword(SecureUtil.encrypt(user.getPassword()));
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.createCriteria(User.class, "users")
                .add(Restrictions.eq("users.login", login)).uniqueResult();
        session.close();
        return user;

    }
}
