package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserProfilePage extends NavigateActiveBase {

    @FindBy(how = How.LINK_TEXT, using = "Your Articles")
    private WebElement nav_yourArticles;

    @FindBy(how = How.LINK_TEXT, using = "Favorited Articles")
    private WebElement nav_favoriteArticles;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-outline-secondary action-btn']")
    private WebElement btn_editProfile;

    public WebElement getNav_yourArticles() {
        return nav_yourArticles;
    }

    public WebElement getNav_favoriteArticles() {
        return nav_favoriteArticles;
    }

    public WebElement getBtn_editProfile() {
        return btn_editProfile;
    }
}
