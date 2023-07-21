package Techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {

    /*
           Dataprovider, bircok veriyi test caselerde loop kullanmadan aktarmak icin kullanilir.
       TestNG'den gelen bir ozelliktir.
       2 boyutlu Objet Array return eder.
       Kullanımı için @test notasyonundan sonra parametre olarak (dataprovider = "method ismi") yazılır.
       Kaç tane veri ile çalışacaksak test methoduna o kadar parametre eklenir.

       Data driven testing() de datalarımızı 3 farklı şekilde kullanabiliriz.
        1-.properties dosyasindan datalari alabiliriz. -->ConfigReader.getProperty() ile
        2-Excel dosyasindan datalari alabiliriz.    -->ExcelReader class'i ile
        3-DataProvider kullanarak datalari alabiliriz.  -->DataProvider methodu ile

    */

    @DataProvider (name = "test02")
    public static Object[][] isimler() {
        return new Object[][]{
                {"esen"},
                {"mehmet"},
                {"esma"},
                {"ali"},
                {"mert"},
                {"burcu"},
                {"yunus"}};
    }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"ford"},
                {"mercedes"},
                {"volvo"},
                {"audi"}};
    }

      /*
    Olusturdugumuz dataprovider methodunu baska bir test methodunda da kullanabiliriz.
    Bunun icin @DataProvider notasyonundan sonra yeni olusturdugumuz methodun ismini (name="test02") olarak
    degistirmemiz gerekir
     */
    //ayni veriler kullanilacaksa tekrar dataprovider olusturmaya yani object tiklamaya gerek yok

    @Test (dataProvider = "isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);
    }


}
