package pages;

import dto.ContactDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
        clickBase(btnAddNewContact);
        return new AddNewContactPage(driver);
    }


    public boolean validateCurrentContactCreated(int i) {
        List<ContactDTO> elements = new List<ContactDTO>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ContactDTO> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ContactDTO contactDTO) {
                return false;
            }


            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ContactDTO> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends ContactDTO> c) {
                return false;
            }


            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ContactDTO get(int index) {
                return null;
            }


            @Override
            public ContactDTO set(int index, ContactDTO element) {
                return null;
            }

            @Override
            public void add(int index, ContactDTO element) {

            }

            @Override
            public ContactDTO remove(int index) {
                return null;
            }


            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ContactDTO> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ContactDTO> listIterator(int index) {
                return null;
            }

            @Override
            public List<ContactDTO> subList(int fromIndex, int toIndex) {
                return null;
            }

        };
        Iterator<ContactDTO> iter = elements.listIterator();


        while (iter.hasNext()) {
            if ((iter.next()).getPhone().equals(i))
                return true;
        }
        return false;
    }
}