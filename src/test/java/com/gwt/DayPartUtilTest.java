package com.gwt;

import com.gwt.client.utils.DayPart;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Date;

import static com.gwt.client.utils.DayPart.*;
import static com.gwt.client.utils.DayPartUtil.getDayPart;
import static org.junit.Assert.assertEquals;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class DayPartUtilTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { MORNING, new Date(2000, 10, 10, 6, 0)},
                { MORNING, new Date(2000, 10, 10, 8, 0)},
                { MORNING, new Date(2000, 10, 10, 8, 59)},
                { DAY, new Date(2000, 10, 10, 9, 0)},
                { DAY, new Date(2000, 10, 10, 11, 0)},
                { DAY, new Date(2000, 10, 10, 18, 59)},
                { EVENING, new Date(2000, 10, 10, 19, 0)},
                { EVENING, new Date(2000, 10, 10, 21, 15)},
                { EVENING, new Date(2000, 10, 10, 22, 59)},
                { NIGHT, new Date(2000, 10, 10, 23, 0)},
                { NIGHT, new Date(2000, 10, 10, 23, 59)},
                { NIGHT, new Date(2000, 10, 10, 0, 0)},
                { NIGHT, new Date(2000, 10, 10, 3, 0)},
                { NIGHT, new Date(2000, 10, 10, 5, 59)}
        };
    }
    @Test
    @UseDataProvider("data")
    public void testGetDayPart(DayPart dayPart, Date time) {
        assertEquals(dayPart, getDayPart(time));
    }
}
