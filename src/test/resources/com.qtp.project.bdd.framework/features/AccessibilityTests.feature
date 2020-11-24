Feature: axe tests

  @axe @reg
  Scenario: Verify axe
    Given I open browser
    When I am on CCS homepage
    Then I verify accessibility issues
    And I click Search Framework
    And I am on 'agreements' page
    Then I verify accessibility issues











