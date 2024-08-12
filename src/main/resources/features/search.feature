Feature: Search

  Scenario Outline: Search admin with username
    Given user visits the websites
    When user enter username "<username>" and password "<password>"
    Then user can view the dashboard page
    When user clicks on the Admin tab
    Then user enters "<username>" in the search box for find admin users
    And clicks the "Search" button
    Then user should see the Admin user's details in the search results
    And browser closes
    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline: Search with an Invalid Username
    Given user visits the websites
    When user enter username "<username>" and password "<password>"
    Then user can view the dashboard page
    When user clicks on the Admin tab
    Then user enters "InvalidUser" in the search box for find admin users
    And clicks the "Search" button
    Then user should see "Info No Records Found" in the search results
    And browser closes
    Examples:
      | username | password |
      | Admin    | admin123 |
