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
        new HomePage().openPage().                                  //Open Home page
                verifyPageIsLoaded()                                //The page is loaded
                .selectCategory("Laptops")              //Select category 'Laptops'
                .checkProductCard(laptopName)                       //Check that the product is available
                .productClick(laptopName)                           //Click on the product
                .verifyPageIsLoaded()                               //Verify that product page is loaded
                .checkProductName(laptopName)                       //Check the product's name
                .clickAddToCart()                                   //Click button 'Add to Cart'
                .homeClick()                                        //Click 'Home' in the navigation
                .verifyPageIsLoaded()                               //Verify that Home page is loaded
                .selectCategory("Monitors")             //Select category 'Monitors'
                .checkProductCard(monitorName)                      //Check that the product is available
                .productClick(monitorName)                          //Click on the product
                .verifyPageIsLoaded()                               //Verify that product page is loaded
                .checkProductName(monitorName)                      //Check the product's name
                .clickAddToCart()                                   //Click button 'Add to Cart'
                .homeClick()                                        //Click 'Home' in the navigation
                .verifyPageIsLoaded()                               //Verify that Home page is loaded
                .selectCategory("Phones")               //Select category 'Phones'
                .checkProductCard(phoneName)                        //Check that the product is available
                .productClick(phoneName)                            //Click on the product
                .verifyPageIsLoaded()                               //Verify that product page is loaded
                .checkProductName(phoneName)                        //Check the product's name
                .clickAddToCart()                                   //Click button 'Add to Cart'
                .cartClick()                                        //Go to Cart page
                .verifyPageIsLoaded()                               //Verify that cart page is loaded
                .checkCartItems(3)                                  //Check that all 3 products in the cart
                .checkProductName(laptopName)                       //Check Laptop product's name
                .checkProductName(monitorName)                      //Check Monitor product's name
                .checkProductName(phoneName);                       //Check Phone product's name

    }
}
