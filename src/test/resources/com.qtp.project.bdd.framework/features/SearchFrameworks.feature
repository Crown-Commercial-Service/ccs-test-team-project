Feature: Verify Search Frameworks- Energy and cctv

  @Energy @reg
  Scenario: Verify Search Energy Frameworks
    Given I open browser
    And  I am on CCS homepage
    When I click Search Framework
    When I search 'Energy' Framework

  @cctv
  Scenario: Verify Search cctv Frameworks
    Given I open browser
    And  I am on CCS homepage
    When I click Search Framework
    Then I am on 'agreements' page
    When I search 'cctv' Framework



