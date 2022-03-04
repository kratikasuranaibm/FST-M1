package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity4 {
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
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Sushma");
        driver.findElement(By.id("lastName")).sendKeys("chinta");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sushma");

        System.out.println("Able to ebter the name");
        List<WebElement> suggestions = driver.findElements(By.className("ac_results"));
        Thread.sleep(3000);

        // print the auto suggest
        for (WebElement a : suggestions) {
            System.out.println("Values are = " + a.getText());
            if (a.getText().equalsIgnoreCase("Sushma")) ;
            a.click();
            Thread.sleep(3000);
            break;
        }
        driver.findElement(By.id("searchBtn")).click();
        WebElement table=driver.findElement(By.id("resultTable"));
        //List allRows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
//        System.out.println("Total data rows found in table:"+ (allRows.size()-1));
 List<WebElement> li=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
//        int size1=li.size();
//        for(int i=0;i<size1;i++)
//        {
//            String name=li.get(i).getText();
//          //  System.out.println(Sushma);
//            if(name.equals("Sushma"))
//            {
//                li.get(i).click();
//            }
//        }
for(int i=0;i<=li.size();i++){
    li.get(i).click();
    break;
     }
        }
}
