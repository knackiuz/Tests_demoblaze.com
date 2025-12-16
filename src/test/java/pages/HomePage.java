package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

//Represents the Home Page of Demo Blaze application
public class HomePage {
    //The base url of the website
    private static final String BASE_URL = "https://www.demoblaze.com/";

    //Element: carousel
    private final SelenideElement CAROUSEL = $("#carouselExampleIndicators");

    //Navigation menu
    //Selector for link of Home
    private final SelenideElement NAVIGATION_BAR = $("#navbarExample");
    //Collection of the links
    private final ElementsCollection MENU_LINKS = NAVIGATION_BAR.$$("li a");
    //Navigation link: Home
    //private final SelenideElement homeLink = $("#navbarExample").$$("li a").findBy(text("Home"));
    private final SelenideElement homeLink = MENU_LINKS.findBy(text("Home"));
    //Navigation link: Contact
    private final SelenideElement homeContact = MENU_LINKS.findBy(text("Contact"));

    //Menu: CATEGORIES
    private final SelenideElement categoryLinkByText(String categoryName){
        return $x("//a[text()='" + categoryName + "']");
    }

    //List of products displayed in the main content area
    private final ElementsCollection productCards = $("#tbodyid").$$(".card");

    //Open Home Page by URL
    public HomePage openPage(){
        open(BASE_URL);
        return this;
    }

    //Navigation: click 'Home'
    public HomePage homeClick(){
        //System.out.println(homeLink.text());
        homeLink.click();
        return new HomePage();
    }

    //Ensure that Page is Loaded
    public HomePage verifyPageIsLoaded(){
        CAROUSEL.shouldBe(visible);
        return this;
    }

    //Navigation: click 'Contact'
    public ContactModal contactClick(){
        homeContact.click();
        return new ContactModal();
    }

    //CATEGORIES: click on category by provided name
    public HomePage selectCategory(String categoryName){
        categoryLinkByText(categoryName).click();
        return this;
    }

    //CATEGORIES: check that correct product is displayed
    public HomePage checkProductCard(String productCardName){
        productCards.findBy(text(productCardName)).shouldBe(visible).$("a").shouldBe(visible, clickable);
        return this;
    }

    //CATEGORIES: click on product link by provided item's name
    public ProductPage productClick(String productName){
        productCards.findBy(text(productName)).$("a").click();
        return new ProductPage();
    }
}
