package extensions;

import context.AuthContext;
import models.AuthResponse;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static api.AuthApiSteps.getAuthorizationToken;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {

        AuthResponse authResponse = getAuthorizationToken("testtesttest123", "Testtesttest123_!");

        AuthContext.setAuthResponse(authResponse);

        String authToken = authResponse.getToken(),
                userID = authResponse.getUserId(),
                expires = authResponse.getExpires();

        open("/favicon.ico");

        Cookie authCookie = new Cookie("token", authToken),
                userIdCookie = new Cookie("userID", userID),
                expiresCookie = new Cookie("expires", expires);


        getWebDriver().manage().addCookie(authCookie);
        getWebDriver().manage().addCookie(userIdCookie);
        getWebDriver().manage().addCookie(expiresCookie);

    }

}
