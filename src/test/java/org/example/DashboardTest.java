package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardTest {
    private WebDriver driver;

    @Before
    public void setup() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/gulsenzehra/Downloads/driver/chromedriver");

        // Initialize the WebDriver and open the application URL
        driver = new ChromeDriver();
        driver.get("https://comattfrontend.onrender.com");
    }

    @Test
    public void testDashboard() {
        // Log in as admin (update the selectors as necessary)
        driver.findElement(By.id("formBasicUsername")).sendKeys("admin");
        driver.findElement(By.id("formBasicPassword")).sendKeys("12345");
        driver.findElement(By.tagName("button")).click();


        // Get teacher stats
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement h1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        Assert.assertEquals("Dashboard",h1Element.getText());

        /*
         System.out.println("Teacher Stats: " + teacherStatsText);
        Assert.assertNotNull("Teacher stats should not be null", teacherStatsText);

        // Get student stats
        WebElement studentStatsCard = driver.findElement(By.id("studentStatsCard"));
        String studentStatsText = studentStatsCard.getText();
        System.out.println("Student Stats: " + studentStatsText);
        Assert.assertNotNull("Student stats should not be null", studentStatsText);
         */
    }


    @After
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
