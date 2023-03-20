package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NewTeamDetailsPage {

    private AppiumDriver mobileDriver;
    public NewTeamDetailsPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="hangoutTeamName")
    private AndroidElement field_teamName;

    @AndroidFindBy(id="meetingPlace")
    private AndroidElement field_meetingPlace;

    @AndroidFindBy(id="dateId")
    private AndroidElement field_date;

    @AndroidFindBy(id="hourId")
    private AndroidElement field_time;

    @AndroidFindBy(id="createHangoutTeam")
    private AndroidElement btn_createTeam;

    @AndroidFindBy(id="albumButton")
    private AndroidElement btn_album;

    @AndroidFindBy(id="menuButton")
    private AndroidElement btn_menu;

    @AndroidFindBy(id="chatButton")
    private AndroidElement btn_chat;

    public AndroidElement getField_teamName() {
        return field_teamName;
    }

    public AndroidElement getField_meetingPlace() {
        return field_meetingPlace;
    }

    public AndroidElement getField_date() {
        return field_date;
    }

    public AndroidElement getField_time() {
        return field_time;
    }

    public AndroidElement getBtn_createTeam() {
        return btn_createTeam;
    }

    public AndroidElement getBtn_album() {
        return btn_album;
    }

    public AndroidElement getBtn_menu() {
        return btn_menu;
    }

    public AndroidElement getBtn_chat() {
        return btn_chat;
    }
}
