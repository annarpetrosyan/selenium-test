import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
   private ChromeDriver driver;

   @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.get("https://the-internet.herokuapp.com/login");

   }
/*
Check validation message's existing state when we fill invalid username/password
 */
    @Test
    public void checkValidationMessage(){
        String validationMessage = "Your username is invalid!";
        driver.findElement(By.id("username")).sendKeys("invalidUsername");
        driver.findElement(By.id("password")).sendKeys("invalidPassword!");
        driver.findElement(By.cssSelector("#login button")).click();
        assertEquals(driver.findElement(By.id("flash")).getText(),validationMessage);
    }

/*
Login and check success loginned state
 */
   @Test
    public void login(){
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    driver.findElement(By.cssSelector("#login button")).click();
    assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed(),"Login was not success");
   }

    /*
 Login and check success loginned state
  */
    @Test
    public void urlAssertion(){
        final String expectedUrl = "https://the-internet.herokuapp.com/secure";
         driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("#login button")).click();
        assertEquals(driver.getCurrentUrl(),expectedUrl);

    }


   @AfterMethod
    public void tearDown(){
       driver.close();
       driver.quit();
    }
}
