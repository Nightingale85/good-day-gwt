package com.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwt.client.service.LoginRemoteService;
import com.gwt.client.service.LoginRemoteServiceAsync;


/**
 * @author Sergiy_Solovyov
 */
public class LoginRemoteServiceImplGwtTest extends GWTTestCase {

    public String getModuleName() {
        return "com.gwt.client.MainJUnit";
    }

    public void testLogin() {
        LoginRemoteServiceAsync loginService = GWT.create(LoginRemoteService.class);
        ServiceDefTarget target = (ServiceDefTarget) loginService;
        target.setServiceEntryPoint(GWT.getModuleBaseURL() + "gwt/login");
        loginService.login("ivan", "secret", new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                fail(caught.getMessage());
            }

            @Override
            public void onSuccess(String name) {
                assertEquals("Иван", name);
                finishTest();
            }
        });
    }
}
