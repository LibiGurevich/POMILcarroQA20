package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    AppiumDriver<MobileElement> driver;

//    @FindBy(xpath = "//*[@resourse-id='com.sheygam.contactapp:id/action_bar'")
//    MobileElement contactBar;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void typeTextBase(MobileElement el, String text) {
        el.click();
        el.clear();
        el.sendKeys(text);
        driver.hideKeyboard();
    }

    public void clickBase(MobileElement el) {
        el.click();
    }

    public String getTextBase(MobileElement el) {
        return el.getText().toUpperCase().trim();
    }

    public boolean isTextEqual(MobileElement el, String text) {
        pause(5000);
        if(getTextBase(el).equals(text.toUpperCase())) {
            return true;
        } else {
            System.out.println("actual res: " + getTextBase(el) +
                    " expected res: " + text.toUpperCase());
            return false;
        }
    }

    public void pause(long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void backBtnOnEmulator() {
        driver.navigate().back();
    }

//    public boolean validateContactBarOpened() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return isELementExist(contactBar);
//    }

}