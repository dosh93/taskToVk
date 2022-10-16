package steps;

import io.qameta.allure.Step;
import utils.PropertiesUtil;

import static com.codeborne.selenide.Selenide.open;

public class MainSteps {

    private MessageSteps messageSteps;
    private PropertiesUtil prop;

    public MainSteps() {
        messageSteps = new MessageSteps();
        prop = new PropertiesUtil();
    }

    @Step("Go to message page")
    public MessageSteps goToMessage() {
        return messageSteps.open();
    }

    @Step("Open main page")
    public MainSteps openMainPage() {
        open(prop.getProperty("vk.baseUrl"));
        return this;
    }
}
