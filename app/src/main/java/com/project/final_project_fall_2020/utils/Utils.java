package com.project.final_project_fall_2020.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static long extractId(long id) {
        try {
            String iString = id + "";
            int len = iString.length();
            String lastNumber = iString.substring(0, 8);
            long result = Long.parseLong(lastNumber);
            return result;
        } catch (NumberFormatException e) {

        } catch (Exception e) {

        }
        return -1;
    }

    private long generateOrderId(long count) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        String stringVal = year + month + day + count + "";
        long id = Long.parseLong(stringVal);
        return id;
    }
}
