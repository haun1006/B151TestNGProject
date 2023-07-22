package techproed.pages;

import techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCenterPage {
    public TestCenterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement loginVerify;
    @FindBy(xpath = "//a//i")
    public WebElement logOut;
}

