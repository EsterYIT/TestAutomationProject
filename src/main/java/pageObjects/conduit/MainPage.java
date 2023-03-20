package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage extends NavigateActiveBase{

    @FindBy(how = How.XPATH, using = "//div[@class='col-md-9']/div/div")
    private List<WebElement> txt_articles;

    @FindBy(how = How.XPATH, using = "//div[@class='tag-list']/a")
    private List<WebElement> popular_tags;

    @FindBy(how = How.XPATH, using = "//ul[@class='pagination']/li")
    private List<WebElement> nav_pages;

    @FindBy(className = "logo-font")
    private WebElement txt_mainTitle;

    @FindBy(xpath = "//div[@class='container']//p")
    private WebElement txt_subtitle;

    @FindBy(css = ".page-item.active")
    private WebElement btn_activePage;

    public List<WebElement> getTxt_articles() {
        return txt_articles;
    }

    public List<WebElement> getPopular_tags() {
        return popular_tags;
    }

    public List<WebElement> getNav_pages() {
        return nav_pages;
    }

    public WebElement getTxt_mainTitle() {
        return txt_mainTitle;
    }

    public WebElement getTxt_subtitle() {
        return txt_subtitle;
    }

    public WebElement getBtn_activePage() {
        return btn_activePage;
    }
}
