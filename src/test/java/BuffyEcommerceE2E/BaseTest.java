package BuffyEcommerceE2E;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
//		Map<String, String> env = new HashMap<String, String>(System.getenv());
//		env.put("ANDROID_HOME", "C:\\Users\\vyom0\\AppData\\Local\\Android\\Sdk");
//		env.put("JAVA_HOME", "C:\\Program Files\\JavaNew\\jdk-19");
		
		
		//AndroidDriver, IOSDriver
		//Appium code > Appium Server in json -> Mobile
		//Capabilities - Device
		
		service = new AppiumServiceBuilder().withAppiumJS
				(new File("C:\\Users\\vyom0\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("Buffy");
		
		//Chrome
//		public WebDriver driver;
//		String path = System.getProperty("user.dir");
//		System.out.println(path);
//		System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
		String path = System.getProperty("user.dir");
		System.out.println(path);
		options.setChromedriverExecutable(path+"\\src\\test\\java\\resources\\chromedriver.exe");
		
		
		options.setApp("C:\\TEST AUTOMATION BEGINS\\BUFFY\\Bimla\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public double getFormatedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void longPressAction(WebElement ele) {
//		WebElement ele = driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.TextView[1]"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
