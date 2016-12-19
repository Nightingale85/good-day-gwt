package com.gwt.client.utils;



import java.util.Date;
import static com.gwt.client.utils.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class DayPartUtil {

    public static DayPart getDayPart(Date date){
        int hour = date.getHours();
        if (6 <= hour && hour < 9){
            return MORNING;
        } else if (9 <= hour && hour < 19){
            return DAY;
        } else if (19 <= hour && hour < 23){
            return EVENING;
        } else return NIGHT;
    }
}
