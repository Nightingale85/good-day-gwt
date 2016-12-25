package com.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.gwt.client.utils.Messenger;

import static com.gwt.client.utils.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class MessengerEnGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.gwt.client.MainENJUnit";
    }

    public void testMessageRus() {
        Messenger messenger = Messenger.getInstance();
        assertEquals("Good morning", messenger.getMessage(MORNING));
        assertEquals("Good day", messenger.getMessage(DAY));
        assertEquals("Good evening", messenger.getMessage(EVENING));
        assertEquals("Good night", messenger.getMessage(NIGHT));
    }
}
