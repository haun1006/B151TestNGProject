package Techproed.tests.day26_PageKullanimi;

import Techproed.pages.OpenSourcePage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //Username : Admin
        //Password : admin123

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.usernname.sendKeys(ConfigReader.getProperty("OpenSourceUsername"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("OpenSourcePassword"));
        sourcePage.submitbutton.click();


        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(sourcePage.verify.isDisplayed());

        //Sayfayı kağapatınız
        Driver.closeDriver();
    }
}
