package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.DriverUtil;
import pages.LoginPage;

public class LoginSteps {

    public WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public LoginSteps() {
        driver = DriverUtil.getDriver();
        dashboardPage = new DashboardPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("user visits the websites")
    public void user_visits_the_websites() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.doLogin(username, password);
    }

    @Then("user can view the dashboard page")
    public void user_can_view_the_dashboard_page() {
        dashboardPage.userInDashboard();
    }

    @Then("browser closes")
    public void browser_closes() {
        driver.quit();
    }

    @Then("user can't view the dashboard page")
    public void userCanTViewTheDashboardPage() {
        loginPage.assertingErrorMessage();
    }
}
