package com.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.log4j.Logger;
import com.gwt.client.service.LoginRemoteService;
import com.gwt.server.dao.UserDAO;
import com.gwt.server.dao.impl.UserDAOImpl;
import com.gwt.server.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.gwt.server.utils.SecureUtil.matches;

/**
 * @author Sergiy_Solovyov
 */
public class LoginRemoteServiceImpl extends RemoteServiceServlet implements LoginRemoteService {

    private static final Logger LOGGER = Logger.getLogger(LoginRemoteServiceImpl.class);
    private final UserDAO userDAO;

    public LoginRemoteServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public String login(String login, String password) {

        User user = userDAO.findByLogin(login);
        if(user != null
                && matches(password, user.getPassword())) {
            LOGGER.info("Success login and password.");
            return user.getName();
        } else {
            LOGGER.warn("Wrong login or password.");
            return null;
        }
    }

    @Override
    public void logout() {
        LOGGER.info("Invalidate session.");
        HttpServletRequest httpServletRequest = getThreadLocalRequest();
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
    }
}
