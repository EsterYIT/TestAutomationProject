package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class DrawerMain extends CommonOps {

    public DrawerMain(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(xpath="//*[text()='Home']")
    private AndroidElement drawer_home;
    @AndroidFindBy(xpath="//*[text()='Edit Profile']")
    private AndroidElement drawer_editProfile;

    @AndroidFindBy(xpath="//*[text()='Add To Contacts']")
    private AndroidElement drawer_addToContacts;

    @AndroidFindBy(xpath="//*[text()='Support']")
    private AndroidElement drawer_support;

    @AndroidFindBy(xpath="//*[text()='Share Your User Info']")
    private AndroidElement drawer_shareInfo;

    @AndroidFindBy(xpath="//*[text()='Log Out']")
    private AndroidElement drawer_logout;

    @AndroidFindBy(id="nameBar")
    private AndroidElement drawer_username;

    public AndroidElement getDrawer_username() {
        return drawer_username;
    }

    public AndroidElement getDrawer_home() {
        return drawer_home;
    }

    public AndroidElement getDrawer_editProfile() {
        return drawer_editProfile;
    }

    public AndroidElement getDrawer_addToContacts() {
        return drawer_addToContacts;
    }

    public AndroidElement getDrawer_support() {
        return drawer_support;
    }

    public AndroidElement getDrawer_shareInfo() {
        return drawer_shareInfo;
    }

    public AndroidElement getDrawer_logout() {
        return drawer_logout;
    }
}
