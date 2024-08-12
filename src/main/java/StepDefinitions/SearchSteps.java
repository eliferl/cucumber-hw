package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utils.DriverUtil;
import pages.SearchPage;

public class SearchSteps {

    private final DashboardPage dashboardPage;
    private final WebDriver driver;
    private final SearchPage searchPage;

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

    @Then("user should see {string} in the search results")
    public void userShouldSeeInTheSearchResults(String toasterText) {
        searchPage.assertToaster(toasterText);
    }

    @Then("user leaves the {string} field empty")
    public void userLeavesTheFieldEmpty(String arg0) {
        searchPage.search();
    }

    @Then("user should see a list of all users")
    public void userShouldSeeAListOfAllUsers() {
        searchPage.assertUserTable();
    }

}
