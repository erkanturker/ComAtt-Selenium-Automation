package comAtt.step_definitions;

import comAtt.Utils.WebElementUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class UsersPageSteps {
    private final WebDriver driver;

    public UsersPageSteps(Hooks hooks){
        this.driver = hooks.getDriver();
    }

    @When("User fills out the form to create a new user")
    public void user_fills_out_the_form_to_create_a_new_user() {
        driver.findElement(By.id("username")).sendKeys("testUsername");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("firstName")).sendKeys("testFirstName");
        driver.findElement(By.id("lastName")).sendKeys("testLastName");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        Select dropdown = new Select(driver.findElement(By.id("role")));
        dropdown.selectByVisibleText("Teacher");
        this.driver.findElement(By.cssSelector("button[data-testid='submit']")).click();
    }

    @When("User locates the delete button associated with the username")
    public void user_locates_the_delete_button_associated_with_the_username() {
        WebElement deleteButton = WebElementUtils.waitForElementToBeVisible(driver,By.xpath("//tr[td[contains(text(),\"testUsername\")]]//button"));
       WebElementUtils.scrollWithJsExecution(driver,deleteButton);
       WebElementUtils.clickWithJsExecution(driver,deleteButton);

    }

    @Then("verifies that the alert title is {string}")
    public void verifies_that_the_alert_title_is(String expectedTitle) {
        WebElement alertTitle = WebElementUtils.waitForElementToBeVisible(driver,By.cssSelector("div.alert-heading.h4"));
        Assert.assertEquals(expectedTitle,alertTitle.getText());
    }
}
