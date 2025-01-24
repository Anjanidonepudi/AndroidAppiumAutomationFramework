package Android.Appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppiumLocators extends BaseTest {
	
	@Test
	public void wifiSettingmethod()
	
	{
		//Appium Locators are Id,xpath,className,accessiblityId, androidUIAutomator
		
		//click on Preferences option using accessiblityId
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//Click on Preference Dependencies using xpath
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		//click on wifi checkbox using Id
		driver.findElement(By.id("android:id/checkbox")).click();
		//To rotate device from NormalPotrait mode to Landscape mode use DeviceRotation class and give co-ordinate as 90
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		//click on Wifi settings option using tagname as xpath is too long and it doesnt have accessibilityId.But Wifi and Wifi settings both have same tagNames hence using tagName derive xpath and locate the element desired through index
		driver.findElement(By.xpath("//android.widget.RelativeLayout[2]")).click();
		//Grab Wifi Settings title and assert
		String actualAlertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualAlertTitle, "Wifi Settings");
		//pass text for wifi settings box
		driver.findElement(By.id("android:id/edit")).sendKeys("Satya");
		
		/* ----or we can use setclipboartext to copy text to clipboard from somewhere and get the text from it-----
		 * driver.setClipboardText("Satya");
		 * driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		 */
		//click on "Ok" button.But "Cancel" and "ok" button has same className, henece grab all the elements using that ClassName and click on desired one using index
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
 

		
		
		
	}

}
