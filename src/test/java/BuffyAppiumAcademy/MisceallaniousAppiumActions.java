package BuffyAppiumAcademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MisceallaniousAppiumActions extends BaseTest {
	@Test
	public void AppiumTest()  throws MalformedURLException, InterruptedException{
		
		
		//App Package & App Activity
		//adb devices
		//For Mac/Linux: adb shell dumpsys window | grep -E 'mCurrentFocus' 
		//For Windows: adb shell dumpsys window | find "mCurrentFocus"
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation  landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String alertTitle = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView")).getText();
		System.out.println(alertTitle);
		Assert.assertEquals(alertTitle, "WiFi settings");
		//copy paste
		//copy to clipboard - paste it clipboard
		driver.setClipboardText("Buffy wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		
		
		
	}

}
