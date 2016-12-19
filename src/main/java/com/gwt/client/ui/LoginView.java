package com.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;

import com.google.gwt.user.client.ui.*;
import com.gwt.client.i18n.Message;

/**
 * @author Sergiy_Solovyov
 */
public class LoginView extends Composite {

    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    @UiField(provided = true)
    final Message i18n;
    @UiField
    TextBox loginBox;
    @UiField
    TextBox passwordBox;
    @UiField
    Button buttonSubmit;

    public LoginView() {
        this.i18n = GWT.create(Message.class);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void showLogin() {
        RootPanel.get().add(this);
    }

    public void clearLogin() {
        RootPanel.get().clear();
        loginBox.setValue("");
        passwordBox.setValue("");
    }

    public static LoginUiBinder getUiBinder() {
        return uiBinder;
    }

    public static void setUiBinder(LoginUiBinder uiBinder) {
        LoginView.uiBinder = uiBinder;
    }


    public Message getI18n() {
        return i18n;
    }

    public TextBox getLoginBox() {
        return loginBox;
    }

    public void setLoginBox(TextBox loginBox) {
        this.loginBox = loginBox;
    }

    public TextBox getPasswordBox() {
        return passwordBox;
    }

    public void setPasswordBox(TextBox passwordBox) {
        this.passwordBox = passwordBox;
    }

    public Button getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(Button buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

    @UiTemplate("LoginView.ui.xml")
    interface LoginUiBinder extends UiBinder<Widget, LoginView> {
    }
}