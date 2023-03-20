package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import workflows.WebFlows;

public class HeadMenuPage {

    @FindBy(className = "navbar-brand")
    private WebElement txt_conduit;

    @FindBy(linkText = "Home")
    private WebElement txt_home;

    @FindBy(linkText = "Sign in")
    private WebElement txt_SignIn;

    @FindBy(linkText = "Sign up")
    private WebElement txt_SignUp;

    public WebElement getTxt_conduit() {
        return txt_conduit;
    }

    public WebElement getTxt_home() {
        return txt_home;
    }

    public WebElement getTxt_SignIn() {
        return txt_SignIn;
    }

    public WebElement getTxt_SignUp() {
        return txt_SignUp;
    }
}
