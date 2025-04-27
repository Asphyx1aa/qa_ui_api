package helpers;

import com.codeborne.selenide.Configuration;

public class JenkinsProperties {
    public static String getServer() {
        String username = System.getProperty("login", null);
        String password = System.getProperty("password", null);
        String wdhost = System.getProperty("wdhost", null);

        return "https://" + username + ":" + password + "@" + wdhost;
    }

    public static String getBrowserSize() {
        return System.getProperty("browser_size", "1920x1080");
    }

    public static String getBaseURL() {
        return System.getProperty("browser_size", "https://demoqa.com");
    }
}
