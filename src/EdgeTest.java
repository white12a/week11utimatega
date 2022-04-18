import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class EdgeTest {
    public static void main(String[] args) {
        String baseURL="https://courses.ultimateqa.com/users/sign_in";
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");// setting edge driver
        WebDriver driver=new FirefoxDriver();
        driver.get(baseURL);//launch URL
        driver.manage().window().maximize();// maximising the windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// wait
        String title=driver.getTitle();// storing the title
        System.out.println("Title of the page : "+title);// printing the title of the page
        String currentURL=driver.getCurrentUrl();// getting URL of the page
        System.out.println("Current URL of the page is : "+currentURL);// printing the URl of the page
        WebElement userNameField=driver.findElement(By.id("user[password]"));// storing username field
        userNameField.sendKeys("Prime123@gmail;.com");// sending keys to username field
        WebElement passwordField=driver.findElement(By.id("user[password]"));// storing password field
        passwordField.sendKeys("12345");// sending keys to password field
        driver.close();
    }
}
