package Android.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileGestures {

	private AndroidDriver driver;

	public MobileGestures(AndroidDriver driver) {
		this.driver = driver;

	}

	public void MobileLongClick(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void MobileLongClickUsingCo_Ordinates(int X, int Y) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("x", X, "y", Y, "duration", 2000));
	}
	
	public void scrollToText(String text) {
	    driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"
	    ));
	}
	
	public boolean scrollUsingCoordinates(int left, int top, int width, int height, String direction, double percentage) {
	        return (Boolean) ((JavascriptExecutor) driver).executeScript(
	            "mobile: scrollGesture",
	            ImmutableMap.of(
	                "left", left,
	                "top", top,
	                "width", width,
	                "height", height,
	                "direction", direction,
	                "percentage", percentage
	            )
	        );
	    }
	public void scrollToLast(int left, int top, int width, int height, String direction, double percentage) {
        boolean canScrollMore;
        do {
            // Perform the scroll gesture
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "mobile: scrollGesture",
                ImmutableMap.of(
                    "left", left,
                    "top", top,
                    "width", width,
                    "height", height,
                    "direction", direction,
                    "percentage", percentage
                )
            );
        } while (canScrollMore);
    }
	
	public void MobileSwipeGesture(WebElement ele, String directionleft) { 
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", directionleft, "percentage", 0.75)); 
	}
	
	public void MobileSwipeGestureUsingCo_Ordinates(int left,int top,int width,int height, String direction) { 
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of( "left", left,
                    "top", top,
                    "width", width,
                    "height", height,
                    "direction", direction,
                      "percentage", 0.75)); 
	}
	
	public void MobileDragGestureUisngElement(WebElement ele, int x,int y) { 
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", x, "endY", y)); 
	}
	
	public void MobileDragGestureUisngCo_Ordinates(int sx,int sy, int ex,int ey, int speedvalue) { 
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", 
				ImmutableMap.of("startX", sx, "startY", sy, "endX", ex, "endY", ey, "speed", speedvalue)); 
	}
	
	
	//for this call method and passkey as---"pressKey(AndroidKey.HOME/BACK/ENTER);"
	public void pressKey(AndroidKey key) {
	    driver.pressKey(new KeyEvent(key));
	}

	

}
