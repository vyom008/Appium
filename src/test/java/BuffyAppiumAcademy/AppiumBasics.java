package BuffyAppiumAcademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {
	@Test
	public void AppiumTest()  throws MalformedURLException, InterruptedException{
		
		
		//AndroidDriver, IOSDriver
		//Appium code > Appium Server in json -> Mobile
		//Capabilities - Device
		
		//Actual Automation
		//Xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("android:id/edit")).sendKeys("Buffy wifi"+Keys.ENTER);
		String alertTitle = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView")).getText();
		System.out.println(alertTitle);
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Buffy wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
//		driver.switchTo().alert().accept();
		//set wifi name
		
		
		
	}

}
