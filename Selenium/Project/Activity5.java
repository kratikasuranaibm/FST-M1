package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity5 {
    WebDriver driver;
    WebElement Username,password,login;

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
        WebElement My_info= driver.findElement(By.id("menu_pim_viewMyDetails"));
        My_info.click();
        WebElement edit_btn= driver.findElement(By.id("btnSave"));
        edit_btn.click();
        WebElement First_Name= driver.findElement(By.id("personal_txtEmpFirstName"));
        First_Name.clear();
        First_Name.sendKeys("Selenium");
        Thread.sleep(3000);
        WebElement Last_name= driver.findElement(By.id("personal_txtEmpLastName"));
        Last_name.clear();
        Last_name.sendKeys("Selenium");
        WebElement gender= driver.findElement(By.id("personal_optGender_2"));
        gender.click();
        WebElement DOB= driver.findElement(By.id("personal_DOB"));
       DOB.clear();
       DOB.sendKeys("1994-01-01");
Select s = new Select(driver.findElement(By.id("personal_cmbNation")));
s.selectByVisibleText("Indian");
driver.findElement(By.id("btnSave")).click();
    }
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
