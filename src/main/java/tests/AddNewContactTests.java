package tests;

import config.AppiumConfig;
import dto.ContactDTO;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AddNewContactPage;
import pages.ContactListPage;
import pages.SplashPage;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {
    boolean flagToCloseAlert = false;
    @BeforeClass
    public void beforeClass() {
        new SplashPage(driver).goToAuthPage()
                .login(UserDTO.builder()
                        .email("qwerty@qwer.ty")
                        .password("Qwerty!1")
                        .build());
    }
@AfterMethod
public void afterPause(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

@AfterClass
    public void afterClass(){
    new ContactListPage(driver).logout();
}

@AfterMethod
        public void afterMethod(){
    if(flagToCloseAlert) {
        flagToCloseAlert = false;
        new AddNewContactPage(driver).clickOkCloseAlert().backBtnOnEmulator();
    }
}



@Test
    public void positiveAddNewContact(){
    int i;
    i = new Random().nextInt(1000)+1000;
String phone = "1234567" + i;
Assert.assertTrue(new ContactListPage(driver).clickBtnAddNewContact()
        .addNewContact(ContactDTO.builder()
                .name("testQA20" + i)
                .lastName("ln" + i)
                .email("test" + i + "@gmail.com")
                .phone("1234567" + i)
                .address("Haifa")
                .description("contact: " + i)
                .build())
        .validateCurrentContactCreated(ContactDTO.builder().build(), phone));
}

@Test
    public void negativeTestEmptyPhone(){
    int i;
    i = new Random().nextInt(1000)+1000;
    flagToCloseAlert = true;
    Assert.assertTrue(new ContactListPage(driver).clickBtnAddNewContact()
            .addNewContactNegative(ContactDTO.builder()
                    .name("testQA20" + i)
                    .lastName("ln" + i)
                    .email("test" + i + "@gmail.com")
                    .phone("")
                    .address("Haifa")
                    .description("contact: " + i)
                    .build())
            .validateErrorMessage());
}
}
