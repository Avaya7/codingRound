import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends GenericLibrary{
	
    public void shouldThrowAnErrorIfSignInDetailsAreMissing(WebDriver driver) {
    	try {
		        driver.get("https://www.cleartrip.com/");
		        waitFor(2000);
		        driver.findElement(By.linkText("Your trips")).click();
		        driver.findElement(By.id("SignIn")).click();
		        waitFor(2000);
		        switchtoframe(driver, "modal_window");// swicth to frame to access the web elements
		        driver.findElement(By.id("signInButton")).click();
		        String errors1 = driver.findElement(By.id("errors1")).getText();
		        Assert.assertTrue(errors1.contains("There were errors in your submission"));
		        switchtodefaultWindow(driver);
		        
    	}catch (Exception e) {
    		e.printStackTrace();
    		}
    }

}
