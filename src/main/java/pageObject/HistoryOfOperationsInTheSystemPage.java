package pageObject;

import calendar.Period;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoryOfOperationsInTheSystemPage {

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final Period period = new Period($x("//div[@id='payment-history-filter']"));
    private final SelenideElement downloadButton = $("#apply-payments-filter").as("Кнопка загрузить");
    private final ElementsCollection dates = $$x("//tr[contains(@class, 'transaction-row ')]/td[1]");

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

    /**
     * забрать из коллекции даты, преобразовать и записать в список
     */
    private List<LocalDate> getDates() {
        List<LocalDate> list = new ArrayList();

        for (SelenideElement selenideElement : dates) {
            list.add(LocalDate.parse(selenideElement.getText(), timeFormatter));
        }
        return list;
    }

    public HistoryOfOperationsInTheSystemPage checkDates(LocalDate dateStart, LocalDate dateEnd) {

        for (int i = 0; i < getDates().size(); i++) {
            assertThat(getDates().get(i).isAfter(dateStart.minusDays(1))
                    && getDates().get(i).isBefore(dateEnd.plusDays(1)))
                    .as("дата не входит в период").isTrue();
        }
        return this;

    }


}
