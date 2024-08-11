package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.DriverUtil;
import pages.LoginPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchSteps {

    private DashboardPage dashboardPage;
    private WebDriver driver;
    private SearchPage searchPage;

    public SearchSteps() {
        driver = DriverUtil.getDriver();
        dashboardPage = new DashboardPage(driver);
        searchPage = new SearchPage(driver);
    }

    @When("user clicks on the Admin tab")
    public void userClicksOnTheAdminTab() {
        dashboardPage.adminPageClick();
    }

    @And("user enters {string} in the search box for find admin users")
    public void userEntersInTheSearchBoxForFindAdminUsers(String username) {
        searchPage.enterUsername(username);
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String buttonName) {
        searchPage.search();
    }

    @Then("user should see the Admin user's details in the search results")
    public void userShouldSeeTheUserSDetailsInTheSearchResults() {
        searchPage.assertSearchResults();
    }

}
