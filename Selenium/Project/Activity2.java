package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    WebElement Username,password, image,login;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        String title = driver.getTitle();

        image=driver.findElement(By.tagName("img"));
        Thread.sleep(3000);
        String link= image.getAttribute("href");
        System.out.println("href values: "+link);
//        System.out.println("Title of the page " + driver.getTitle());
        Assert.assertEquals(link, "http://www.orangehrm.com/");
    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.close();
//    }
}
