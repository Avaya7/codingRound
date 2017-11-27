/****************************************************************************************************************************************************
 * 														Generic Library																				* 
 *																																					* 
 * *************************************************************************************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GenericLibrary {
		
	/****************************************************************************************************************************************************
	 * 					waitFor() waits for the element for particular time periods given as input 														* 
	 *																																					* 
	 * *************************************************************************************************************************************************/
	protected void waitFor(int durationInMilliSeconds) {
	        try {
	            Thread.sleep(durationInMilliSeconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }
	    }

	/****************************************************************************************************************************************************
	 * 					isElementPresent() Check if the element is present or not and return boolean value												* 
	 *																																					* 
	 ****************************************************************************************************************************************************/
	  protected boolean isElementPresent(WebDriver driver,By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	 /****************************************************************************************************************************************************
	  * 					switchtoframe() used to switch to frame based on the frame name as Parameter	   											 * 
	  *																																					 * 
	  ****************************************************************************************************************************************************/
	  protected void switchtoframe(WebDriver driver,String frame_name) {
		driver.switchTo().frame(frame_name);
	 	}
	  
	  /****************************************************************************************************************************************************
	   * 					switchtodefaultWindow() is used to come back to the default frame/window													  * 
	   *																																				  * 
	   ****************************************************************************************************************************************************/
	  protected void switchtodefaultWindow(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
}
