package workflows;

import extentions.MobileActions;
import extentions.UIActions;
import extentions.WaitTimeUnit;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Verify New Team Created")
    public static int newTeamCreated()
    {

        int numOfTeams = teamAppMain.getList_teams().size();
        MobileActions.tap(teamAppMain.getBtn_plus());
        MobileActions.tap(newTeamMain.getBtn_chooseTeam());
        MobileActions.tap(newTeamMain.getHangoutTeam());
        MobileActions.updateText(newTeamDetailsMain.getField_teamName(), "test");
        MobileActions.updateText(newTeamDetailsMain.getField_meetingPlace(), "bar");
        MobileActions.updateText(newTeamDetailsMain.getField_date(), "14/3/2023");
        MobileActions.updateText(newTeamDetailsMain.getField_time(), "12:00");
        MobileActions.tap(newTeamDetailsMain.getBtn_createTeam());

        return numOfTeams;
    }

    @Step("Verify User Name Updated")
    public static String  updateUsername(String name)
    {
        MobileActions.tap(teamAppMain.getOpenDrawer());
        MobileActions.tap(drawerMain.getDrawer_editProfile());
        MobileActions.tap(editProfileActivity.getImg_editUsername());
        UIActions.clear(editProfileActivity.getField_editUsername());
        MobileActions.updateText(editProfileActivity.getField_editUsername(),name);
        MobileActions.tap(editProfileActivity.getBtn_update());
        MobileActions.tap(teamAppMain.getOpenDrawer());
        String newName = drawerMain.getDrawer_username().getText();
        MobileActions.tap(drawerMain.getDrawer_home());

        return newName;
    }

    @Step("Verify Login To Application")
    public static void login(String email,String pass)
    {
        try{
            MobileActions.updateText(loginPage.getField_email(),email);
            MobileActions.updateText(loginPage.getField_password(),pass);
            MobileActions.tap(loginPage.getBtn_login());
        }catch (Exception e){
            System.out.println("You are already connected");
        }
    }

    @Step("Verify Leaving A Group")
    public static int leaveAGroup()
    {
        int listSize = 0;
        try{
            MobileActions.tap(teamAppMain.getBtn_approveToContact());
            MobileActions.tap(teamAppMain.getBtn_approveToGallery());
        }catch (Exception ex){
            try {
                listSize = teamAppMain.getList_teams().size();
                MobileActions.tap(teamAppMain.getList_teams().get(teamAppMain.getList_teams().size() - 1));
                MobileActions.tap(overViewPage.getLogoutFromAGroup());
                MobileActions.tap(overViewPage.getBtn_yes());
            }catch (Exception e){
                throw new IndexOutOfBoundsException("List Of Groups Is Empty, See Details: " + e.getMessage());
            }
        }
        return listSize;
    }
}
