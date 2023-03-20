package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Get Text From Notepad")
    public static String getText()
    {
        return notepadMain.getField_edit().getText();
    }

    @Step("Business Flow: Add Text In Notepad")
    public static void addText(String text)
    {
        UIActions.updateText(notepadMain.getField_edit(), text);
    }

    @Step("Business Flow: Get Date From Notepad")
    public static void getDate()
    {
        UIActions.click(notepadMain.getBtn_editBar());
        UIActions.click(notepadMain.getBtn_date());
    }

    @Step("Business Flow: Switch Between Words")
    public static void switchWords(String toSearch, String toSwitch)
    {
        UIActions.click(notepadMain.getBtn_editBar());
        UIActions.click(notepadMain.getBtn_switch());
        if(notepadMain.getField_search().getAttribute("Value.Value") != null)
            UIActions.clear(notepadMain.getField_search());
        UIActions.updateText(notepadMain.getField_search(), toSearch);
        if(notepadMain.getField_switch().getAttribute("Value.Value") != null) {
            UIActions.doubleClick(notepadMain.getField_switch());
            UIActions.clear(notepadMain.getField_switch());
        }
        UIActions.updateText(notepadMain.getField_switch(), toSwitch);
        UIActions.click(notepadMain.getBtn_switchAll());
        UIActions.click(notepadMain.getBtn_cancel());
    }


    @Step("Business Flow: Reverse String")
    public static String reverseString(String text)
    {
        String textAfterChange = "";
        String [] textInArray = (text.split("/"));

        for(int i = textInArray.length-1; i >= 0;i--){
            textAfterChange += textInArray[i];
           if(i != 0)
               textAfterChange+="/";
        }
        return textAfterChange;
    }

    @Step("Business Flow: Select Row Number")
    public static void selectRowNumber(String text,String rowNumber,int rowSize)
    {
        for(int i = 0; i < rowSize;i++){
            notepadMain.getField_edit().sendKeys(text);
            notepadMain.getField_edit().sendKeys(Keys.ENTER);
        }
        UIActions.click(notepadMain.getBtn_editBar());
        UIActions.click(notepadMain.getList_moveTo());
        UIActions.updateText(notepadMain.getBtn_rowNumber(), rowNumber);
        UIActions.click(notepadMain.getBtn_moveTo());
    }

    @Step("Business Flow: Click On Approve Button")
    public static void clickOnApproveBtn()
    {
        UIActions.click(notepadMain.getBtn_approval());
        UIActions.click(notepadMain.getBtn_approval());
    }
}
