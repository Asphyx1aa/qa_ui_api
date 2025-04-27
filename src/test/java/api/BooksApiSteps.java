package api;

import io.qameta.allure.Step;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static specs.BaseSpec.baseResponseSpec;
import static specs.BaseSpec.baseSpec;

public class BooksApiSteps extends TestBase {

    @Step("Удаляем все книги пользователя через API")
    public void deleteAllBooksFromUser(String token, String userId) {
        given()
                .spec(baseSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/BookStore/v1/Books?UserId=" + userId)
                .then()
                .spec(baseResponseSpec(204));
    }


    @Step("Добавляем книгу в профиль через API")
    public void addBooksToProfile(String token, String userId) {
        String authBody = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781593275846\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        given()
                .spec(baseSpec)
                .header("Authorization", "Bearer " + token)
                .body(authBody)
                .when()
                .post("/BookStore/v1/Books/")
                .then()
                .spec(baseResponseSpec(201));
    }

    @Step("Проверяем, что список книг пустой после удаления")
    public void responseOfBooksListShouldBeEmpty(String token, String userId) {

        given()
                .spec(baseSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/Account/v1/User/" + userId)
                .then()
                .body("books", empty())
                .spec(baseResponseSpec(200));
    }
}
