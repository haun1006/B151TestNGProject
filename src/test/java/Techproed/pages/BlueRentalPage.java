package Techproed.pages;

import Techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRentalPage {
    public BlueRentalPage(){      // Constructor olusturmus olduk.
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement login;
    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@type='button']")
    public WebElement loginVerify;
}
