package data;

import java.time.LocalDate;

public class DateCalculation {

    public static LocalDate calculateTheDate(Integer numberOfDays) {
        LocalDate date = LocalDate.now();
        return date.minusDays(numberOfDays);
    }

}
