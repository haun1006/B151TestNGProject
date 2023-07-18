package Techproed.tests.day26_PageKullanimi;

import Techproed.pages.BlueRentalPage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_PozitifTest {
    @Test
    public void test01() {
        //Acceptance Criteria:

        //Admin olarak, uygulamaya giriş yapabilmeliyim

        //https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);

        //Admin email: jack@gmail.com

        //Admin password: 12345
        rentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalemail"), Keys.TAB,
                ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);

        //Giriş yapıldığını doğrulayalım
        ReusableMethods.bekle(2);
        Assert.assertTrue(rentalPage.loginVerify.getText().contains("Jack"));

        // Sayfayı kapatınız
        Driver.closeDriver();
    }
}
