package tests;

import base.BaseTest;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Test checks the links of the menu and pages content
public class MenuTest extends BaseTest {
    //Test: check navigation link Home
    @Test
    void checkNavigationMenuHome(){
        new HomePage().openPage()           //Open home page
                .homeClick()                //Click on Home in navigation bar
                .verifyPageIsLoaded();      //Home page should be loaded
    }

    //Test: check navigation link 'Contact', using fields and send message button
    @Test
    void checkNavigationMenuContactSendMessage(){
        String actualAlertMessage = new HomePage().openPage()
                .verifyPageIsLoaded()
                .contactClick()
                .shouldBeVisible().fillForm("test@mail.com", "Test User", "This is a test!")
                .sendMessage();

        String expectedAlertMessage = "Thanks for the message!!";
        assertEquals(expectedAlertMessage, actualAlertMessage, "Alert message should be: " + expectedAlertMessage);
    }

    //Test: check navigation link 'Contact', using button 'Close'
    @Test
    void checkNavigationMenuContactClose(){
        new HomePage().openPage()
                .verifyPageIsLoaded()
                .contactClick().shouldBeVisible().clickClose();
    }
}
