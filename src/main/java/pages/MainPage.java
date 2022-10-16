package pages;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    @Name("Messages")
    private SelenideElement messages = $x("//li[@id='l_msg']");

    public void clickMessages() {
        messages.click();
    }

}
