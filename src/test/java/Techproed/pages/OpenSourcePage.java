package Techproed.pages;

import Techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenSourcePage {
    /*
    TestNG de locate'lerimizi pages package'ı altında oluşturduğumuz class'lar içinde alırız.
    Bu class'lar içinde driver'ımızı tanımlamak v webelementleri oluşturqbilmek için constructor oluşturup
    bu constructor içibnde PageFactory class'ından initelements methodunu kullanarak driveri'öizi bu class'a
    tanımlarız
     */
    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    /*
        Webelementleri locate edebilmek için findelement() methodu kullanıyorduk
    @findBy notasyonu ile artık findelement() methodunu kullanmayıp, @FindBy notasyonu içinde
    driver'in yerini tarif etmemiz gerekiyor
        Yukarıdaki (Driver.getDriver(),this) komutu burada ihtiyaç duyduğum driver, Driver class'ındaki
        getDriver() methodundaki driver demek oluyor.
     */

    }
    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernname;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitbutton;
    @FindBy(xpath = "//h6")
    public WebElement verify;
}
