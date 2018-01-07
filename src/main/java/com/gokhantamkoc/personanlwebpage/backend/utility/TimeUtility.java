package com.gokhantamkoc.personanlwebpage.backend.utility;

import java.util.Calendar;
import java.util.Date;

public class TimeUtility {
    public static Date addHoursToDate(Date date, int hours) {
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(date); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
        return new Date(cal.getTime().getTime());
    }
}
