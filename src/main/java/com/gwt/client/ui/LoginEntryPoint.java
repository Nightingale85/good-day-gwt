package com.gwt.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.gwt.client.service.LoginRemoteService;
import com.gwt.client.utils.Messenger;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sergiy_Solovyov
 */
public class LoginEntryPoint implements EntryPoint {
    private static final Logger LOGGER = Logger.getLogger(LoginEntryPoint.class.getName());
    private LoginView loginView = GWT.create(LoginView.class);
    private HomePageView homeView = GWT.create(HomePageView.class);


    public void onModuleLoad() {
        loginView.getButtonSubmit().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                    LOGGER.log(Level.INFO, "Sending user credentials to server.");
                    sendToServer(loginView.getLoginBox().getValue(), loginView.getPasswordBox().getValue());

            }
        });
        homeView.getLogOut().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                LoginRemoteService.Async.getInstance().logout(new AsyncCallback() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        LOGGER.log(Level.SEVERE, "Error with logout operation.");
                        Window.alert(loginView.getI18n().logoutProblem());
                    }

                    @Override
                    public void onSuccess(Object o) {
                        LOGGER.log(Level.INFO, "Logout successful.");
                        RootPanel.get().clear();
                        loginView.showLogin();
                    }
                });
            }
        });
            loginView.showLogin();
    }

    private void sendToServer(String login, String password) {
        LoginRemoteService.Async.getInstance().login(login, password, new AsyncCallback<String>() {
            @Override
            public void onSuccess(String name) {
                if (name != null) {
                    LOGGER.log(Level.INFO, "Success login operation.");
                    showHomePage(name);
                } else {
                    LOGGER.log(Level.WARNING, "Access Denied. Wrong login or password.");
                    Window.alert(loginView.getI18n().accessDenied());
                }
            }

            @Override
            public void onFailure(Throwable caught) {
                LOGGER.log(Level.SEVERE, "Error with login operation.", caught);
                Window.alert(loginView.getI18n().accessDenied());
            }
        });
    }


    public void showHomePage(String name) {
        loginView.clearLogin();
        LOGGER.log(Level.INFO, new Date().toString());
        String greeting = Messenger.getInstance().getMessage(new Date());
        String userGreeting = homeView.getI18n().greeting(greeting, name);
        homeView.getUserGreeting().setText(userGreeting);
        RootPanel.get().add(homeView);
    }
}