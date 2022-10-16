package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Login by login = {login}; password = {password}")
    public void login(String login, String password) {
        loginPage
                .loginEnter(login)
                .clickSubmit()
                .passwordEnter(password)
                .clickSubmit();
    }
}
