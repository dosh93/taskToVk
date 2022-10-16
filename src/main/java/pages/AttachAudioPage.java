package pages;

import com.codeborne.selenide.ElementsCollection;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$$x;


@Name("Attach audio")
public class AttachAudioPage {

    @Name("Attach buttons")
    private ElementsCollection attachButtons = $$x("//div[@class='ape_attach']");

    @Name("Titles")
    private ElementsCollection titles = $$x("//div[contains(@class,'box_layout')]//div[@class='audio_row__performer_title']");

    public ElementsCollection getAttachButtons() {
        return attachButtons;
    }

    public ElementsCollection getTitles() {
        return titles;
    }
}
