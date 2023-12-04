package pages;

import dto.ContactDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactPage extends BasePage{
    public AddNewContactPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement inputName;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputLastName']")
    MobileElement inputLastName;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement inputEmail;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPhone']")
    MobileElement inputPhone;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputAddress']")
    MobileElement inputAddress;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputDesc']")
    MobileElement inputDescription;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/createBtn']")
    MobileElement createBtn;

    @FindBy(xpath = "//*[@resource-id='android:id/alertTitle']")
    MobileElement textAlertError;

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement btnOkAlertError;

    public AddNewContactPage sendTextInputName(String name){
        typeTextBase(inputName, name);
        return this;
    }
    public AddNewContactPage sendTextInputLastName(String lastName){
        typeTextBase(inputLastName, lastName);
        return this;
    }
    public AddNewContactPage sendTextInputEmail(String email){
typeTextBase(inputEmail, email);
return this;
    }

    public AddNewContactPage sendTextInputPhone(String phone){
        typeTextBase(inputPhone, phone);
        return this;
    }

    public AddNewContactPage sendTextInputAddress(String address){
        typeTextBase(inputAddress, address);
        return this;
    }

    public AddNewContactPage sendTextInputDescription(String description){
        typeTextBase(inputDescription, description);
        return this;
    }

    public ContactListPage clickBtnAddNewContact(){
        clickBase(createBtn);
        return new ContactListPage(driver);
    }

    public AddNewContactPage clickBtnAddNewContactNegative() {
        clickBase(createBtn);
        return this;
    }

    public ContactListPage addNewContact(ContactDTO contact){
        pause(5000);
        return sendTextInputName(contact.getName())
                .sendTextInputLastName(contact.getLastName())
                .sendTextInputEmail(contact.getEmail())
                .sendTextInputPhone(contact.getPhone())
                .sendTextInputAddress(contact.getAddress())
                .sendTextInputDescription(contact.getDescription())
                .clickBtnAddNewContact();
    }

    public AddNewContactPage addNewContactNegative(ContactDTO contact) {
        return  sendTextInputName(contact.getName())
                .sendTextInputLastName(contact.getLastName())
                .sendTextInputEmail(contact.getEmail())
                .sendTextInputPhone(contact.getPhone())
                .sendTextInputAddress(contact.getAddress())
                .sendTextInputDescription(contact.getDescription())
                .clickBtnAddNewContactNegative();
    }

    public boolean validateErrorMessage() {
        return isTextEqual(textAlertError, "Error");
    }

    public AddNewContactPage clickOkCloseAlert() {
        clickBase(btnOkAlertError);
        return this;
    }
}
