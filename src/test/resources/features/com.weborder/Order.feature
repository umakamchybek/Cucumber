Feature: WEbOrder Page Food Order

  Background:
    Given the user is on weborder homepage
    When the user selects "Office" option
    And the user is on the groupOrderPage
    And the user sends invitees note "Test"
    And the user sends invite list "uma@gmail.com" and "eric@gmail.com"
  Scenario: Validation of Food Order For Office
#    //Given the user is on weborder homepage
#    When the user selects "Office" option
#    And the user is on the groupOrderPage
#    And the user sends invitees note "Test"
#    And the user sends invite list "uma@gmail.com" and "eric@gmail.com"
    Then  the user validates the "2012 EMPIRE BLVD" adress
    * the user validates "View Group Order" text
    * the user validates total participants is 1

  Scenario: Validation of Food Order For My House
#    //Given the user is on weborder homepage
#    When the user selects "Office" option
#    And the user is on the groupOrderPage
#    And the user sends invitees note "Test"
#    And the user sends invite list "uma@gmail.com" and "eric@gmail.com"
    And  the user selects "My House" option
    Then  the user validates the "2112 EMPIRE BLVD" adress
    * the user validates "View Group Order" text
    * the user validates total participants is 1