Feature: Verify Search Frameworks

  @searchFramework
  Scenario: Verify Search Frameworks
    Given I open browser
    And  I am on CCS homepage
    When I click Search Framework
    Then I am on 'agreements' page
    When I search 'Energy' Framework






