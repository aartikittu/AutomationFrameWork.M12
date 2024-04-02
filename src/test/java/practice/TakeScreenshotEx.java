package practice;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class TakeScreenshotEx extends BaseClass
{
	@Test(enabled=false)
	public void screenshot() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Assert.fail();
		try {
			sutil.captureScreenShot(this.driver, "hi");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
