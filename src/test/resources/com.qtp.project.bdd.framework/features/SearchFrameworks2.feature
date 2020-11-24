Feature: Verify Search  - Finance and legal

  @Finance
  Scenario: Verify Search Finance Frameworks
    Given I open browser
    And  I am on CCS homepage
    When I click Search Framework
    When I search 'finance' Framework

  @legal @reg
  Scenario: Verify Search legal Frameworks
    Given I open browser
    And  I am on CCS homepage
    When I click Search Framework
    Then I am on 'agreements' page
    When I search 'legal' Framework



