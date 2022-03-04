package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {
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
        WebElement My_info= driver.findElement(By.id("menu_pim_viewMyDetails"));
        My_info.click();
        List<WebElement> menu = driver.findElements(By.xpath("//ul[@id='sidenav']/li"));
        System.out.println("size of menu:" + menu.size());

        for (int i = 0; i < menu.size(); i++) {
            try {
                if (menu.get(i).getText().equalsIgnoreCase("Qualifications")) {
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
        Thread.sleep(3000);
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Software Tester");
        WebElement from= driver.findElement(By.id("experience_from_date"));
            from.clear();
       from.sendKeys("2020-05-03");
        WebElement to=driver.findElement(By.id("experience_to_date"));
        to.clear();
               to.sendKeys("2021-01-01");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }

}
