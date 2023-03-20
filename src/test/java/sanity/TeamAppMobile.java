package sanity;


import extentions.MobileActions;
import extentions.MobileVerifications;
import extentions.UIVerifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class TeamAppMobile extends CommonOps {

    @Test(priority = 1,description = "Test01 - Verify Login")
    @Description("This test verifies the login to application")
    @Parameters({"email","password"})
    public void test01_login(String email, String pass)
    {
        MobileFlows.login(email,pass);
    }

    @Test(priority = 2,description = "Test02 - Verify New Team Created")
    @Description("This test verifies that new team has been created")
    public void test02_VerifyNewTeamCreation()
    {
        int numOfTeams = MobileFlows.newTeamCreated();
        MobileVerifications.verifyTextElementInMobile(teamAppMain.getList_teams(),numOfTeams+1);
    }

    @Test(priority = 3,description = "Test03 - Verify Activity Has Been Selected")
    @Description("This test verifies that the current activity is selected")
    public void test03_VerifyActivitySelected()
    {
        MobileActions.swipe(MobileActions.Direction.LEFT);
        MobileVerifications.verifyElementIsSelected(teamAppMain.getTab_chat());
    }

    @Test(priority = 4,description = "Test04 - Verify Username Updated")
    @Description("This test verifies that username has been updated")
    public void test04_VerifyUserNameUpdated()
    {
        String name = MobileFlows.updateUsername("Ester");
        UIVerifications.verifyTextInText(name, "Ester");
    }

    @Test(priority = 5,description = "Test05 - Verify Leaving A Group")
    @Description("This test verifies that user leaves a group successfully")
    public void test05_VerifyLeavingAGroup()
    {
       int groupsListSize = MobileFlows.leaveAGroup();
       MobileVerifications.verifyTextElementInMobile(teamAppMain.getList_teams(),groupsListSize-1);
    }
}
