package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserHeadPage {

    @FindBy(how = How.LINK_TEXT, using = "Home")
    private WebElement txt_home;

    @FindBy(how = How.LINK_TEXT, using = "New Post")
    private WebElement txt_newPost;

    @FindBy(how = How.LINK_TEXT, using = "Settings")
    private WebElement txt_settings;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-xs-right']/li")
    private List<WebElement>
            list_headPage;

    @FindBy(how = How.XPATH, using = "//img[@src='https://api.realworld.io/images/smiley-cyrus.jpeg']")
    private WebElement txt_editProfile;

    public WebElement getTxt_home() {
        return txt_home;
    }

    public WebElement getTxt_newPost() {
        return txt_newPost;
    }

    public WebElement getTxt_settings() {
        return txt_settings;
    }

    public WebElement getTxt_editProfile() {
        return txt_editProfile;
    }

    public List<WebElement> getList_headPage() {
        return list_headPage;
    }
}
