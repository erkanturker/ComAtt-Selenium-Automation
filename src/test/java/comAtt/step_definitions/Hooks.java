package comAtt.step_definitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/gulsenzehra/Downloads/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://comattfrontend.onrender.com");
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
