package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainArticlesPage {

    @FindBy(xpath = "//p//a[@href='#login']")
    private WebElement signInFromArticle;

    @FindBy(xpath = "//p//a[@href='#register']")
    private WebElement signUpFromArticle;

    public WebElement getSignInFromArticle() {
        return signInFromArticle;
    }

    public WebElement getSignUpFromArticle() {
        return signUpFromArticle;
    }
}
