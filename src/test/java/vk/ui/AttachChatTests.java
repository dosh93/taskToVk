package vk.ui;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import conditions.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import labels.TestFeature;
import org.testng.annotations.*;

import static utils.CommonUtils.getCyrillicUniqueValueChar;

@Epic(TestFeature.CHAT)
@Feature(TestFeature.Chat.ATTACH_CHAT)
public class AttachChatTests extends UiTestsSetup {

    @BeforeClass
    public void start() {
        String login = prop.getProperty("vk.login");
        String password = prop.getProperty("vk.password");
        mainSteps.openMainPage();
        loginStep.login(login, password);
    }

    @BeforeMethod
    public void gotoStart() {
        mainSteps.openMainPage();
    }

    @AfterClass
    public void stop() {
        Selenide.closeWebDriver();
    }

    @Test(description = "Attach audio from library in chat")
    public void checkAttachAudioFromLibraryInChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));

        String title = messageSteps.attachAudioLibrary();

        messageSteps.sendMessage(true);
        messageSteps.getLastMessage()
                .shouldHave(Condition.haveAudio)
                .shouldHave(com.codeborne.selenide.Condition.text(title));
    }

    @Test(description = "Attach photo from library in chat")
    public void checkAttachPhotoFromLibraryInChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));

        messageSteps.attachPhotoLibrary();

        messageSteps.sendMessage(true);
        messageSteps.getLastMessage()
                .shouldHave(Condition.havePhoto);
    }

    @Test(description = "Attach file from library in chat")
    public void checkAttachFileFromLibraryInChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));

        String title = messageSteps.attachFileLibrary();

        messageSteps.sendMessage(true);
        messageSteps.getLastMessage()
                .shouldHave(Condition.haveFile)
                .shouldHave(com.codeborne.selenide.Condition.text(title));
    }

    @Test(description = "Attach file from PC in chat")
    public void checkAttachFileFromPcInChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));

        messageSteps.attachFilePc("testFile/test.pdf");
        String title = "test.pdf";

        messageSteps.sendMessage(true);
        messageSteps.getLastMessage()
                .shouldHave(Condition.haveFile)
                .shouldHave(com.codeborne.selenide.Condition.text(title));
    }

    @Test(description = "Attach photo from PC in chat")
    public void checkAttachPhotoFromPcInChatTest() {
        String name = getCyrillicUniqueValueChar(10);
        ElementsCollection allChat = mainSteps
                .goToMessage()
                .createChat(name)
                .getAllChat();

        allChat.shouldHave(CollectionCondition.sizeGreaterThan(0));

        messageSteps.attachPhotoPc("testFile/test.png");

        messageSteps.sendMessage(true);
        messageSteps.getLastMessage()
                .shouldHave(Condition.havePhoto);
    }
}
