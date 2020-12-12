@SmokeTest @AddToCartFeatureTest
Feature: Check the cart's feature
  As a potential buyer
  I want to have the possibility to review before checkout the item added to the cart
  so that to prevent a wrong item to be added to a cart

  Background:
    Given I navigate to the rozetka.com.ua URL
    And I enter the following keywords into a search bar
      | Apple iPhone 12 Pro Max 256GB |
    When I click on the very first item in the search results list

  Scenario: Check the Cart's Pop Up window appearance
    And I click on the Buy button
    Then I should see the cart's pop up window
