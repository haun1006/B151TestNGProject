package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C06_DataProviderTest {

    /*
    //ayni verileri ayni anda test02 methodu icinde kullanmak istiyoruz.
    //(dataProvider = "Veriler") kismini tüm testlerin yanina yazariz.
    //Tek method baglamak isteseydik, methodun yanina parantez acip (name) yazardik dün yaptik
     */
    @DataProvider
    public static Object[][] veriler() {
        return new Object[][]{{"esen"},
                {"mehmet"},
                {"esma"},
                {"ali"},
                {"mert"},
                {"burcu"},
                {"yunus"}};
    }

    @Test (dataProvider = "veriler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "veriler")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "veriler")
    public void test03(String name) {
        System.out.println(name);
    }

    @Test(dataProvider = "veriler")
    public void test04(String ad) {
        System.out.println(ad);
    }
}
