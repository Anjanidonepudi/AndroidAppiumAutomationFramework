package Android.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobilebrowserBase {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		//Appium server path setup
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\satya\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		//Code to start Appium server automatically
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		//To run automation on chromebrowser in mobile needed chromedriver
		options.setChromedriverExecutable("C:\\\\Users\\\\satya\\\\Automation drivers\\\\chromedriver.exe");
		
		//Selecting virtual device to run mobile tests
		options.setDeviceName("Pixel 3 API 30_Satya");
		//as automating chromebrowser, need to set capability.
		options.setCapability("browser", "chrome");

		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}


