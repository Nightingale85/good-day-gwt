package com.gwt;

import com.gwt.server.dao.impl.UserDAOImpl;
import com.gwt.server.model.User;
import org.junit.Test;
import static com.gwt.server.utils.SecureUtil.matches;
import static org.junit.Assert.*;

/**
 * @author Sergiy_Solovyov
 */
public class UserDAOImplTest {
    @Test
    public void userDAO(){
        //GIVEN
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User();
        user.setLogin("login-test");
        user.setPassword("password-test");
        user.setName("test");
        userDAO.create(user);
        //WHEN
        User test = userDAO.findByLogin("login-test");
        //THEN
        assertTrue(user.getLogin().equals(test.getLogin()));
        assertTrue(user.getName().equals(test.getName()));
        assertTrue(matches("password-test", test.getPassword()));
    }
}
