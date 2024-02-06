package pageObject.autorizationPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageObject.person.Person;

import static com.codeborne.selenide.Selenide.$;

public class AutorizationPage {

    private final LoginPasswordBlock loginPasswordBlock = new LoginPasswordBlock();
    private final AccessCodeBlock accessCodeBlock = new AccessCodeBlock();
    private final SelenideElement text = $(By.id("otp-code-text")).as("Код подтверждения");


    public AccessCodeBlock autorization() {
        loginPasswordBlock.inputLogPass(Person.PERSON.getLogin(), Person.PERSON.getPassword())
                .dataVerification()
                .logIn();
        return new AccessCodeBlock();
    }

}
