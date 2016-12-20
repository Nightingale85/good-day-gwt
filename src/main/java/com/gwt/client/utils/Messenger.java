package com.gwt.client.utils;

import com.google.gwt.core.client.GWT;
import com.gwt.client.i18n.Message;

import java.util.Date;
import java.util.NoSuchElementException;

import static com.gwt.client.utils.DayPartUtil.getDayPart;

/**
 * @author Sergiy_Solovyov
 */
public class Messenger {
    private static Messenger instance;
    private final Message resource;

    public static Messenger getInstance() {
        if (instance == null) {
            instance = new Messenger();
        }
        return instance;
    }

    private Messenger() {
        this.resource = GWT.create(Message.class);
    }

    public String getMessage(DayPart dayPart) {
        switch (dayPart) {
            case MORNING:
                return resource.morning();
            case DAY:
                return resource.day();
            case EVENING:
                return resource.evening();
            case NIGHT:
                return resource.night();
            default:
                throw new NoSuchElementException();
        }
    }


}
