package comAtt.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonSteps {
    private final WebDriver driver;
    final Hooks hooks;

    public CommonSteps(Hooks hooks) {
        this.hooks = hooks;
        driver = hooks.getDriver();
    }

    @Given("User logs in to the system")
    public void user_logs_in_to_the_system() {
        driver.findElement(By.id("formBasicUsername")).sendKeys("admin");
        driver.findElement(By.id("formBasicPassword")).sendKeys("12345");
        driver.findElement(By.tagName("button")).click();
    }

    @Then("User verifies the dashboard title is {string}")
    public void user_verifies_the_dashboard_title_is(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement h1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        Assert.assertEquals(expectedTitle,h1Element.getText());
    }

    @When("User navigates to {string} page")
    public void user_navigates_to_page(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        link.click();
    }

}
