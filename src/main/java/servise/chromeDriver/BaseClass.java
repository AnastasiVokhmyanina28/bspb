package servise.chromeDriver;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pageObject.autorizationPage.AutorizationPage;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseClass {
    private static String baseUrl;


    static {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/connectionData.properties");
            properties.load(fileInputStream);
            baseUrl = properties.getProperty("baseUrl");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp() {
        Configuration.browser = CustomChromeDriver.class.getCanonicalName();
        Configuration.pageLoadTimeout = 100_000L;
        open(baseUrl);
    }

//    @BeforeEach
//    public static void openUrl() {
//        open(baseUrl);


    @AfterAll
    public static void close() {
        closeWebDriver();
    }

    public AutorizationPage openLoginPage() {
        return new AutorizationPage();
    }

}
