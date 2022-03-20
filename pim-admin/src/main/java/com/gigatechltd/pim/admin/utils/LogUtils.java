package com.gigatechltd.pim.admin.utils;

import com.google.gson.Gson;

public class LogUtils {

    public static void print(Object object) {
        Gson gson = new Gson();
        System.out.println("\n*** Log Started ***\n");
        System.out.println(gson.toJson(object));
        System.out.println("\n*** Log Ended ***\n");
    }
}
