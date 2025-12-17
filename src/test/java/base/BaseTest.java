package base;

import com.codeborne.selenide.Configuration;
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
}
