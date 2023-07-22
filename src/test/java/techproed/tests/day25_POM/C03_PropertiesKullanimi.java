package techproed.tests.day25_POM;

import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_PropertiesKullanimi {
    @Test
    public void amazonTest() {
        //amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //basligin Amazon içerdiğini test edelim
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //aramakutusunda iphone aratalım
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchText"), Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

        //google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //sayfayı kapatınız
        Driver.closeDriver();

        //facebook sayfasina gidiniz
        Driver.getDriver().get("https://facebook.com");

    }
}
