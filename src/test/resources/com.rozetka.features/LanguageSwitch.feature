Feature: Check the internationalization feature
  As a buyer with the patriotic mind
  I want to have the possibility to switch the content's language
  so that I can feel more cozy while on site

  Scenario: Verify UA language switch feature
    Given I navigate to the rozetka.com.ua URL
    When I click on "UA" link
    Then I should see the URL "https://rozetka.com.ua/ua/"
    And I should see "Я шукаю..." text in a Search Bar's placeholder
