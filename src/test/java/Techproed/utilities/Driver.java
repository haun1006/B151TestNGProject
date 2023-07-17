package Techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private  Driver() {
        /*
        Driver class'ından obje oluşturmanın önüne geçebilmek için default constructor'ı
        private yaparak bunu engellemiş oluruz.
        Bu kalıba da "Singleton Pattern" denir.
         */
    }
    /*
        POM(Page Object Model)

        Test senaryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
        olanak sağlayan yazılım test yöntemidir. TestNG ve Cucumber frameworklerinde POM
        kalıbı kullanılır.
     */
    static WebDriver driver;
    /*
               Driver'i her çağırdığımızda yeni bir pencerenin açılmasının önüne geçmek için
           if bloğu içinde Eğer driver'a değer ATANMAMIŞSA değer ata, eğer değer atanmışsa
           driver'i aynı sayfada return et
    */
    public static WebDriver getDriver() {
        if (driver == null) {   //-->Driver'a değer atanmamışsa
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }
    public static void closeDriver(){
        if (driver != null) { //-->Driver'a değer atanmamışsa, boş değilse
            driver.close();
            driver = null; //--> Driver'ı kapattıktan sonra boşalt
        }
    }
    public static void quitDriver(){
        if (driver != null) { //-->Driver'a değer atanmamışsa, boş değilse
            driver.quit();
            driver = null; //--> Driver'ı kapattıktan sonra boşalt
        }
    }
}
