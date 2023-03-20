package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class LoginPage extends CommonOps {

    public LoginPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="emailInput")
    private AndroidElement field_email;

    @AndroidFindBy(id="passwordInput")
    private AndroidElement field_password;

    @AndroidFindBy(id="loginBtn")
    private AndroidElement btn_login;

    @AndroidFindBy(id="registerBtn")
    private AndroidElement btn_register;

    public AndroidElement getField_email() {
        return field_email;
    }

    public AndroidElement getField_password() {
        return field_password;
    }

    public AndroidElement getBtn_login() {
        return btn_login;
    }

    public AndroidElement getBtn_register() {
        return btn_register;
    }
}
