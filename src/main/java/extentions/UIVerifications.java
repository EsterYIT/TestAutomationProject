package extentions;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;

import static org.testng.Assert.*;

public class UIVerifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextElement(WebElement elem, String expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Text In Text")
    public static void verifyTextInText(String actual, String expected)
    {
        assertEquals(actual, expected);
    }

    @Step("Verify Follow Element")
    public static void verifyFollowOrUnfollowElement(WebElement elem, String expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText().split(" ")[1], expected);
    }

    @Step("Verify Post Comment Element")
    public static void verifyNumberOfComments(List<WebElement> elements, int expected)
    {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(),expected);
    }

    @Step("Verify Element Visually")
    public static void verifyAClickOnVisualElement(String pageNumber) throws FindFailed
    {
        assertEquals(conduitMain.getBtn_activePage().getText(),pageNumber);
    }

    @Step("Verify Visibility Of Element (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elements)
    {
        for(WebElement element: elements){
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Verify Visibility Of Element")
    public static void visibilityOfElement(WebElement element)
    {
        assertTrue(element.isDisplayed());
    }

    @Step("Verify Number")
    public static void verifyNumber(int actual, int expected)
    {
        assertEquals(actual, expected);
    }
}
