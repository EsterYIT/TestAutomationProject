package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishedArticleMainPage extends PostCommentBasePage{

    @FindBy(tagName = "p")
    private WebElement txt_articleContent;

    public WebElement getTxt_articleContent() {
        return txt_articleContent;
    }
}
