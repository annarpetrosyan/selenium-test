import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTest {
    private ChromeDriver driver;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void friendRequestForDB(){
        String firstNameLastName = "Anna R. Petrosyan";
        driver.get("https://fb.com");
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("loginbutton")).click();
        driver.findElement(By.className("layerCancel")).click();
        driver.findElement(By.className("_1frb")).sendKeys(firstNameLastName);
        driver.findElement(By.className("_19bk")).click();

        driver.findElement(By.className("_52eh")).click();
        driver.findElement(By.className("FriendRequestAdd")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
