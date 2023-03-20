package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishedArticleHeadPage extends PostCommentBasePage{

    @FindBy(tagName = "h1")
    private WebElement txt_articleTitle;

    @FindBy(css = ".btn.btn-outline-secondary.btn-sm")
    private WebElement link_editProfile;

    @FindBy(css = ".btn.btn-outline-danger.btn-sm")
    private WebElement link_deleteArticle;

    public WebElement getTxt_articleTitle() {
        return txt_articleTitle;
    }

    public WebElement getLink_editProfile() {
        return link_editProfile;
    }

    public WebElement getLink_deleteArticle() {
        return link_deleteArticle;
    }
}
