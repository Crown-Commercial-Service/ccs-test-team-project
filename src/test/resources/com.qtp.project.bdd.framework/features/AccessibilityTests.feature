Feature: Verify Search Frameworks

  @axe
  Scenario: Verify Search Frameworks
    Given I open browser
    When I am on CCS homepage
    Then I verify accessibility issues
    And I click Search Framework
    And I am on 'agreements' page
    Then I verify accessibility issues










