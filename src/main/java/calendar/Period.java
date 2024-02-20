package calendar;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class Period {

    private Calendar calendarFrom;
    private Calendar calendarTo;

    public Period(SelenideElement container) {
        calendarFrom = new Calendar(container.$x(".//input[@name = 'from']"));
        calendarTo = new Calendar(container.$x(".//input[@name = 'until']"));
    }


}
