package pageObject;

import calendar.Period;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoryOfOperationsInTheSystemPage {

    private final SelenideElement beginningOfPeriod = $(By.id("from-date"));
    private final SelenideElement endOfPeriod = $(By.id("until-date"));
    private final Period period = new Period($x("//div[@id='payment-history-filter']"));


    public HistoryOfOperationsInTheSystemPage checkPageActivityHistory() {
        assertThat(beginningOfPeriod.isDisplayed()).as("История операций в системе не открыта").isTrue();
        return this;
    }

    public HistoryOfOperationsInTheSystemPage selectBeginningOfPeriod() {
        return period.getCalendarFrom().history();
    }
}
