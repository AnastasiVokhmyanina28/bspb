package pageObject.toolBar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface Navbar {

    SelenideElement overviewPrivate = $(By.id("overviewPrivate")).as("Вкладка 'Главная'");
    SelenideElement accounts = $(By.id("accounts")).as("Вкладка 'Счета'");
    SelenideElement payments = $(By.id("payments")).as("Вкладка 'Платежи'");
    SelenideElement cards = $(By.id("cards")).as("Вкладка 'Карты'");
    SelenideElement deposits = $(By.id("deposits")).as("Вкладка 'Вклады '");
    SelenideElement loans = $(By.id("loans")).as("Вкладка 'Кредиты'");
    SelenideElement externalTradeRoom = $(By.id("externalTraderoom")).as("Вкладка 'Валюта'");
    SelenideElement insurance = $(By.id("insurance")).as("Вкладка 'Страхование'");


}
