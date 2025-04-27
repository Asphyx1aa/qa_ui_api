package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class UserProfilePage {
    final SelenideElement userProfileName = $("#userName-value");
    final SelenideElement deleteBookButton = $("span[title='Delete']");
    final SelenideElement submitDeleteButton = $("#closeSmallModal-ok");
    final SelenideElement bookTable = $(".rt-table");

    @Step("Открываем страницу")
    public UserProfilePage openPage() {
        open("/profile");
        return this;
    }

    @Step("Проверяем, что авторизация прошла успешно")
    public UserProfilePage checkThatAuthWasSuccessful(String userName) {
        userProfileName.shouldHave(text(userName));
        return this;
    }

    @Step("Удаляем книгу из профиля")
    public UserProfilePage deleteBookFromUserProfile() {
        deleteBookButton.click();
        submitDeleteButton.shouldBe(visible).click();
        switchTo().alert().accept();
        return this;
    }

    @Step("Проверяем, что книга была удалена из списка")
    public UserProfilePage assertThatBookWasDeletedFromList() {
        bookTable.shouldNotHave(text("Eloquent JavaScript"));
        return this;
    }
}
