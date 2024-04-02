package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountriesWithCapital {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
		driver.manage().window().maximize();
		String countryName="Mozambique";
		Thread.sleep(20000);
		WebElement value=driver.findElement(By.xpath("//td[text()=\""+countryName+"\"]/parent::tr/td[2]"));
		System.out.println("Captial is "+value.getText());
	}

}
