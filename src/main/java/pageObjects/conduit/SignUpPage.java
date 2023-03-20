package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SignUpPage {

    @FindBy(how = How.XPATH, using = "//h1[@class='text-xs-center']")
    private WebElement txt_signUpTitle;

    @FindBy(how = How.LINK_TEXT, using = "Have an account?")
    private WebElement txt_haveAnAccount;

    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement field_signUpUsername;

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    private WebElement field_signUpEmail;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private WebElement field_signUpPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement btn_signUp;

    public WebElement getTxt_signUpTitle() {
        return txt_signUpTitle;
    }

    public WebElement getTxt_haveAnAccount() {
        return txt_haveAnAccount;
    }

    public WebElement getField_signUpUsername() {
        return field_signUpUsername;
    }

    public WebElement getField_signUpEmail() {
        return field_signUpEmail;
    }

    public WebElement getField_signUpPassword() {
        return field_signUpPassword;
    }

    public WebElement getBtn_signUp() {
        return btn_signUp;
    }
}
