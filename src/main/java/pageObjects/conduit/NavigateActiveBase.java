package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class NavigateActiveBase {

    @FindBy(how = How.XPATH, using = "//ul[@class='nav nav-pills outline-active']/li")
    private List<WebElement> nav_activeArticle;

    public List<WebElement> getNav_activeArticle() {
        return nav_activeArticle;
    }
}
