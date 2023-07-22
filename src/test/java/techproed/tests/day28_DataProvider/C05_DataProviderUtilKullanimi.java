package techproed.tests.day28_DataProvider;

import techproed.utilities.DataProviderUtil;
import org.testng.annotations.Test;

public class C05_DataProviderUtilKullanimi {
    @Test(dataProvider = "sehirVerileri",dataProviderClass = DataProviderUtil.class)
    public void test01(String sehir, String bolge, String plaka) {
        System.out.println(sehir+ "    |   "+bolge+ "       |    "+plaka);

    }
}
