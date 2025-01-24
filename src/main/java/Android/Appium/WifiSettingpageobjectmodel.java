package Android.Appium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.DeviceRotation;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WifiSettingpageobjectmodel {
	
	 private AndroidDriver driver;

	    // Constructor to initialize elements using normal PageFactory
	    public WifiSettingpageobjectmodel(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	    }

	    // Elements using PageFactory
	    @AndroidFindBy(accessibility = "Preference")
	    private WebElement preferencesOption;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
	    private WebElement preferenceDependencies;

	    @AndroidFindBy(id = "android:id/checkbox")
	    private WebElement wifiCheckbox;

	    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]")
	    private WebElement wifiSettingsOption;

	    @AndroidFindBy(id = "android:id/alertTitle")
	    private WebElement wifiAlertTitle;

	    @AndroidFindBy(id = "android:id/edit")
	    private WebElement wifiEditTextBox;

	    @AndroidFindBy(className = "android.widget.Button")
	    private List<WebElement> buttons;

	    // Methods for actions
	    public void clickPreferencesOption() {
	        preferencesOption.click();
	    }

	    public void clickPreferenceDependencies() {
	        preferenceDependencies.click();
	    }

	    public void toggleWifiCheckbox() {
	        wifiCheckbox.click();
	    }

	    public void rotateDeviceToLandscape() {
	        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
	        driver.rotate(landscape);
	    }

	    public void clickWifiSettingsOption() {
	        wifiSettingsOption.click();
	    }

	    public String getWifiAlertTitle() {
	        return wifiAlertTitle.getText();
	    }

	    public void setWifiText(String text) {
	        wifiEditTextBox.sendKeys(text);
	    }

	    public void clickOkButton() {
	        buttons.get(1).click(); // Index 1 for the "OK" button
	    }

}
