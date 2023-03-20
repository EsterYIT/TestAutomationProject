package pageObjects.conduit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPostPage {

    @FindBy(xpath = "//input[@placeholder='Article Title']")
    private WebElement field_title;

    @FindBy(xpath = "//input[@placeholder='What's this article about?']")
    private WebElement field_subtitle;

    @FindBy(xpath = "//input[@placeholder='Write your article (in markdown)']")
    private WebElement field_content;

    @FindBy(xpath = "//input[@placeholder='Enter tags']")
    private WebElement field_tag;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement btn_publish;

    public WebElement getField_title() {
        return field_title;
    }

    public WebElement getField_subtitle() {
        return field_subtitle;
    }

    public WebElement getField_content() {
        return field_content;
    }

    public WebElement getField_tag() {
        return field_tag;
    }

    public WebElement getBtn_publish() {
        return btn_publish;
    }
}
