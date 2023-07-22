package techproed.tests.day26_PageKullanimi;

import techproed.pages.OpenSourcePageClass;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //Username : Admin
        //Password : admin123

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePageClass.username().sendKeys(ConfigReader.getProperty("OpenSourceUsername"));
        OpenSourcePageClass.username().sendKeys(ConfigReader.getProperty("OpenSourcePassword"));
        OpenSourcePageClass.submitButton().click();



        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(OpenSourcePageClass.verify().isDisplayed());

        //Sayfayı kapatınız
        Driver.closeDriver();
    }
}
