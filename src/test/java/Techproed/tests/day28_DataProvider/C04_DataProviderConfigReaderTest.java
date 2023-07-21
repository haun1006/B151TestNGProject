package Techproed.tests.day28_DataProvider;

import Techproed.pages.BlueRentalPage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProviderConfigReaderTest {
    /*
Dataprovider kullanarak .properties dosyasındaki veriler ile BlueRentalCar sitesine login olalim

       */
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{ConfigReader.getProperty("mail1"), ConfigReader.getProperty("sifre1")},
                {ConfigReader.getProperty("mail2"), ConfigReader.getProperty("sifre2")},
                {ConfigReader.getProperty("mail3"), ConfigReader.getProperty("sifre3")},
                {ConfigReader.getProperty("mail4"), ConfigReader.getProperty("sifre4")}};
    }


    @Test (dataProvider = "blueRental")
    public void test01(String mail, String password){
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(mail, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(2);
        Driver.closeDriver();


    }
}
