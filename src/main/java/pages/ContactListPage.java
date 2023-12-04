package pages;

import dto.ContactDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
//import tests.AddNewContactTests;

public class ContactListPage extends BasePage {
    public ContactListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@text='Contact list']")
    MobileElement textTitle;


    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement menuMoreOptions;
    // class android.widget.ImageView
    // accessibility id	   = More options

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement btnLogout;

    @FindBy(xpath = "//*[@class='android.widget.ImageButton']")
    MobileElement btnAddNewContact;

//    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
//    MobileElement btnAddNewContact;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputName']")
    MobileElement element;

    public boolean validateContactListOpened() {
        pause(5000);
        return isTextEqual(textTitle, "Contact list");
    }


    public AuthentificationPage logout() {
        clickBase(menuMoreOptions);
        clickBase(btnLogout);
        return new AuthentificationPage(driver);
    }

    public AddNewContactPage clickBtnAddNewContact() {
        pause(5000);
        clickBase(btnAddNewContact);
        return new AddNewContactPage(driver);
    }


    public boolean validateCurrentContactCreated(ContactDTO element, String phone) {
        pause(5000);
        LinkedList<ContactDTO> elements = new LinkedList<>();
        elements.add(element);

        Iterator<ContactDTO> iter = elements.listIterator();

        while (iter.hasNext()) {
            if ((element.getPhone()).equals(phone))
                return true;
        }
        return false;
    }
}