package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

//Class for Cart page
public class CartPage {
    //Products: table
    private static final SelenideElement PRODUCTS_TABLE = $(".table.table-bordered.table-hover.table-striped");

    //Table: products
    private static final ElementsCollection PRODUCTS = $("#tbodyid").$$(".success");

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


}
