package Android.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Activity;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class wifisettingtestmethod  extends BaseTest {
	
	 @Test(dataProvider = "wifiSettingsData")
	    public void wifiSettingTest(String expectedTitle, String wifiName) {
	        // Instantiate the Page Object
		 WifiSettingpageobjectmodel WifiSettingpageobjectmodel = new WifiSettingpageobjectmodel(driver);

	        // Perform actions
		 WifiSettingpageobjectmodel.clickPreferencesOption();
		 WifiSettingpageobjectmodel.clickPreferenceDependencies();
		 WifiSettingpageobjectmodel.toggleWifiCheckbox();
		 WifiSettingpageobjectmodel.rotateDeviceToLandscape();
		 WifiSettingpageobjectmodel.clickWifiSettingsOption();

	        // Assert the title of the WiFi Settings alert
	        String actualAlertTitle = WifiSettingpageobjectmodel.getWifiAlertTitle();
	        Assert.assertEquals(actualAlertTitle, expectedTitle);

	        // Set WiFi text and confirm
	        WifiSettingpageobjectmodel.setWifiText(wifiName);
	        WifiSettingpageobjectmodel.clickOkButton();
	    }

	 //As running scripts mutiple times, to start script from exact same page/activity everytime setActivity before running every method.
	 @BeforeMethod
	 public void preSetup() {
	     // Create an Activity object with the package name and activity name
		( (JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.ApiDemos"));   
	     
	 }
	    @DataProvider(name = "wifiSettingsData")
	    public Object[][] wifiSettingsDataProvider() {
	        return new Object[][]{
	            {"Wifi Settings", "Satya"},
	            {"Wifi Settings", "TestNetwork"},
	            {"Wifi Settings", "AppiumNetwork"}
	        };
	    }

}
