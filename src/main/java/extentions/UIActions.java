package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Double Click On Element")
    public static void doubleClick(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.doubleClick(element).build().perform();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement element,String text)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Clear Field")
    public static void clearField(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    @Step("Update Dropdown Element")
    public static void updateDropDown(WebElement element,String text)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1)
    {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Drag And Drop Element")
    public static void dragAndDrop(WebElement elem1, WebElement elem2)
    {
        action.dragAndDrop(elem1,elem2).build().perform();
    }

    @Step
    public static void javaScriptExecutor(WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step
    public static void clear(WebElement element)
    {
        element.sendKeys(Keys.BACK_SPACE);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value)
    {
        elem.sendKeys(value);
    }
}
