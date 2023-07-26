package stepDefinition;

import PageObjectModel.BookingFlightsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BookingFlightsSteps {

    public BookingFlightsPage bookingFlightsPage = new BookingFlightsPage();

    @Given("Navigate to Website")
    public void navigateToWebsite() {
        bookingFlightsPage.navigateToWebsite();
    }

    @And("Click {string} Tab")
    public void clickTab(String tabName) {
        bookingFlightsPage.clickTab(tabName);
    }
    @And("Click One Way Checkbox")
    public void clickOneWayChecbox() {
        bookingFlightsPage.clickOneWayChecbox();
    }
    @And("Type Departure City {string}")
    public void typeDepartureCity(String departureCity){
        bookingFlightsPage.typeDepartureCity(departureCity);
    }
    @And("Type Destination City {string}")
    public void typeDestinationCity(String destinationCity){
        bookingFlightsPage.typeDestinationCity(destinationCity);
    }
    @And("Select {string} Date {string}")
    public void selecteDate(String dateType,String date){
        bookingFlightsPage.selectDate(dateType,date);
    }
    @When("Click Search Button")
    public void clickSearchButton()
    {bookingFlightsPage.clickSearchButton();
    }

    @When("Verify the Search Page")
    public void verifytheSearchPage()
    {bookingFlightsPage.verifytheSearchPage();
    }


    @When("Select A {string} Random Flight")
    public void selectARandomFlight(String flightType)
    {bookingFlightsPage.selectARandomFlight(flightType);
    }

    @When("Click The Offer")
    public void clickTheOffer()
    {bookingFlightsPage.clickTheOffer();
    }


}
