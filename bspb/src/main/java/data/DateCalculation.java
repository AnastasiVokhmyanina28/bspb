package data;

import java.time.LocalDate;

public class DateCalculation {

    public LocalDate calculateTheDate(Integer numberOfDays) {
        LocalDate date = LocalDate.now();

        return date.minusDays(numberOfDays);
    }
}
