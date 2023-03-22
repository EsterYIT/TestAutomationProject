package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    private WebElement txt_create;

    @FindBy(className = "toggleIconsWrapper_2kpi8")
    private List<WebElement> list_v;

    @FindBy(className = "view_2Ow90")
    private List<WebElement> list_tasks;

    @FindBy(className = "destroy_19w1q")
    private WebElement btn_deleteTask;

    @FindBy(className = "downArrowIcon_3Zu5N")
    private WebElement btn_dropDownColors;

    @FindBy(xpath = "//div[@class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']/span")
    private List<WebElement> allColors;

    @FindBy(className = "dateFormatted_3GjaR")
    private WebElement txt_date;

    @FindBy(className = "emptyState_3FwtK")
    private WebElement txt_noTasks;

    @FindBy(css = ".wrapper_1SRLB.button_3DJvn")
    private List<WebElement> btn_daysOptions;

    @FindBy(css = ".handle.dragIcon_1L0_R")
    private  List<WebElement> list_dragAndDrop;

    @FindBy(className = "wrapper_2r1C1")
    private WebElement bg_header;

    @FindBy(xpath = "//div[@class='icons_MDNeU']//*[name()='svg'][1]")
    private WebElement editor_headerBg;

    @FindBy(xpath = "//div[@class='vc-sketch-presets']/div")
    private List<WebElement> allHeaderColors;

    public List<WebElement> getAllHeaderColors() {
        return allHeaderColors;
    }

    public WebElement getEditor_headerBg() {
        return editor_headerBg;
    }

    public WebElement getBg_header() {
        return bg_header;
    }

    public List<WebElement> getList_dragAndDrop() {
        return list_dragAndDrop;
    }

    public List<WebElement> getBtn_daysOptions() {
        return btn_daysOptions;
    }

    public WebElement getTxt_noTasks() {
        return txt_noTasks;
    }

    public WebElement getTxt_create() {
        return txt_create;
    }

    public List<WebElement> getList_v() {
        return list_v;
    }

    public List<WebElement> getList_tasks() {
        return list_tasks;
    }

    public WebElement getBtn_deleteTask() {
        return btn_deleteTask;
    }

    public WebElement getBtn_dropDownColors() {
        return btn_dropDownColors;
    }

    public List<WebElement> getAllColors() {
        return allColors;
    }

    public WebElement getTxt_date() {
        return txt_date;
    }
}
