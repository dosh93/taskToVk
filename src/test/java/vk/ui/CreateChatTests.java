package vk.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import labels.TestFeature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

import static utils.CommonUtils.getCyrillicUniqueValueChar;

@Epic(TestFeature.CHAT)
@Feature(TestFeature.Chat.CREATE_CHAT)
public class CreateChatTests extends UiTestsSetup {

    @BeforeMethod
    public void start() {
        String login = prop.getProperty("vk.login");
        String password = prop.getProperty("vk.password");
        mainSteps.openMainPage();
        loginStep.login(login, password);
    }

    @AfterMethod
    public void stop() {
        Selenide.closeWebDriver();
    }

    @Test(description = "Check create chat", retryAnalyzer = Retry.class)
    public void checkCreateChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));
        allChat.get(0).shouldHave(Condition.text(name));
    }

}
