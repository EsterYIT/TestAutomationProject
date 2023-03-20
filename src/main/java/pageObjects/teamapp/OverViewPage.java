package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class OverViewPage extends CommonOps {

    public OverViewPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="logout")
    private AndroidElement logoutFromAGroup;

    @AndroidFindBy(id="button1")
    private AndroidElement btn_yes;

    @AndroidFindBy(id="button2")
    private AndroidElement btn_no;

    public AndroidElement getBtn_yes() {
        return btn_yes;
    }

    public AndroidElement getBtn_no() {
        return btn_no;
    }

    public AndroidElement getLogoutFromAGroup() {
        return logoutFromAGroup;
    }
}
