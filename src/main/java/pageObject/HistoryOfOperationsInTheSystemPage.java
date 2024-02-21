package pageObject;

import calendar.Period;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoryOfOperationsInTheSystemPage {

    private final Period period = new Period($x("//div[@id='payment-history-filter']"));
    private final SelenideElement downloadButton = $("#apply-payments-filter").as("Кнопка загрузить");

    public HistoryOfOperationsInTheSystemPage checkPageActivityHistory() {
        assertThat(downloadButton.isDisplayed()).as("История операций в системе не открыта").isTrue();
        return this;
    }

    /**
     * выбрать дату начала периода
     */
    public HistoryOfOperationsInTheSystemPage selectBeginningOfPeriod(LocalDate date) {
        return period.getCalendarFrom().history(date);
    }

    /**
     * выбрать конец периода
     */
    public HistoryOfOperationsInTheSystemPage selectEndOfPeriod(LocalDate date) {
        return period.getCalendarTo().history(date);
    }

    public HistoryOfOperationsInTheSystemPage downloadButtonClick() {
        downloadButton.click();
        return this;
    }

}
