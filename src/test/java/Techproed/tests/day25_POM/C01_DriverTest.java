package Techproed.tests.day25_POM;

import Techproed.utilities.Driver;
import org.testng.annotations.Test;

public class C01_DriverTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get("http://amazon.com");
        Driver.getDriver().get("http://youtube.com");
        Driver.getDriver().get("http://facebook.com");
        /*
        Driver'a koyduğumuz if bloğu ile buradaki sayfalara tek browser ile sırasıyla gittik
        Driver daki if bloğunu kullanmadığımız zaman her get() methodu kullandığımızda yeni bir browser açtı.
         */

    }

    @Test
    public void test03() {
        Driver.getDriver().get("http://amazon.com");
        Driver.getDriver().get("http://youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("http://facebook.com");
    }

    @Test
    public void test04() {
        //Driver driver = new Driver();
        //Singleton pattern kuyllandığımız için obje oluşturmanın önüne geçtik

    }
}
