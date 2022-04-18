import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseURL = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("not valid browser");
        }
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
