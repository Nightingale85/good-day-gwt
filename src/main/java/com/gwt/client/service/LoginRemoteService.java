package com.gwt.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Sergiy_Solovyov
 */
@RemoteServiceRelativePath("login")
public interface LoginRemoteService extends RemoteService {

    class Async {
        private static LoginRemoteServiceAsync instance;

        public static LoginRemoteServiceAsync getInstance() {
            if (instance == null) {
                instance = GWT.create(LoginRemoteService.class);
            }
            return instance;
        }
    }

    String login(String login, String password);

    void logout();
}