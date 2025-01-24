package Android.Appium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;

public class CartScenario extends BaseTest {
	
	
	
	@Test
	public void addItemsToCart() throws InterruptedException
	{
		//Enter name in Inputbox
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Satya");
		/*
		 * if we dont enter name and click on "Let's shop, will get Toast message, by default we cant handle it as we wont get locator details for that
		 * Developer compulsory has to use "android.widget.Toast" tag to define any Toast messages so inspect using that tag and to check for text of toast message, we cant grab text, but it will be having default "name" attribute so getname attribute to grab text
		 * If page having mutiple messages inspect using index
		 * String toastmsg=driver.findElement(By.xpath("android.widget.Toast[1]")).getAttribute("name");
		 * Assert.assertEquals(toastmsg,"please enter your name");
		 * 
		 */
		
		//To hidekeyboard after typing
		
		driver.hideKeyboard();
		
		//Inspect Female option and click that radio button using xpath
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		//click on country dropdown
		driver.findElement(By.id("android:id/text1")).click();
		//scroll to "Argentina"text using utility defined at MobileGestures
		
		MobileGestures MobileGestures = new MobileGestures(driver);
		MobileGestures.scrollToText("Argentina");
		//Then Click on Argentina option
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		//click on Let's shop button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(5000);
		
		MobileGestures.scrollToText("Air Jordan 9 Retro");
		
		//Toselect Add to Cart button based on product Name, grab all products and then iterate and grab each productname while iterating and verify across Air Jordan 9 Retro, if matches then click on "Add to cart" for that
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++)
		{
			String Productname= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(Productname.equalsIgnoreCase("Air Jordan 9 Retro"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		//wait for cartpage to be loaded, as id is same for Productpage and cardpage grabattribute for the element and check for title
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String Producttextaddedtocart= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(Producttextaddedtocart, "Air Jordan 9 Retro");
		
		Thread.sleep(5000);
		//select checkbox of CartPage
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		//Click on "Visit to the website to complete orders" button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		//As this app is HybridApp, after clicking on Proceed button above, will navigate to browser(Browser rendering on mobile app).By default AndroidDriver cant handle and inspect elements on browser so we have get context whethere it is NATIVE-APP or WEB_VIEW and then switch driver accordingly
		//to know the context names, here grabbing the contexts and printing in console.
		Set<String> contexts= driver.getContextHandles();
		for(String contextname: contexts)
		{
			System.out.println(contextname);
		}
		
		//switched to webview
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		//As we cannot inspect elements on web using AppiumInspector, so inspect elements in web and use same locator details here to automate as element will be having same locator details iirespective of app or web.
		//And to automate ex: chromebowser place chromerdriver details emulator asking by downloading it and place it under UiAutomator 2 options
		//as we are inspecting now on browser, we can use selenium locators
		driver.findElement(By.name("q")).sendKeys("Satya");
		//To press enter to search once we enter Text on browser input
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//if we click back button then will navigate to App for this particular hybrid app.
		
		MobileGestures.pressKey(AndroidKey.BACK);
		
		//but still need to chnage the context to nativeapp
		
		driver.context("NATIVE_APP");
		
		
		
		
		
		
		
	}
	

}
