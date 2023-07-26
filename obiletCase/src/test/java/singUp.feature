Feature: Test
  Scenario: Search Domestic Flight and Passengers
    Given Navigate to Website
    And Click Member Login
    And Click Register Button
    And Type e-mail "tst"
    And Type password "123456"
    And Click Contract Checkbox
    When Click Register Button
    Then Check HomePage