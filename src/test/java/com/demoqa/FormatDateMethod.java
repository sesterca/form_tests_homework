package com.demoqa;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface FormatDateMethod {
    static String formatBDayMonth(Object object){
        SimpleDateFormat fullMonth = new SimpleDateFormat("MMMM", Locale.CANADA);
        String bDayMonth = fullMonth.format(object);
        return bDayMonth;
    }
    static String formatBDayDay(Object object){
        SimpleDateFormat fullDay = new SimpleDateFormat("d", Locale.CANADA);
        String bDayDay = fullDay.format(object);
        return bDayDay;
    }
    static String formatBDayYear(Object object){
        SimpleDateFormat fullYear = new SimpleDateFormat("yyyy", Locale.CANADA);
        String bDayYear = fullYear.format(object);
        return bDayYear;
    }
}
