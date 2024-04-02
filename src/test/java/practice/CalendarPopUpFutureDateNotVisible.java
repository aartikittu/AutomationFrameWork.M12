package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpFutureDateNotVisible 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize(); 
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.moveByOffset(42,123).click().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		for(int i=0; i<4;i++)
		{
			driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
		}
		String date="Sat Aug 24 2024";
		driver.findElement(By.xpath("//div[@aria-label=\""+date+"\"]")).click();
	
	}
}
