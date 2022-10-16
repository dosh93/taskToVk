package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.AttachType;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name("Messages")
public class MessagePage extends MainPage {

    @Name("Create chat")
    private SelenideElement createChat = $x("//button[contains(@class,'_im_create_convo')]");

    @Name("Filed name chat")
    private SelenideElement nameChat = $x("//input[@id='im_dialogs_creation_name']");

    @Name("Confirm create chat")
    private SelenideElement confirmCreateChat = $x("//button[contains(@class,'_im_confirm_creation')]");

    @Name("List chat")
    private ElementsCollection chatList = $$x("//li[contains(@class,'nim-dialog_unread-out')]");

    @Name("Attach more")
    private SelenideElement attachMore = $x("//a[@class='ms_item_more']");

    @Name("Send message")
    private SelenideElement sendMessage = $x("//button[contains(@class,'im-send-btn_send')]");

    @Name("Messages")
    private ElementsCollection messages = $$x("//div[contains(@class,'_im_mess_stack')]");

    public MessagePage createChatClick() {
        createChat.click();
        return this;
    }

    public MessagePage setNameChat(String nameChatStr) {
        nameChat.sendKeys(nameChatStr);
        return this;
    }

    public MessagePage confirmCreateChatClick() {
        confirmCreateChat.click();
        return this;
    }

    public MessagePage hoverAttachMore() {
        attachMore.hover();
        return this;
    }

    public void attachClick(AttachType type) {
        $x(String.format("//a[contains(@class,'%s')]", type.getNameClass())).click();
    }

    public ElementsCollection getAllChat() {
        return chatList;
    }

    public MessagePage sendMessageClick() {
        sendMessage.click();
        return this;
    }

    public ElementsCollection getMessages() {
        return messages;
    }

}
