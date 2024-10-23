package com.mycompany.mamakhali;

public class Session {
    public static String username;
    public static String password;

    // Set the username
    public static void setUsername(String username) {
        Session.username = username;
    }

    // Get the username
    public static String getUsername() {
        return username;
    }

    // Set the password (if needed)
    public static void setPassword(String password) {
        Session.password = password;
    }

    // Get the password (if needed)
    public static String getPassword() {
        return password;
    }
}
