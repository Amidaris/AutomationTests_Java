Feature: New addresses creation

  Scenario Outline: User can create an addresses
    Given I'm on a shop main page
    When I want to log in
    And I log in
    Then I check my addresses
    And I create new addresses
    And I enter alias <alias> address <address> city <city> postcode <postcode> phone <phone>
    And I submit new address
    And I verify created alias <alias> address <address> city <city> postcode <postcode> phone <phone>
    And I delete new address
    Then I check the new address was successfully deleted
    And I close browser
    Examples:
      | alias  | address   | city     | postcode | phone     |
      | domowy | Milowicka | Katowice | 00-500   | 123456789 |

