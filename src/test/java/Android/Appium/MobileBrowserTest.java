package Android.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobilebrowserBase {
	
	@Test
	public void browserTest()
	{
		
		//This is completely browser automation in mobile
		//here selenium has to be used for automation
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("satya");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}

	
}
