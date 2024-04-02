package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarPopUpCurrentDate {

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
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");  
		String strDate = dateFormat.format(date); 
		System.out.println(strDate);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@aria-label=\""+strDate+"\"]")).click();
		
	}

}
