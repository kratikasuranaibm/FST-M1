package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
    WebDriver driver;
    WebElement Username, password, login;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        String title = driver.getTitle();
        Username = driver.findElement(By.id("txtUsername"));
        Username.sendKeys("Orange");

        password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");
        login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(3000);
        WebElement Apply_leave = driver.findElement(By.xpath("//span[text()='Apply Leave']"));
        Apply_leave.click();
    }
}
