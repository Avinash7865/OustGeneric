package myNewPack2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Analysis {
	
	AppiumDriver<WebElement> driver;
	 @BeforeTest 
	 public void setUp() throws MalformedURLException {
	 
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


  @Test
  public void ClickOustFeed() throws InterruptedException, IOException {
	 driver.findElementById("com.oustme.oustapp:id/action_progress").click();
	 String MA= driver.findElementByXPath("//android.widget.TextView[@text='My Analysis']").getText();
	 Assert.assertEquals(MA, "My Analysis");
	 Thread.sleep(5000);
	 screenshot();
		 
  }
  
  
  
  public void screenshot() throws IOException{
		
		File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    String path_screenshot = "target/MyAnalysis";
		File targetFile=new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
		
	    System.out.println(targetFile);
	}

}
