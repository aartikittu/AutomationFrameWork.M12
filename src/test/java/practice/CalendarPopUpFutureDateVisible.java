package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpFutureDateVisible {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.moveByOffset(42,126).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		String date="Wed Apr 24 2024";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label=\""+date+"\"]")).click();
	}

}
