package vk.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import steps.LoginSteps;
import steps.MainSteps;
import steps.MessageSteps;
import utils.PropertiesUtil;

public class UiTestsSetup {

    protected static LoginSteps loginStep;
    protected static MainSteps mainSteps;
    protected static MessageSteps messageSteps;
    protected static PropertiesUtil prop;

    @BeforeSuite
    static void setupAllureReports() {
        loginStep = new LoginSteps();
        mainSteps = new MainSteps();
        messageSteps = new MessageSteps();
        prop = new PropertiesUtil();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }
}
