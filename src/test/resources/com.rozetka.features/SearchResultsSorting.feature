@SmokeTest @SearchFeatureTest
Feature: Check Sorting feature
  As a potential buyer
  I want to be able to sort my search results
  so that I can save my time on looking for the best option that meets my expectations and within a budget

  Scenario Outline:
    Given I navigate to the rozetka.com.ua URL
    And I enter the following keywords into a search bar
      | Apple iPhone 12 Pro Max 256GB |

    When I select the sorting "<option>"
    Then I should see the searched item's list sorted in expected "<order>"
    Examples:
      | option               | order      |
      | От дорогих к дешевым | DESCENDING |
      | От дешевых к дорогим | ASCENDING  |