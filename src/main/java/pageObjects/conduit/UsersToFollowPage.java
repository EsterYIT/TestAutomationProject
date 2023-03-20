package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersToFollowPage extends NavigateActiveBase{

    @FindBy(css = ".btn.btn-sm.action-btn.btn-outline-secondary")
    private WebElement btn_follow;

    @FindBy(css = ".btn.btn-sm.action-btn.btn-secondary")
    private WebElement btn_unFollow;

    @FindBy(xpath = "//div[@class='col-xs-12 col-md-10 offset-md-1']/div/div")
    private List<WebElement> txt_userArticles;

    public WebElement getBtn_follow() {
        return btn_follow;
    }

    public WebElement getBtn_unFollow() {
        return btn_unFollow;
    }

    public List<WebElement> getTxt_userArticles() {
        return txt_userArticles;
    }
}
