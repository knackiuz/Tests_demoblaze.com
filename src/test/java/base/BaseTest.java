package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

//Base class for all tests
public class BaseTest {
    @BeforeAll
    static void setUp(){
        //Set default browser
        Configuration.browser = "chrome";

        //Increase the default timeout for elements waiting (10 seconds)
        Configuration.timeout = 10000;

        //Maximize the browser window for reliable element visibility
        Configuration.browserSize = "1920x1080";

        //Set to true to prevent the browser from closing after execution
        Configuration.holdBrowserOpen = false;
    }

    @BeforeAll
    static void setupAllureReports() {
        // This listener attaches screenshots and steps to the Allure report
        // Adding English comments as per your instructions
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)      // Save screenshots automatically on failure
                .savePageSource(false)  // Do not save heavy HTML source to keep report light
        );
    }
}
