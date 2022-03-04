package Java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity05_1 {
    public static void main(String[] args) {

       WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title : "+driver.getTitle());
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("checkbox Input is displayed: " + checkboxInput.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        System.out.println("Checkbox Input is displayed: " + checkboxInput.isDisplayed());

        driver.close();
    }
}
