package Techproed.tests.day27_SmokeTest_Excel;

import Techproed.pages.BlueRentalPage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_NegatifTest {
    @Test
    public void test01() {
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found
        //------------------------------------------//

        //BlueRental sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        //Hata mesajının görünür olduğunu doğrula
        ReusableMethods.visibleWait(rentalPage.mesajVerify,5);
        Assert.assertTrue(rentalPage.mesajVerify.isDisplayed());

        //Sayfayı kapatınız
        Driver.closeDriver();


    }
}