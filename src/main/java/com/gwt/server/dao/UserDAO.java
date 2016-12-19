package com.gwt.server.dao;


import com.gwt.server.model.User;

/**
 * @author Sergiy_Solovyov
 */
public interface UserDAO {

    void create(User user);

    User findByLogin(String login);
}
