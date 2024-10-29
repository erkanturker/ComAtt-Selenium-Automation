package comAtt.step_definitions;
import comAtt.pages.DashboardPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardSteps {
    private final DashboardPage dashboardPage;

    public DashboardSteps(Hooks hooks) {
        WebDriver driver = hooks.getDriver();
        this.dashboardPage = new DashboardPage(driver);
    }

    @Then("User verifies {string} DashboardCard on the DashboardPage")
    public void userVerifiesDashboardCardOnTheDashboardPage(String cartTitle) {
        WebElement statCard = dashboardPage.getDashboardCard(cartTitle);
        System.out.println(statCard.getText());
    }
}
