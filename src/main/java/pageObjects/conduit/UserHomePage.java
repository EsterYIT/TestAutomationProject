package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UserHomePage extends NavigateActiveBase{

    @FindBy(how = How.LINK_TEXT, using = "Your Feed")
    private WebElement nav_yourFeed;

    @FindBy(how = How.LINK_TEXT, using = "Global Feed")
    private WebElement nav_globalFeed;

    @FindBy(how = How.XPATH, using = "//div[@class='tag-list']/a")
    private List<WebElement> popular_tags;

    @FindBy(how = How.XPATH, using = "//div[@class='col-md-9']/div/div")
    private List<WebElement> txt_articles;

    @FindBy(xpath = "//div[@class='info']/a")
    private List<WebElement> txt_articleAuthor;

    @FindBy(className = "article-preview")
    private WebElement txt_noArticles;

    public WebElement getNav_yourFeed() {
        return nav_yourFeed;
    }

    public WebElement getNav_globalFeed() {
        return nav_globalFeed;
    }

    public List<WebElement> getPopular_tags() {
        return popular_tags;
    }

    public List<WebElement> getTxt_articles() {
        return txt_articles;
    }

    public List<WebElement> getTxt_articleAuthor() {
        return txt_articleAuthor;
    }

    public WebElement getTxt_noArticles() {
        return txt_noArticles;
    }
}
