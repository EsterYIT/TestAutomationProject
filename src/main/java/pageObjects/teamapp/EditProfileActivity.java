package pageObjects.teamapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class EditProfileActivity extends CommonOps {

    public EditProfileActivity(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

    @AndroidFindBy(id="updateUsername")
    private AndroidElement img_editUsername;

    @AndroidFindBy(id="editProfileName")
    private AndroidElement field_editUsername;

    @AndroidFindBy(id="updateButton")
    private AndroidElement btn_update;

    @AndroidFindBy(xpath="//android.widget.Toast[1]")
    private AndroidElement txt_toastMsg;

    public AndroidElement getImg_editUsername() {
        return img_editUsername;
    }

    public AndroidElement getField_editUsername() {
        return field_editUsername;
    }

    public AndroidElement getBtn_update() {
        return btn_update;
    }

    public AndroidElement getTxt_toastMsg() {
        return txt_toastMsg;
    }
}
