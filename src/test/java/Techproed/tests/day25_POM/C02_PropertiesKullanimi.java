package Techproed.tests.day25_POM;

import Techproed.utilities.ConfigReader;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class C02_PropertiesKullanimi {
    @Test
    public void test01() throws FileNotFoundException {
        String amazonUrl = ConfigReader.getProperty("amazon.url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        System.out.println(amazonUrl);
        System.out.println(username);
        System.out.println(password);


    }
}
