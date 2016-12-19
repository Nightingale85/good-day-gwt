package com.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Sergiy_Solovyov
 */
public interface LoginRemoteServiceAsync {

    void login(String login, String password, AsyncCallback<String> asyncCallback);

    void logout(AsyncCallback asyncCallback);
}