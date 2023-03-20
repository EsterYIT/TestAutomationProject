package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SignInPage {

    @FindBy(how = How.XPATH, using = "//h1[@class='text-xs-center']")
    private WebElement txt_signInTitle;

    @FindBy(how = How.LINK_TEXT, using = "Need an account?")
    private WebElement txt_needAnAccount;

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    private WebElement field_signInEmail;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private WebElement field_signInPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement btn_signIn;

    public WebElement getTxt_signInTitle() {
        return txt_signInTitle;
    }

    public WebElement getTxt_needAnAccount() {
        return txt_needAnAccount;
    }

    public WebElement getField_signInEmail() {
        return field_signInEmail;
    }

    public WebElement getField_signInPassword() {
        return field_signInPassword;
    }

    public WebElement getBtn_signIn() {
        return btn_signIn;
    }
}
