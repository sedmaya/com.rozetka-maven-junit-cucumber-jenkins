Feature: Check the Sign Up feature
  As a unregistered user
  I want to get hints regarding invalid/no data in the Sign Up form's fields
  so that my registration to be successfully completed

  Scenario Outline: Verify a warning message feature with empty required field
    Given I navigate to the rozetka.com.ua URL
    And I click on the "войдите в личный кабинет" button
    And I click on the "Зарегистрироваться" link
    When I enter the "<name>" into the Sign Up's "name" field with "Фамилия" label
    And I enter the "<last name>" into the Sign Up's "name" field with "Имя" label
    And I enter the "<invalid email>" into the Sign Up's "contact" field with "Эл. почта или телефон" label
    Then I should see the warning message "Введите свою эл. почту или телефон" under the "contact" field

    Examples:
      | name | last name | invalid email |
      | Марь | Ванна     | 123456789     |




