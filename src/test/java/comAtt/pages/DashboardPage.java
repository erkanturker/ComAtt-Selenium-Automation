package comAtt.pages;

import comAtt.Utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getDashboardCard(String cardTitle) {
        return WebElementUtils.waitForElementToBeVisible(this.driver,By.xpath("//div[contains(@class,'flex-column col-6')]//div[contains(text(),'"+cardTitle+"')]"));
    }
}
