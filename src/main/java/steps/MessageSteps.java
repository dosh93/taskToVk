package steps;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.AttachType;
import io.qameta.allure.Step;

import pages.AttachAudioPage;
import pages.AttachFilePage;
import pages.AttachPhotoPage;
import pages.MessagePage;

public class MessageSteps {

    private MessagePage messagePage;
    private AttachAudioPage attachAudioPage;
    private AttachPhotoPage attachPhotoPage;
    private AttachFilePage attachFilePage;

    public MessageSteps() {
        messagePage = new MessagePage();
        attachAudioPage = new AttachAudioPage();
        attachPhotoPage = new AttachPhotoPage();
        attachFilePage = new AttachFilePage();
    }

    @Step("Create chat by name is {name}")
    public MessageSteps createChat(String name) {
        messagePage.createChatClick()
                .setNameChat(name)
                .confirmCreateChatClick();
        return this;
    }


    @Step("Open messages")
    public MessageSteps open() {
        messagePage.clickMessages();
        return this;
    }

    @Step("Get all chat")
    public ElementsCollection getAllChat() {
        return messagePage.getAllChat();
    }

    @Step("Attach audio library")
    public String attachAudioLibrary() {
        messagePage.hoverAttachMore().attachClick(AttachType.AUDIO);
        String title = attachAudioPage.getTitles().shouldBe(CollectionCondition.sizeGreaterThan(0)).get(0).getText();
        attachAudioPage.getAttachButtons().shouldBe(CollectionCondition.sizeGreaterThan(0)).get(0).click();
        return title;
    }

    @Step("Attach photo library")
    public void attachPhotoLibrary() {
        messagePage.hoverAttachMore().attachClick(AttachType.PHOTO);

        attachPhotoPage.getPhotos().shouldBe(CollectionCondition.sizeGreaterThan(0)).get(0).click();
    }

    @Step("Attach file library")
    public String attachFileLibrary() {
        messagePage.hoverAttachMore().attachClick(AttachType.FILE);
        SelenideElement doc = attachFilePage.getFiles().shouldBe(CollectionCondition.sizeGreaterThan(0)).get(0);
        String title = attachFilePage.getDockName(doc);
        doc.click();
        return title;
    }

    @Step("Send message")
    public void sendMessage(boolean waitSend) {
        int size = 0;
        if (waitSend) size = messagePage.getMessages().size();

        messagePage.sendMessageClick();

        if (waitSend) messagePage.getMessages().shouldBe(CollectionCondition.size(size + 1));
    }

    @Step("Get last message")
    public SelenideElement getLastMessage() {
        return messagePage.getMessages().last();
    }

    @Step("Attach file PC")
    public void attachFilePc(String file) {
        messagePage.hoverAttachMore().attachClick(AttachType.FILE);
        attachFilePage.getUpload().uploadFromClasspath(file);
    }

    @Step("Attach photo PC")
    public void attachPhotoPc(String file) {
        messagePage.hoverAttachMore().attachClick(AttachType.PHOTO);
        attachPhotoPage.getUpload().uploadFromClasspath(file);
    }
}
