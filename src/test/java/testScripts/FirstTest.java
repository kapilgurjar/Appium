package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstTest {

	AndroidDriver driver;

	@Test
	public void TC01_LaunchApp() {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel7");
		options.setApp("C://Users//Kapil//eclipse-workspace//TestAutomation//resources//ApiDemos-debug.apk");
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebElement ele = driver.findElement(AppiumBy.accessibilityId("App"));
		//ele.click();
		System.out.println(driver.getBatteryInfo().getLevel());
		List<WebElement> listele = driver.findElements(
				By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.TextView"));
		int size = listele.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++) {
			String text=listele.get(i).getAttribute("text");
			System.out.println(text);
			
			if(text.equalsIgnoreCase("OS")) {
				listele.get(i).click();
				break;
			}
		}

		driver.quit();
	}

}
