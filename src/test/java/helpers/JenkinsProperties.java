package helpers;


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

    public static String getUserName() {
        return System.getProperty("userName", "testtesttest123");
    }

    public static String getUserPassword() {
        return System.getProperty("userPassword", "Testtesttest123_!");
    }

    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    public static String getBaseURL() {
        return System.getProperty("base_url", "https://demoqa.com");
    }
}
