package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DropDown {
	
AndroidDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appium:automationName", "UIAutomator2");
		cap.setCapability("appium:deviceName", "Pixel7");
		cap.setCapability("appium:app", "C://Users//Kapil//eclipse-workspace//TestAutomation//resources//General-Store.apk");
		
		
		//UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Android device");
	
		//options.setDeviceName("Pixel7");
		//options.setApp("C://Users//Kapil//eclipse-workspace//TestAutomation//resources//General-Store.apk");
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test01() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		//WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(ele).click().build().perform();
		WebElement ele=driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		Thread.sleep(5000);
		ele.click();
	
	}
	
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
