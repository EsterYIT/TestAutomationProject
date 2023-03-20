package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PostCommentPage extends PostCommentBasePage {

    @FindBy(xpath = "//div[@class='container']/h1")
    private WebElement txt_mainTitle;

    @FindBy(xpath = "//div[@class='col-xs-12']//p")
    private WebElement txt_subtitle;

    @FindBy(xpath = "//div[@class='col-xs-12 col-md-8 offset-md-2']/div/div")
    private List <WebElement> comments_list;

    @FindBy(xpath = "//div[@class='col-xs-12 col-md-8 offset-md-2']/div/div//a")
    private List <WebElement> authors_list_name;

    @FindBy(className = "ion-trash-a")
    private WebElement delete_comment;

    public WebElement getTxt_mainTitle() {
        return txt_mainTitle;
    }

    public WebElement getTxt_subtitle() {
        return txt_subtitle;
    }

    public List<WebElement> getComments_list() {
        return comments_list;
    }

    public List<WebElement> getAuthors_list_name() {
        return authors_list_name;
    }

    public WebElement getDelete_comment() {
        return delete_comment;
    }
}
