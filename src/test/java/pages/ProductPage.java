package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

//Class for product page
public class ProductPage {
    //Product page content element - image
    private static final SelenideElement PRODUCT_IMAGE = $("#imgp");

    //Product name
    private static final SelenideElement PRODUCT_NAME = $(".name");

    //Button: Add to cart
    private final SelenideElement addToCartButton = $(".btn.btn-success.btn-lg");

    //Navigation
    private final SelenideElement NAVIGATION_BAR = $("#navbarExample");
    private final ElementsCollection MENU_LINKS = NAVIGATION_BAR.$$("li a");

    //Link: Home
    private final SelenideElement homeLink = MENU_LINKS.findBy(text("Home"));
    //Link: Home
    private final SelenideElement cartLink = $("#cartur");

    public ProductPage verifyPageIsLoaded(){
        PRODUCT_IMAGE.shouldBe(visible);
        return this;
    }

    public ProductPage checkProductName(String productName){
        PRODUCT_NAME.shouldBe(Condition.text(productName));
        return this;
    }

    public ProductPage clickAddToCart(){
       addToCartButton.shouldBe(visible).shouldHave(text("Add to cart"));
        addToCartButton.click();
        confirm("Product added");
        return this;
    }

    //Navigation: click 'Home'
    public HomePage homeClick(){
        //System.out.println(homeLink.text());
        homeLink.click();
        return new HomePage();
    }

    public CartPage cartClick(){
        cartLink.click();
        return new CartPage();
    }
}
