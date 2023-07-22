package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
    WebDriver driver;
    /*
    Junit'te test methodlarını istediğimiz şekilde sıralamak için method isimlerini alfabetiik ve numerik
    sıralı olarak yazmamız gerekiyordu. TestNG framework'ünde bu sıralama için @test notasyonundan sonra
    parametre olarak (priority = 1 ) gibi öncelik sırası belirterek tesrt methodlarımızı sıralayabiliriz.
    Priority kullanmadığımız method'da priority değerini 0 (sıfır ) olarak kabul eder.
     */

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void amazonTest() { //--> ikinci olarak amazon çalışır
        driver.get("https://amazon.com");
    }
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com"); //--> ilk olarak youtube çalışır default = 0 dır
    }
    @Test(priority = 2)
    public void facebookTest() { //--> son olarak facebook çalışsın
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
