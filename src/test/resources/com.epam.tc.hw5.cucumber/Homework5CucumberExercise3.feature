Feature: Exercise 3. Vip checkbox is selected on User Table page
  Scenario: Vip checkbox is selected on User Table page
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in the row section