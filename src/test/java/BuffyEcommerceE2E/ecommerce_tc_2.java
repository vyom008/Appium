package BuffyEcommerceE2E;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class ecommerce_tc_2 extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException {

		String expectedProducts[] = {"Jordan 6 Rings", "Jordan Lift Off"};
		String actualProducts[] = new String[2];

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Buffy Gupta");
		driver.hideKeyboard();
		driver.findElement(By.xpath("(//android.widget.RadioButton[2])")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/text1")).click();
		//Where to scroll is known
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		//Where to scroll is known
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
		List<WebElement> productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

//		for(int i = 0; i<productCount.size();i++) {
			for(int i = 0; i<expectedProducts.length;i++) {
			String productName = productCount.get(i).getText();
			if(productName.contains(expectedProducts[i])) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
			
//			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));


//		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		
        //Verify products displayed on Checkout page
		Thread.sleep(3000);
		List<WebElement> checkoutCards = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		for(int i=0;i<checkoutCards.size();i++) {
			actualProducts[i] = checkoutCards.get(i).getText();
		}
		Assert.assertEquals(expectedProducts, actualProducts);
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		double sum =0;
		for(int i =0; i<productPrices.size();i++) {
			String price = productPrices.get(i).getText();
//			String price3 = price.substring(1);
//			double price2 = Double.parseDouble(price3);
			
			double price2 = getFormatedAmount(price);
			sum = sum+price2;
		}
		System.out.println(sum);
		
		String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().trim();
		
		double totalSum2 = getFormatedAmount(totalAmount);
		
//		double totalSum2 = Double.parseDouble(totalAmount);
		Assert.assertEquals(sum, totalSum2);

		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(3000);
	}

}
