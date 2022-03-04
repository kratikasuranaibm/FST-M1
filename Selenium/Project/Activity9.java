package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
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
                if (menu.get(i).getText().equalsIgnoreCase("Emergency Contacts")) {

                        menu.get(i).click();
                        System.out.println("clicked");

                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        WebElement table= driver.findElement(By.id("emgcontact_list"));
        List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
        List<WebElement> cols= driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        List<WebElement> header=  driver.findElements(By.xpath("//table/thead"));
        int rowNum = rows.size();
        int colNum = cols.size();
        for(int i=0; i<header.size(); i++){
            System.out.println(header.get(i).getText());
        }
        for(int i=0; i<rowNum; i++){

            List<WebElement> colVals = rows.get(i).findElements(By.tagName("td"));

            for(int j=0; j<colNum; j++){

                System.out.print(colVals.get(j).getText()+"  ");
            }

        }
    }
}

