package tests;

import config.AppiumConfig;
import dto.UserDTO;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class LoginTests extends AppiumConfig {

//    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar'")
//    MobileElement contactBar;

    @Test
    public void positiveLogin(){
        Assert.assertTrue(new SplashPage(driver).goToAuthPage()
                .login(UserDTO.builder()
                        .email("qwerty@qwer.ty")
                        .password("Qwerty!1")
                        .build())
                       // .validateContactBarOpened(contactBar));
                       .validateContactListOpened());

    }

    @Test
    public void negativeLoginEmptyEmail(){
Assert.assertTrue(new SplashPage(driver).goToAuthPage().fillPassword("Qwerty!1")
        .clickLoginBtnNegative().validateErrorTitleAlertCorrect());
    }
}
