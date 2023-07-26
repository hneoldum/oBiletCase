package PageObjectModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class BookingFlightsPage extends BasePage {

    private WebDriver driver;

    String amount;
    public BookingFlightsPage() {
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void navigateToWebsite(){

        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.obilet.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickElement(driver.findElement(By.xpath("//a[@class='close']")));
    }

    public void clickTab(String tabName){
        clickElement(driver.findElement(By.xpath("//a[@data-event-action='"+tabName+"']")));
        waitUntilVisible(driver.findElement(By.xpath("//li[@class=' selected ']//a[@data-event-action='"+tabName+"']")));

    }
    public void clickOneWayChecbox(){

        clickElement(driver.findElement(By.id("one-way")));

    }
    public void typeDepartureCity(String departureCity){
        clickElement(driver.findElement(By.id("origin-input")));
        sendKeys(driver.findElement(By.id("origin-input")),departureCity);
        waitUntilVisible(driver.findElement(By.xpath("//*[@id='origin']//div[@class='results']//..//span[contains(text(),'"+departureCity+"')]")));
        clickElement(driver.findElement(By.xpath("//li[@class='item highlighted']")));
    }
    public void typeDestinationCity(String destinationCity){
        clickElement(driver.findElement(By.id("destination-input")));
        sendKeys(driver.findElement(By.id("destination-input")),destinationCity);
        waitUntilVisible(driver.findElement(By.xpath("//*[@id='destination']//div[@class='results']//..//span[contains(text(),'"+destinationCity+"')]")));
        clickElement(driver.findElement(By.xpath("//li[@class='item highlighted']")));
    }
    public void selectDate(String dateType, String date)  throws org.openqa.selenium.NoSuchElementException {
        HashMap<String,String> map = new HashMap();

        map.put("01", "January");
        map.put("02", "February");
        map.put("03", "March");
        map.put("04", "April");
        map.put("05", "May");
        map.put("06", "June");
        map.put("07", "July");
        map.put("08", "August");
        map.put("09", "September");
        map.put("10", "October");
        map.put("11", "November");
        map.put("12", "December");

        if (date.equals("") || dateType.equals("")) {
            Assert.fail("Date or Date Type is Empty");

        } else {

            if (dateType.equals("Return")){

                String[] tmp =date.split("-");
                String month=tmp[1];
                String year=tmp[0];
                String monthName=map.get(month);
                clickElement(driver.findElement(By.id("return-input")));
                String monthYear=monthName+" "+year;
                String UItext=driver.findElement(By.xpath("(//*[@id=\"return\"]//th[@class='current'])[1]")).getText();
                int a=0;

                while (!UItext.contains(monthYear) && a<10){
                    a++;
                    clickElement(driver.findElement(By.xpath("(//th[@class='next'])[2]")));
                    UItext=driver.findElement(By.xpath("(//*[@id=\"return\"]//th[@class='current'])[1]")).getText();
                }
                clickElement(driver.findElement(By.xpath("//*[@data-date='"+date+"']")));

            } else if(dateType.equals("Departure")){

            String[] tmp =date.split("-");
            String month=tmp[1];
            String year=tmp[0];
            String monthName=map.get(month);
            clickElement(driver.findElement(By.id("departure-input")));
            String monthYear=monthName+" "+year;
            String UItext=driver.findElement(By.xpath("(//*[@id=\"departure\"]//th[@class='current'])[1]")).getText();
            int a=0;

            while (!UItext.contains(monthYear) && a<10){
                a++;
                clickElement(driver.findElement(By.xpath("(//th[@class='next'])[2]")));
                UItext=driver.findElement(By.xpath("(//*[@id=\"departure\"]//th[@class='current'])[1]")).getText();
            }
            clickElement(driver.findElement(By.xpath("//*[@data-date='"+date+"']")));
            }else {
                Assert.fail("incompatible date type");
            }
            }
        }
        public void clickSearchButton(){
        waitUntilVisible(driver.findElement(By.id("search-button")));
        clickElementJS(By.id("search-button"));
        }
        public void verifytheSearchPage(){
        waitUntilElementInvisible(By.xpath("//img[@alt='flight']"));
        waitUntilVisible(driver.findElement(By.id("sorting")));
        }

        public String selectARandomFlight(String flightType){
        amount = "";
        if (flightType.equals("Departure")){
            Random random = new Random();
            List<WebElement> flights = findElements(By.xpath("//ul[@id='outbound-journeys']//div[@class='journey row']"));
            int rand = random.nextInt(flights.size());
            System.out.println("random : "+rand);
            flights.get(rand).click();

            amount=driver.findElement(By.xpath("(//div[@class='journey row'])["+rand+"]//span[@class='amount-integer']")).getText();
            System.out.println("amount if "+amount);
        } else if(flightType.equals("Return")){
            Random random = new Random();
            List<WebElement> flights = findElements(By.xpath("//ul[@id='return-journeys']//div[@class='journey row']"));
            int rand = random.nextInt(flights.size());
            System.out.println("random : "+rand);
            flights.get(rand).click();
            amount=driver.findElement(By.xpath("(//ul[@id=\"return-journeys\"]//div[@class='journey row'])["+rand+"]//span[@class=\"amount-integer\"]")).getText();

        }
        else {
            Assert.fail(" Invalid Flight Type");
        }


        return amount;

    }
        public void clickTheOffer () throws org.openqa.selenium.NoSuchElementException{
        WebElement element  = null;

        try {
            waitUntilElementInvisible(By.xpath("//img[@alt='flight']"));
            element= driver.findElement(By.xpath("//ul[@class='flys']"));
        } catch(NoSuchElementException e){
            }

            if (element!=null){
                //ecofly
                waitUntilVisible(driver.findElement(By.xpath("//div[@class='top-green-arrow-container']//span[contains(text(),'"+amount+"')]")));
                clickElement(driver.findElement(By.xpath("//div[@class='top-green-arrow-container']//span[contains(text(),'"+amount+"')]")));
        }


    }
}