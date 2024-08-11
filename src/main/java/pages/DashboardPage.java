package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    private WebElement adminWebElement;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void userInDashboard() {
        Assert.assertEquals(dashboardTitle.getText(), "Dashboard");
    }

    public void adminPageClick() {
        adminWebElement.click();
    }
}
