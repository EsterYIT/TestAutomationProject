package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class NavigateGitHubPage {

    @FindBy(how = How.LINK_TEXT, using = "Fork on GitHub")
    private WebElement github_link;

    public WebElement getGithub_link() {
        return github_link;
    }
}
