package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name("Attach file")
public class AttachFilePage {

    @Name("Files")
    @Getter
    private ElementsCollection files = $$x("//div[@id='docs_choose_rows']/div[contains(@class,'docs_item')]");

    @Name("Upload")
    @Getter
    private SelenideElement upload = $x("//input[@id='choose_doc_upload']");

    public String getDockName(SelenideElement doc) {
        return doc.find(".docs_item_name").getText();
    }
}
