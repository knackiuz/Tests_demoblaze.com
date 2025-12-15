package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

//Class for modal window: Contact
public class ContactModal {
    //Modal window container
    public final SelenideElement modalWindow = $("#exampleModal");

    public final SelenideElement title = $("#exampleModalLabel");

    //Input fields
    //Contact Email
    private final SelenideElement emailField = $("#recipient-email");
    //Contact Name
    private final SelenideElement nameField = $("#recipient-name");
    //Message
    private final SelenideElement messageField = $("#message-text");

    //Buttons
    //Close
    //private final SelenideElement closeButton = modalWindow.$$("[data-dismiss='modal']").findBy(text("Close"));
    private final SelenideElement closeButton = modalWindow.$(".modal-footer .btn-secondary");
    //Send message
    private final SelenideElement sendMessageButton = modalWindow.$$(".btn-primary").findBy(text("Send message"));

    //Ensure that modal window 'Contact' is visible
    public ContactModal shouldBeVisible(){
        modalWindow.shouldBe(visible);
        title.shouldHave(text("New message"));
        return this;
    }

    //Fills the contact form with the provided details
    public ContactModal fillForm(String contactEmail, String contactName, String message){
        emailField.val(contactEmail);
        nameField.val(contactName);
        messageField.val(message);
        return this;
    }

    //Click button 'Close'
    public void clickClose(){
        //closeButton.click();
        executeJavaScript(
                "var modal = $('#exampleModal');" +
                        "modal.removeClass('show fade');" +
                        "modal.css({'display': 'none', 'opacity': '0'});"
        );
        modalWindow.shouldNotBe(visible);
    }

    //Click button 'Send message'
    public String sendMessage(){
        sendMessageButton.click();
        String alertText = switchTo().alert().getText();
        switchTo().alert().accept();
        modalWindow.shouldNotBe(visible);
        return alertText;
    }
}
