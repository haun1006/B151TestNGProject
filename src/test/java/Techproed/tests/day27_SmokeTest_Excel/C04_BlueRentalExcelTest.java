package Techproed.tests.day27_SmokeTest_Excel;

import Techproed.pages.BlueRentalPage;
import Techproed.utilities.ConfigReader;
import Techproed.utilities.Driver;
import Techproed.utilities.ExcelReader;
import Techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_BlueRentalExcelTest {
    @Test
    public void test01() {
        //Dosya yolu ve sayfa ismi ile objemizi oluşturalım
        String dosyaYolu = ConfigReader.getProperty("dosyaYolu");
        String sayfaIsmi = ConfigReader.getProperty("sayfaIsmi");
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);

        /*
        mysmoketestdata excel dosyasındaki tüm email ve passwordler ile
        Bluerentalcar sitesinde login olalım ve her kullanıcı için login olduğunu doğrulayalım
         */


        //Bluerentalcar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();//-->Locatelere ulaşabilmek için pageden obje oluşturduk

        //Bir loop oluşturup excel dosyasındaki tüm veriler ile login olalım
        for (int i = 1; i <=reader.rowCount() ; i++) {//-->i'yi 1'den baslattık çünkü 0. indexte başlıklar var
            String email = reader.getCellData(i,0);
            String password = reader.getCellData(i,1);
            System.out.println(email +" || "+password);
            rentalPage.login.click();
            ReusableMethods.bekle(2);
            rentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
            ReusableMethods.bekle(2);
            rentalPage.loginVerify.click();
            ReusableMethods.bekle(1);
            Assert.assertTrue(rentalPage.logout.isDisplayed());
            rentalPage.logout.click();
            ReusableMethods.bekle(1);
            rentalPage.ok.click();
        }
        //Sayfayı kapatınız
        Driver.closeDriver();

    }
}
