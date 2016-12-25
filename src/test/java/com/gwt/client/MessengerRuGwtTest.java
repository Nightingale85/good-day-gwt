package com.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.gwt.client.utils.Messenger;

import static com.gwt.client.utils.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class MessengerRuGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.gwt.client.MainRUJUnit";
    }

    public void testMessageRus() {
        Messenger messenger = Messenger.getInstance();
        assertEquals("Доброе утро", messenger.getMessage(MORNING));
        assertEquals("Добрый день", messenger.getMessage(DAY));
        assertEquals("Добрый вечер", messenger.getMessage(EVENING));
        assertEquals("Доброй ночи", messenger.getMessage(NIGHT));

    }
}
