package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HomePage;

//Test to shop 3 items from different categories
public class ShopTest {
    @BeforeAll
    static void setUp(){
        //Set default browser
        Configuration.browser = "chrome";

        //Increase the default timeout for elements waiting (10 seconds)
        Configuration.timeout = 10000;

        //Maximize the browser window for reliable element visibility
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shopThreeItemsFromDifferentCategories(){
        //Laptop name
        String laptopName = "Sony vaio i5";
        String monitorName = "Apple monitor 24";
        String phoneName = "Nexus 6";
        new HomePage().openPage().
                verifyPageIsLoaded()
                .selectCategory("Laptops")
                .checkProductCard(laptopName)
                .productClick(laptopName)
                .verifyPageIsLoaded()
                .checkProductName(laptopName)
                .clickAddToCart()
                .homeClick()
                .verifyPageIsLoaded()
                .selectCategory("Monitors")
                .checkProductCard(monitorName)
                .productClick(monitorName)
                .verifyPageIsLoaded()
                .checkProductName(monitorName)
                .clickAddToCart()
                .homeClick()
                .verifyPageIsLoaded()
                .selectCategory("Phones")
                .checkProductCard(phoneName)
                .productClick(phoneName)
                .verifyPageIsLoaded()
                .checkProductName(phoneName)
                .clickAddToCart()
                .cartClick()
                .verifyPageIsLoaded()
                .checkCartItems(3)
                .checkProductName(laptopName)
                .checkProductName(monitorName)
                .checkProductName(phoneName);

    }
}
