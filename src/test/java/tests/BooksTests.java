package tests;

import annotations.WithLogin;
import api.BooksApiSteps;
import context.AuthContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.UserProfilePage;

public class BooksTests extends TestBase {

    final UserProfilePage userProfilePage = new UserProfilePage();
    final BooksApiSteps bookApi = new BooksApiSteps();

    @Test
    @DisplayName("Удаление книги из профиля пользователя")
    @WithLogin
    void DeleteBookFromUserProfileTest() {
        String token = AuthContext.getAuthResponse().getToken();
        String userId = AuthContext.getAuthResponse().getUserId();

        bookApi.deleteAllBooksFromUser(token, userId);
        bookApi.addBooksToProfile(token, userId);

        userProfilePage.openPage()
                .checkThatAuthWasSuccessful("testtesttest123")
                .deleteBookFromUserProfile()
                .assertThatBookWasDeletedFromList();

        bookApi.responseOfBooksListShouldBeEmpty(token, userId);
    }
}
