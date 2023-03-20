package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostCommentBasePage {

    @FindBy(xpath = "//a[@class='author']")
    private WebElement link_articleAuthor;

    @FindBy(xpath = "//span[@class='date']")
    private WebElement txt_articleDate;

    @FindBy(className = "form-control")
    private WebElement field_comment;

    @FindBy(css = ".btn.btn-sm.btn-primary")
    private WebElement btn_postComment;

    public WebElement getLink_articleAuthor() {
        return link_articleAuthor;
    }

    public WebElement getTxt_articleDate() {
        return txt_articleDate;
    }

    public WebElement getField_comment() {
        return field_comment;
    }

    public WebElement getBtn_postComment() {
        return btn_postComment;
    }
}
