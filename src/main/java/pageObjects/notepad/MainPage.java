package pageObjects.notepad;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(className = "Edit")
    private WebElement field_edit;

    @FindBy(xpath = "//*[@AutomationId='CommandButton_6']")
    private WebElement btn_save;

    @FindBy(xpath = "//*[@AutomationId='CommandButton_7']")
    private WebElement btn_doNotSave;

    @FindBy(name = "עריכה")
    private WebElement btn_editBar;

    @FindBy(xpath = "//*[@AutomationId='23']")
    private WebElement btn_switch;
    @FindBy(xpath = "//*[@AutomationId='1152']")
    private WebElement field_search;

    @FindBy(xpath = "//*[@AutomationId='1153']")
    private WebElement field_switch;

    @FindBy(xpath = "//*[@AutomationId='1025']")
    private WebElement btn_switchAll;

    @FindBy(xpath = "//*[@AutomationId='2']")
    private WebElement btn_cancel;

    @FindBy(xpath = "//*[@AutomationId='26']")
    private WebElement btn_date;

    @FindBy(xpath = "//*[@AutomationId='24']")
    private WebElement list_moveTo;

    @FindBy(xpath = "//*[@AutomationId='258']")
    private WebElement btn_rowNumber;

    @FindBy(xpath = "//*[@AutomationId='1']")
    private WebElement btn_moveTo;

    @FindBy(xpath = "//*[@AutomationId='65535']")
    private WebElement txt_notExistRow;

    @FindBy(xpath = "//*[@AutomationId='2']")
    private WebElement btn_approval;

    @FindBy(name = "סגור")
    private WebElement btn_close;

    public WebElement getField_edit() {
        return field_edit;
    }

    public WebElement getBtn_save() {
        return btn_save;
    }

    public WebElement getBtn_doNotSave() {
        return btn_doNotSave;
    }

    public WebElement getBtn_editBar() {
        return btn_editBar;
    }

    public WebElement getBtn_switch() {
        return btn_switch;
    }

    public WebElement getField_search() {
        return field_search;
    }

    public WebElement getField_switch() {
        return field_switch;
    }

    public WebElement getBtn_switchAll() {
        return btn_switchAll;
    }

    public WebElement getBtn_cancel() {
        return btn_cancel;
    }

    public WebElement getBtn_date() {
        return btn_date;
    }

    public WebElement getList_moveTo() {
        return list_moveTo;
    }

    public WebElement getBtn_rowNumber() {
        return btn_rowNumber;
    }

    public WebElement getBtn_moveTo() {
        return btn_moveTo;
    }

    public WebElement getTxt_notExistRow() {
        return txt_notExistRow;
    }

    public WebElement getBtn_approval() {
        return btn_approval;
    }

    public WebElement getBtn_close() {
        return btn_close;
    }
}
