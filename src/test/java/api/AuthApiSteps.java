package api;

import io.qameta.allure.Step;
import models.AuthRequest;
import models.AuthResponse;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static specs.AuthSpec.auth;
import static specs.BaseSpec.baseResponseSpec;

public class AuthApiSteps extends TestBase {

    @Step("Авторизуемся в аккаунт пользователя через API")
    public static AuthResponse getAuthorizationToken(String userName, String password) {

        AuthRequest authBody = new AuthRequest(userName, password);

        return given()
                .spec(auth)
                .body(authBody)
                .when()
                .post("/Account/v1/Login")
                .then()
                .body("token", notNullValue())
                .spec(baseResponseSpec(200))
                .extract()
                .as(AuthResponse.class);
    }
}
