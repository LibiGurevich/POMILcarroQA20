package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashPage extends BasePage{
    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/version_text']")
    MobileElement versionText;

    public boolean validateVersionCorrect() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return isTextEqual(versionText, "Version 1.0.0");
    }

    public AuthentificationPage goToAuthPage() {
        pause(20000);
        return new AuthentificationPage(driver);
    }
}