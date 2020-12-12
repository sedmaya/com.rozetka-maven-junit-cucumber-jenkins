@SmokeTest @NegativeTest
Feature: Check the Search feature
  As a potential buyer
  I want to have the possibility to get a feedback regarding me search request
  so that I can get more accurate search results

  Scenario Outline: Check the Search feature with non existing items
    Given I navigate to the rozetka.com.ua URL
    And I enter the "<keywords>" into a search bar
    Then I should see the page with text "ничего не найдено, попробуйте изменить запрос"

    Examples:
      | keywords          |
      | синхрофазотрон    |
      | зілля невидимості |
      | індульгенція      |