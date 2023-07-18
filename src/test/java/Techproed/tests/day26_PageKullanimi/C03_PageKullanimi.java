package Techproed.tests.day26_PageKullanimi;

import Techproed.pages.TestCenterPage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_PageKullanimi {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.submit.click();
        ReusableMethods.bekle(2);//--> method ile bekledik
        Assert.assertTrue(centerPage.loginVerify.isDisplayed());


        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logOut.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(centerPage.submit.isDisplayed());

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}
