package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTeamPage {

    private AppiumDriver mobileDriver;
    public CreateNewTeamPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="text_input_end_icon")
    private AndroidElement btn_chooseTeam;

    @AndroidFindBy(xpath="//*[text()='Hangout Team']")
    private AndroidElement hangoutTeam;

    public AndroidElement getBtn_chooseTeam() {
        return btn_chooseTeam;
    }

    public AndroidElement getHangoutTeam() {
        return hangoutTeam;
    }
}
