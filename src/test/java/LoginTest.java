import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
   private ChromeDriver driver;

   @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   }

   @Test
    public void login(){
    driver.get("https://the-internet.herokuapp.com/login");
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//  driver.findElement(By.cssSelector("#login > button")).click();
    driver.findElement(By.cssSelector("#login button")).click();


    assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed(),"Login was not success");

   }

   @AfterMethod
    public void tearDown(){
       driver.close();
       driver.quit();
    }
}
