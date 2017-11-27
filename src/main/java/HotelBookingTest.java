import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends GenericLibrary{
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;
    
    @FindBy(id="wgSelectChoosen")
    private WebElement LocalityDropdown;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBys(@FindBy(xpath = "//li[@role='presentation']"))
    private List<WebElement> suggestionlist;
    
    @Test
    public void shouldBeAbleToSearchForHotels(WebDriver driver) {
    	try {
    		PageFactory.initElements(driver, this);
	        driver.get("https://www.cleartrip.com/");
	        hotelLink.click();
	        localityTextBox.sendKeys("Indiranagar, Bangalore");
	        suggestionlist.get(0).click();
	        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
	        searchButton.click();
    	}catch (Exception e) {
    		e.printStackTrace();		
    		}
	 }

}
