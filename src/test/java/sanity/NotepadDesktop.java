package sanity;

import extentions.UIVerifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class NotepadDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Date")
    @Description("This test verifies the date we get from notepad to the current date")
    public void test01_verifyDate()
    {
        DesktopFlows.getDate();
        String dateFromNotepad = DesktopFlows.reverseString(DesktopFlows.getText().split(" ")[1].replace("\u200f", ""));
        UIVerifications.verifyTextInText(dateFormat.format(date).split(" ")[0], dateFromNotepad);
    }

    @Test(description = "Test02 - Verify Text After Switching")
    @Description("This test verifies that the replacement of the words was done properly")
    public void test02_verifyTextSwitching()
    {
        DesktopFlows.addText("Test Automation");
        DesktopFlows.switchWords("Test" , "Automation");
        UIVerifications.verifyTextElement(notepadMain.getField_edit(), "Automation Automationnnnn");
    }

    @Test(description = "Test03 - Verify Row Number Does Not Exist")
    @Description("This test verifies the absence of row number")
    public void test03_VerifyTheAbsenceOfLine()
    {
        DesktopFlows.selectRowNumber("This Is Desktop Test Automation","8",3);
        UIVerifications.visibilityOfElement(notepadMain.getTxt_notExistRow());
        DesktopFlows.clickOnApproveBtn();
    }
}
