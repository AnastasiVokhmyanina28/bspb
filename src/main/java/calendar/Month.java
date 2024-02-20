package calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Month {

    JANUARY("Янв"),
    FEBRUARY("Фев"),
    MARCH("Мар"),
    APRIL("Апр"),
    MAY("Май"),
    JUNE("Июн"),
    JULY("Июл"),
    AUGUST("Авг"),
    SEPTEMBER("Сен"),
    OCTOBER("Окт"),
    NOVEMBER("Ноя"),
    DECEMBER("Дек");

    private String month;
}
