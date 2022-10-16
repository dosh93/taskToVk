package pages;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$x;

@Name("Authorization page")
public class LoginPage {

    @Name("Login")
    private SelenideElement login = $x("//input[@name='login']");
    @Name("Password")
    private SelenideElement password = $x("//input[@name='password']");
    @Name("Submit")
    private SelenideElement submit = $x("//button[@type='submit']");

    public LoginPage loginEnter(String loginStr) {
        login.sendKeys(loginStr);
        return this;
    }

    public LoginPage passwordEnter(String passwordStr) {
        password.sendKeys(passwordStr);
        return this;
    }

    public LoginPage clickSubmit() {
        submit.click();
        return this;
    }
}
