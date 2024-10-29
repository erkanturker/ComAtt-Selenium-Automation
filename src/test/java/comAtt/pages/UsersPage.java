package comAtt.pages;

import comAtt.Utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersPage {
    private WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the Users Page
    private final By usernameInputLocator = By.id("username");
    private final By passwordInputLocator = By.id("password");
    private final By firstNameInputLocator = By.id("firstName");
    private final By lastNameInputLocator = By.id("lastName");
    private final By emailInputLocator = By.id("email");
    private final By roleDropdownLocator = By.id("role");
    private final By submitButtonLocator = By.cssSelector("button[data-testid='submit']");
    private By deleteButtonLocator(String username) {
        return By.xpath("//tr[td[contains(text(), '" + username + "')]]//button[contains(@class, 'btn-danger')]");
    }
    private final By alertTitleLocator = By.cssSelector("div.alert-heading.h4");



    public void fillOutUserForm(String username, String password, String firstName, String lastName, String email, String role) {
        driver.findElement(usernameInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(firstNameInputLocator).sendKeys(firstName);
        driver.findElement(lastNameInputLocator).sendKeys(lastName);
        driver.findElement(emailInputLocator).sendKeys(email);

        // Selecting role from dropdown
        WebElement roleDropdown = driver.findElement(roleDropdownLocator);
        roleDropdown.click();

        driver.findElement(By.xpath("//option[text()='" + role + "']")).click(); // Select role
        driver.findElement(submitButtonLocator).click(); // Click submit
    }

    public void deleteUser(String username){
        WebElement deleteButton = WebElementUtils.waitForElementToBeVisible(driver,deleteButtonLocator(username));
        WebElementUtils.scrollWithJsExecution(driver,deleteButton);
        WebElementUtils.clickWithJsExecution(driver,deleteButton);
    }

    public WebElement getAlertTitleElement(){
        return WebElementUtils.waitForElementToBeVisible(driver,alertTitleLocator);
    }


}
