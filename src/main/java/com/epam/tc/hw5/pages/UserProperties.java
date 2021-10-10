package com.epam.tc.hw5.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class UserProperties {
    private static final String USER_PROPERTY = "src/test/resources/user.properties";
    protected String username;
    protected String userpassword;
    protected String expectedUsername;

    public static String getUserData(String property) {
        Properties userProperties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(USER_PROPERTY)) {
            userProperties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userProperties.getProperty(property);
    }

    public static String getUsername() {
        return getUserData("UserName");
    }

    public static String getPassword() {
        return getUserData("UserPassword");
    }

    public static String getExpectedUsername() {
        return getUserData("ExpectedUserName");
    }

}
