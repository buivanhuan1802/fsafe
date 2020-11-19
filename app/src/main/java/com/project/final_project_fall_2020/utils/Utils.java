package com.project.final_project_fall_2020.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.project.final_project_fall_2020.model.User;

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

    public static String getSystemDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }

    public static User getLoginedUser(Context context) {
        try {
            SharedPreferences sf = context.getSharedPreferences(CommonConstant.PREFERENCE_LOGINED, Context.MODE_PRIVATE);
            String data = sf.getString(CommonConstant.PREFERENCE_LOGINED, "");
            Gson gson = new Gson();
            User logined = gson.fromJson(data, User.class);
            return logined;
        } catch (Exception e) {
            return null;
        }
    }

    public static void saveUserToPref(SharedPreferences pref, User data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(CommonConstant.PREFERENCE_LOGINED, json);
        editor.commit();

    }
}
