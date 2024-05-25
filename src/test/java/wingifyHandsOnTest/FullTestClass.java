package wingifyHandsOnTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullTestClass {

	WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sakshingp.github.io/assignment/login.html");
    }

    @Test(enabled=true)
    public void testSuccessfulLogin() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("log-in"));

        usernameField.sendKeys("ankita");
        passwordField.sendKeys("testpassword");
        loginButton.click();
        Thread.sleep(4000);
      
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }
    @Test(enabled=false)
    public void testEmptyUsername() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("log-in"));

        loginButton.click();
Thread.sleep(4000);
      
        WebElement errorMessage = driver.findElement(By.id("random_id_2"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Username must be present");
    }
    @Test(enabled=false)
    public void testEmptyPassword() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement loginButton = driver.findElement(By.id("log-in"));

        usernameField.sendKeys("testuser");
        loginButton.click();

        
        WebElement errorMessage = driver.findElement(By.id("random_id_8"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Password must be present");
    }
    
    @Test(enabled = true)
    public void testAmountSorting() throws InterruptedException {
        WebElement amountHeader = driver.findElement(By.id("amount"));
        amountHeader.click();
         Thread.sleep(5000);
      
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

