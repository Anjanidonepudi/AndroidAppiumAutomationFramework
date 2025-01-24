package Android.Appium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class wifiSettingMethod_dataJSON  extends BaseTest {
	
	 @Test(dataProvider = "wifiSettingData")
	    public void wifiSettingsTest(HashMap<String,String> input) {
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
	        Assert.assertEquals(actualAlertTitle, input.get("wifiexpectedname"));

	        // Set WiFi text and confirm
	        WifiSettingpageobjectmodel.setWifiText(input.get("title"));
	        WifiSettingpageobjectmodel.clickOkButton();
	    }

	 //As running scripts mutiple times, to start script from exact same page/activity everytime setActivity before running every method.
	 @BeforeMethod
	 public void preSetup() {
	     // Create an Activity object with the package name and activity name
		( (JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.ApiDemos"));   
	     
	 }
	 
	
	    @DataProvider(name = "wifiSettingData")
	    public Object[][] wifiSettingsDataProvider() throws IOException {
	    	 DatafromFileToHashMap DatafromFileToHashMap = new DatafromFileToHashMap(driver);
	    	 List<HashMap<String,String>> data = DatafromFileToHashMap.getJsonData(System.getProperty("user.dir") + "src\\test\\java\\Android\\Appium\\jsondata\\data.json");
	        return new Object[][]{
	            {data.get(0)},
	            {data.get(1)},
	            {data.get(2)}
	        };
	    }

}
