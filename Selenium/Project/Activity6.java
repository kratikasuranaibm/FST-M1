package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity6 {
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
        // WebDriverWait wait=new WebDriverWait(driver,20);
        Thread.sleep(4000);
        List<WebElement> menu = driver.findElements(By.xpath("//div[@class='menu']/ul/li"));
        System.out.println("size of menu:" + menu.size());

        for (int i = 0; i < menu.size(); i++) {
            try {
                if (menu.get(i).getText().equalsIgnoreCase("Directory")) {
                    if (menu.get(i).isDisplayed()) {
                        menu.get(i).click();
                        System.out.println("clicked");
                    }
                }
            }
            catch(Exception e){
              System.out.println(e.getMessage());
            }

        }
      String page_heading=  driver.findElement(By.xpath("//div[@class='head']")).getText();
        Assert.assertEquals(page_heading,"Search Directory");
    }
}

