package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//Class for Cart page
public class CartPage {
    //Products: table
    private static final SelenideElement PRODUCTS_TABLE = $(".table.table-bordered.table-hover.table-striped");

    //Table: products
    private static final ElementsCollection PRODUCTS = $("#tbodyid").$$(".success");

    //Button: Place Order
    private final SelenideElement placeOrderButton = $(".btn.btn-success");

    //Place Order modal window
    private final SelenideElement placeOrderModal = $("#orderModal");

    //Place Order Modal: field Name
    private final SelenideElement namePlaceOrderModal = $("#name");
    //Place Order Modal: field Name
    private final SelenideElement countryPlaceOrderModal = $("#country");
    //Place Order Modal: field Name
    private final SelenideElement cityPlaceOrderModal = $("#city");
    //Place Order Modal: field Name
    private final SelenideElement cardPlaceOrderModal = $("#card");
    //Place Order Modal: field Name
    private final SelenideElement monthPlaceOrderModal = $("#month");
    //Place Order Modal: field Name
    private final SelenideElement yearPlaceOrderModal = $("#year");

    //Place Order modal: Purchase button
    private final SelenideElement purchaseButtonPlaceOrderModal = placeOrderModal.$$(".btn-primary").findBy(text("Purchase"));

    //Modal: Purchase success
    private final SelenideElement purchaseSuccessModal = $(".sweet-alert.showSweetAlert.visible");

    //Modal Purchase success: OK button
    private final SelenideElement okButtonPurchaseSuccessModal = purchaseSuccessModal.$$(".confirm.btn.btn-lg.btn-primary").findBy(text("OK"));


    //Check that table is visible
    public CartPage verifyPageIsLoaded(){
        PRODUCTS_TABLE.shouldBe(visible);
        return this;
    }

    public CartPage checkCartItems(int items){
        PRODUCTS.shouldHave(size(items));
        return this;
    }

    public CartPage checkProductName(String productName){
        //SelenideElement productRow = PRODUCTS.get(number);
        //productRow.$$("td").get(1).shouldBe(visible).shouldHave(text(productName));
        PRODUCTS.findBy(text(productName)).shouldBe(visible);
        return this;
    }

    //Push Place Order button
    public CartPage pushPlaceOrderButton(){
        placeOrderButton.should(visible).click();
        return this;
    }

    //Verify that Place Order modal window is visible
    public CartPage verifyPlaceOrderModalIsLoaded(){
        placeOrderModal.shouldBe(visible);
        return this;
    }

    //Fills Place Order modal with the provided details
    public CartPage fillPlaceOrderModal(String name, String country, String city, String card, String month, String year){
        namePlaceOrderModal.val(name);
        countryPlaceOrderModal.val(country);
        cityPlaceOrderModal.val(city);
        cardPlaceOrderModal.val(card);
        monthPlaceOrderModal.val(month);
        yearPlaceOrderModal.val(year);
        return this;
    }

    //Click button 'Purchase'
    public String purchaseButtonClick(){
        Selenide.sleep(1000);
        purchaseButtonPlaceOrderModal.click();
        purchaseSuccessModal.shouldBe(visible);
        String confirmText = purchaseSuccessModal.$("h2").getText();
        okButtonPurchaseSuccessModal.click();
        purchaseSuccessModal.shouldNotBe(visible);
        return confirmText;
    }
}
