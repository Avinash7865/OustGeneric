package tests.java.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public abstract class basePage {
	 protected AppiumDriver<WebElement> driver;
	 
	 public basePage(AppiumDriver<WebElement> driver) throws MalformedURLException {
	 
	  DesiredCapabilities capabilities = new DesiredCapabilities(); 
	 
	  capabilities.setCapability("deviceName", "0ef8fa12");
	 
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	  
	  capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
	  capabilities.setCapability("UUID", "0ef8fa12");
	  
	  capabilities.setCapability("platformName", "Android"); 
	  capabilities.setCapability("appPackage", "com.oustme.oustapp");
	  capabilities.setCapability("appActivity", "com.oustme.oustapp.activity.SplashActivity_");
	  driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	 
	 
}
