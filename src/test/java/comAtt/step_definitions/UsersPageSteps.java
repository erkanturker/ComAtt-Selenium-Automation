package comAtt.step_definitions;

import comAtt.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UsersPageSteps {
    private final UsersPage usersPage;

    public UsersPageSteps(Hooks hooks){
        WebDriver driver = hooks.getDriver();
        this.usersPage = new UsersPage(driver);
    }

    @When("User fills out the form to create a new user")
    public void user_fills_out_the_form_to_create_a_new_user() {
        usersPage.fillOutUserForm("testUsername","12345","testFirstName","testLastName","test@gmail.com","Teacher");
    }

    @When("User locates the delete button associated with the username")
    public void user_locates_the_delete_button_associated_with_the_username() {
        usersPage.deleteUser("testUsername");
    }

    @Then("verifies that the alert title is {string}")
    public void verifies_that_the_alert_title_is(String expectedTitle) {
        WebElement alertTitle = usersPage.getAlertTitleElement();
        Assert.assertEquals(expectedTitle,alertTitle.getText());
    }
}
