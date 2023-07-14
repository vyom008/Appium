package BuffyBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BaseTest {
	
	@Test
	public void browserTest() {
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("[name*='q']")).sendKeys("rahul shetty academy");
		driver.findElement(By.cssSelector("[name*='q']")).sendKeys(Keys.ENTER);
		String text = driver.findElement(By.xpath("(//cite[@role='text'])[1]")).getText();
	}

}
