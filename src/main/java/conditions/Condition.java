package conditions;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;

public abstract class Condition extends com.codeborne.selenide.Condition {

    public static final Condition haveAudio = new Condition("haveAudio") {
        @Nonnull
        @Override
        public CheckResult check(Driver driver, WebElement element) {
            int size = element.findElements(By.xpath(".//div[@data-audio]")).size();
            boolean hasClass = size > 0;
            return new CheckResult(hasClass, "Not have audio");
        }
    };

    public static final Condition havePhoto = new Condition("havePhoto") {
        @Nonnull
        @Override
        public CheckResult check(Driver driver, WebElement element) {
            int size = element.findElements(By.xpath(".//a[contains(@aria-label,'фотография')]")).size();
            boolean hasClass = size > 0;
            return new CheckResult(hasClass, "Not have photo");
        }
    };

    public static final Condition haveFile = new Condition("haveFile") {
        @Nonnull
        @Override
        public CheckResult check(Driver driver, WebElement element) {
            int size = element.findElements(By.xpath(".//a[contains(@href,'doc')]")).size();
            boolean hasClass = size > 0;
            return new CheckResult(hasClass, "Not have file");
        }
    };


    public Condition(String name) {
        super(name);
    }
}
