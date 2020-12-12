@SmokeTest @SearchFeatureTest
Feature: Check the search feature
  As a potential buyer
  I want to have the possibility to get appropriate search results
  so that to save my time spent on online shopping

  Background:
    Given I navigate to the rozetka.com.ua URL
    And I enter the following keywords into a search bar
      | Apple iPhone 12 Pro Max 256GB |


  Scenario: Verify the query's keywords presence in the search results page
    And I see the list of searched item that contain the following keywords
      | Apple iPhone 12 Pro Max 256GB |


  Scenario: Verify the query's keywords presence in the searched item's PDP title
    When I click on the very first item in the search results list
    Then I should see the searched following keywords in a PDP heading
      | Apple iPhone 12 Pro Max 256GB |