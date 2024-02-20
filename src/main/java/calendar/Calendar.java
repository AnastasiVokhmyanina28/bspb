package calendar;

import com.codeborne.selenide.SelenideElement;
import data.DateCalculation;
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

    /** метод, который вернет элемент  новой даты. а именно год. .. после подставим в метод*/

    private SelenideElement getButtonElement(Integer year){
        return container.$x(".//span[ contains(text()," + year + ")]");
    }



    public HistoryOfOperationsInTheSystemPage history() {
        /** Получаем дату*/
        DateCalculation calculation = new DateCalculation();
        LocalDate foundDate = calculation.calculateTheDate(100);

        /**Открыть календарь*/
        textInput.click();
        openTheListOfMonths.click();

        if (foundDate.getYear() == Integer.parseInt(openTheListYear.getText())) {
        } else {
            openTheListYear.click();
            getButtonElement(foundDate.getYear()).click();
        }



        return new HistoryOfOperationsInTheSystemPage();
    }
}
