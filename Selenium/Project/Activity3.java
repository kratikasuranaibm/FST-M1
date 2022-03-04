package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    WebElement Username,password,login;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void exampleTestCase() {
        String title = driver.getTitle();
        Username=driver.findElement(By.id("txtUsername"));
        Username.sendKeys("Orange");

        password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");
        login=driver.findElement(By.id("btnLogin"));
        login.click();
        System.out.println("Title of the page " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
