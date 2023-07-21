package Techproed.tests.day28_DataProvider;

import Techproed.pages.GooglePage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"volvo"},
                {"audio"},
                {"mercedes"},
                {"ford"}};
    }

    /*
        google sayfasına gidip
        DataProvider ile belirtilen araç isimlerini aratalım
         */
    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Dataprovider'deki verilerle arama yapalım
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(2);

        //Her arama için sayfa resmi alalım
        ReusableMethods.tumSayfaResmi();

        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}
