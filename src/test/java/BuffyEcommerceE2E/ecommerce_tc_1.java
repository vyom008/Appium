package BuffyEcommerceE2E;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ecommerce_tc_1 extends BaseTest {
	
	@Test
	public void FillForm() throws InterruptedException {
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Buffy Gupta");
//		driver.hideKeyboard();
		driver.findElement(By.xpath("(//android.widget.RadioButton[2])")).click();
		Thread.sleep(3000);
		//Where to scroll is known
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
