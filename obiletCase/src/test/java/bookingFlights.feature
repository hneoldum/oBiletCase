Feature: Test
  Scenario: Search Domestic Flight and Passengers

    Given Navigate to Website
    And Click "Flight" Tab
    And Click One Way Checkbox
    And Type Departure City "Adana"
    And Type Destination City "Izmir"
    And Select "Departure" Date "2023-07-21"
    And Select "Return" Date "2023-08-21"
    And Click Search Button
    And Verify the Search Page
    And Select A "Departure" Random Flight
    And Click The Offer
    And Select A "Return" Random Flight
    When Click The Offer
   # Then Verify Flights Info
