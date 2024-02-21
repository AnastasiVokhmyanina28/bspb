package calendar;

import com.codeborne.selenide.SelenideElement;
import pageObject.HistoryOfOperationsInTheSystemPage;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;

public class Calendar {

    private static SelenideElement container = $x("//div[contains(@style,' display: block;')]");
    public final SelenideElement openTheListYear = container.$x(".//div[@class='datepicker-months']//th[@class='switch']").as("кнопка, при нажатии на которую видны года");
    private SelenideElement openTheListOfMonths = container.$x(".//div[@class='datepicker-days']//th[@class='switch']");
    private SelenideElement textInput;

    public Calendar(SelenideElement textInput) {
        this.textInput = textInput;
    }

    private SelenideElement getButtonElement(Integer year) {
        return container.$x(".//span[ contains(text()," + year + ")]");
    }

    /**
     * Выбрать год
     */
    private void chooseAYear(Integer year) {
        if (year == Integer.parseInt(openTheListYear.getText())) {
        } else {
            openTheListYear.click();
            getButtonElement(year).click();
        }
    }

    private SelenideElement chooseAMonth(java.time.Month month) {
        return container.$x(".//span[contains(text(), '" + Month.valueOf(month.toString()).getMonth() + "')]");
    }

    private SelenideElement chooseADay(Integer day) {
        return container.$x(".//div[@class='datepicker-days']//td[contains(text()," + day + ")]");
    }

    /**
     * начало периода
     */
    public HistoryOfOperationsInTheSystemPage history(LocalDate date) {

        /**Открыть календарь*/
        textInput.click();
        openTheListOfMonths.click();

        /**выбор года*/
        chooseAYear(date.getYear());

        /**выбор месяц*/
        chooseAMonth(date.getMonth()).click();

        /**выбор дня месяца*/
        chooseADay(date.getDayOfMonth()).click();

        return new HistoryOfOperationsInTheSystemPage();
    }
}
