package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private AppiumDriver mobileDriver;
    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="teamCard")
    private List<AndroidElement> list_teams;

    @AndroidFindBy(id="plusId")
    private AndroidElement btn_plus;

    @AndroidFindBy(xpath="//*[@contentDescription='Chat']")
    private AndroidElement tab_chat;

    @AndroidFindBy(xpath="//*[@contentDescription='Teams']")
    private AndroidElement tab_teams;

    @AndroidFindBy(xpath="//*[@contentDescription='Open navigation drawer']")
    private AndroidElement openDrawer;

    @AndroidFindBy(xpath="//*[@contentDescription='Close navigation drawer']")
    private AndroidElement closeDrawer;

    @AndroidFindBy(id="permission_allow_button")
    private AndroidElement btn_approveToContact;

    @AndroidFindBy(id="permission_allow_button")
    private AndroidElement btn_approveToGallery;

    public AndroidElement getBtn_approveToContact() {
        return btn_approveToContact;
    }

    public AndroidElement getBtn_approveToGallery() {
        return btn_approveToGallery;
    }

    public AndroidElement getCloseDrawer() {
        return closeDrawer;
    }

    public List<AndroidElement> getList_teams() {
        return list_teams;
    }

    public AndroidElement getBtn_plus() {
        return btn_plus;
    }

    public AndroidElement getTab_chat() {
        return tab_chat;
    }

    public AndroidElement getTab_teams() {
        return tab_teams;
    }

    public AndroidElement getOpenDrawer() {
        return openDrawer;
    }
}
