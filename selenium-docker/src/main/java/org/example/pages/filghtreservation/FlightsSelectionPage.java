package org.example.pages.filghtreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed() ;
    }

    public void selectFlights(){
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightsOptions.size());
        this.departureFlightsOptions.get(random).click();
        this.arrivalFlightsOptions.get(random).click();
    }

    public void confirmFlights(){
//        wait.until(ExpectedConditions.elementToBeClickable(this.confirmFlightsButton)).click();

        // Wait for the element to be visible and clickable
        wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmFlightsButton));

        // Scroll to the element to ensure it's in view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.confirmFlightsButton);

        // Click the element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.confirmFlightsButton);
    }

}