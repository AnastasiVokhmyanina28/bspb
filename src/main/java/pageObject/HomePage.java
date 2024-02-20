package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private final SelenideElement events = $("//div[@class = 'sub-header event-calendar']");

    public HomePage checkTheDisplayOfTheEventBlock() {
        assertThat(events.isDisplayed()).as("Главная страница не открыта").isTrue();
        return this;
    }
}
