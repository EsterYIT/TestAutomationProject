package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DrawerMain {

    @FindBy(className = "toggleVisibilityPanel_hNPyc")
    private WebElement openDrawer;

    @FindBy(css = ".toggleVisibilityPanel_hNPyc.isVisible_1VByM")
    private WebElement closeDrawer;

    @FindBy(xpath = "//div[@class='wrapper_3Kpfj tagsWrapper_jJPK-']/span")
    private List<WebElement> allColorsDrawer;

    @FindBy(xpath = "//div[@class='filterWrapper_1TK4M']/button")
    private List<WebElement> btn_dateDrawer;

    @FindBy(xpath = "//div[@class='statusWrapper_fkjww']/button")
    private List<WebElement> btn_statusDrawer;

    @FindBy(className = "remainingTasks_1ijI7")
    private WebElement txt_remainingTasks;

    public WebElement getOpenDrawer() {
        return openDrawer;
    }

    public WebElement getCloseDrawer() {
        return closeDrawer;
    }

    public List<WebElement> getAllColorsDrawer() {
        return allColorsDrawer;
    }

    public List<WebElement> getBtn_dateDrawer() {
        return btn_dateDrawer;
    }

    public List<WebElement> getBtn_statusDrawer() {
        return btn_statusDrawer;
    }

    public WebElement getTxt_remainingTasks() {
        return txt_remainingTasks;
    }
}
