package com.gwt.server.dao.impl;

import com.gwt.server.model.User;
import com.gwt.server.utils.HibernateUtil;
import com.gwt.server.utils.SecureUtil;
import com.gwt.server.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static com.gwt.server.utils.HibernateUtil.getEntityManager;


/**
 * @author Sergiy_Solovyov
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void create(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        user.setPassword(SecureUtil.encrypt(user.getPassword()));
        em.persist(user);
        transaction.commit();
        em.close();
    }

    @Override
    public User findByLogin(String login) {
        EntityManager em = getEntityManager();
        User user = (User) em.createQuery(
                "from User where login = :login")
                .setParameter("login", login)
                .getSingleResult();
        em.close();
        return user;

    }
}
