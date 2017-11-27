import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.javafx.PlatformUtil;

public class driver {
	 WebDriver driver=null;
	 public enum typeOfBrowser{
			firefox, chrome, internetexplorer
		}
	 
	@BeforeMethod
	@Parameters ({"Browser"})
	public void setDriverPath(String Broswer) {        
        //code for browser settings
        switch (typeOfBrowser.valueOf(Broswer)) {
		case firefox:
			//code for firefox driver
			break;
		case chrome:
			if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver");
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "E:\\testVagrant\\codingRound\\chromedriver.exe");
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	        }
	        
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			break;

		default:
			;
		}
		
    }
	
	@AfterMethod
	public void CloseSetUP() {
		driver.close();
		//driver.quit();
    }
	 
	 
	@Test
	public void FlightBooking() {
		FlightBookingTest fb=new FlightBookingTest();
		fb.testThatResultsAppearForAOneWayJourney(driver);		
		
	}
	@Test
	public void HotelBooking() {
		HotelBookingTest hb=new HotelBookingTest();
		hb.shouldBeAbleToSearchForHotels(driver);		
		
	}
	@Test
	public void Signin() {
		SignInTest st=new SignInTest();
		st.shouldThrowAnErrorIfSignInDetailsAreMissing(driver);		
		
	}
	
	
	
	

}
