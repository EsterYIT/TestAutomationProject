package extentions;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class MobileVerifications extends CommonOps {

    @Step("Verify Text In Mobile Element")
    public static void verifyTextElementInMobile(List<AndroidElement> elem, int expected)
    {
        assertEquals(elem.size(), expected);
    }

    @Step("Verify Text In Mobile Element")
    public static void verifyElementIsSelected(AndroidElement elem)
    {
        assertEquals("true", elem.getAttribute("selected"));
    }

}
