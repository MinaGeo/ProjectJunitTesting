package com.Banking;

public class GlobalData {
    private static String userID;

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        GlobalData.userID = userID;
    }
}
