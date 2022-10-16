package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Name("Attach photo")
public class AttachPhotoPage {

    @Name("Photos")
    @Getter
    private ElementsCollection photos = $$x("//div[contains(@class,'photos_choose_row_bg')]");

    @Name("Upload")
    @Getter
    private SelenideElement upload = $x("//input[contains(@id,'photos_upload_input')]");

}
