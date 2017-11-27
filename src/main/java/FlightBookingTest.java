import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends GenericLibrary{
    public void testThatResultsAppearForAOneWayJourney(WebDriver driver) {
    	try {
	        driver.get("https://www.cleartrip.com/");
	        waitFor(2000);
	        driver.findElement(By.id("OneWay")).click();
	        driver.findElement(By.id("FromTag")).clear();
	        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
	
	        //wait for the auto complete options to appear for the origin
	        waitFor(2000);
	        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
	        originOptions.get(0).click();
	
	        waitFor(2000);
	        driver.findElement(By.id("ToTag")).clear();
	        driver.findElement(By.id("ToTag")).sendKeys("Delhi");
	
	        //wait for the auto complete options to appear for the destination
	
	        waitFor(2000);
	        //select the first item from the destination auto complete list
	        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
	        destinationOptions.get(0).click();
	
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody//tr[td[a[@class=\"ui-state-default ui-state-highlight ui-state-active \"]]]/following-sibling::tr//td[1]//a")).click();
	
	        //all fields filled in. Now click on search
	        driver.findElement(By.id("SearchBtn")).click();
	
	        waitFor(5000);
	        //verify that result appears for the provided journey search
	        Assert.assertTrue(isElementPresent(driver,By.className("searchSummary")));	
    	}catch (Exception e) {
    		e.printStackTrace();		
    		}

    }

}
