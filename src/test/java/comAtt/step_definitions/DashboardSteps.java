package comAtt.step_definitions;

import comAtt.Utils.WebElementUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardSteps {
    private final WebDriver driver;

    public DashboardSteps(Hooks hooks) {
        this.driver = hooks.getDriver();  // Get the driver from hooks
    }

    @Then("User verifies Teacher DashboardCard")
    public void user_verifies_teacher_dashboard_card() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use XPath to find the element directly by class and exact text
        WebElement teacherStatsCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'flex-column') and contains(@class, 'col-6')]//div[contains(text(), 'Teacher')]")
        ));

        // Assert that the element is displayed
        Assert.assertTrue("Teacher Stats Card is not present.", teacherStatsCard.isDisplayed());
        System.out.println("Teacher Stats Card is present.");
    }

    @Then("User verifies {string} DashboardCard on the DashboardPage")
    public void userVerifiesDashboardCardOnTheDashboardPage(String cartTitle) {

        WebElement statCard = WebElementUtils.waitForElementToBeVisible(driver,By.xpath("//div[contains(@class,'flex-column col-6')]//div[contains(text(),'"+cartTitle+"')]"));
        Assert.assertTrue(cartTitle+"Stats Card is not present",statCard.isDisplayed());
        System.out.println(statCard.getText());
    }
}
