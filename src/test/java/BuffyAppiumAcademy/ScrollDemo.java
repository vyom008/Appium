package BuffyAppiumAcademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoTest()  throws MalformedURLException, InterruptedException{
		
		
		//AndroidDriver, IOSDriver
		//Appium code > Appium Server in json -> Mobile
		//Capabilities - Device
		
		//Actual Automation
		//Xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//Where to scroll is known
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		//Where to scroll is not known
		scrollToEndAction();
		
		
//		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) ele).getId(),
//			    "direction", "down",
//			    "speed", 500
//			));

	}

}
