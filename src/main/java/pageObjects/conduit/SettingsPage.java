package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage {

    @FindBy(className = "text-xs-center")
    private WebElement txt_title;

    @FindBy(xpath = "//input[@placeholder='URL of profile picture]")
    private WebElement field_icon;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement field_username;

    @FindBy(xpath = "//input[@placeholder='Short bio about you']")
    private WebElement field_aboutYou;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement field_email;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    private WebElement field_password;

    @FindBy(className = "btn-outline-danger")
    private WebElement btn_logout;

    public WebElement getTxt_title() {
        return txt_title;
    }

    public WebElement getField_icon() {
        return field_icon;
    }

    public WebElement getField_username() {
        return field_username;
    }

    public WebElement getField_aboutYou() {
        return field_aboutYou;
    }

    public WebElement getField_email() {
        return field_email;
    }

    public WebElement getField_password() {
        return field_password;
    }

    public WebElement getBtn_logout() {
        return btn_logout;
    }
}
