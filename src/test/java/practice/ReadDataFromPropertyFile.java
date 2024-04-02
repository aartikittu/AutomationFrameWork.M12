package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFile 
{
	public static void main(String[] ags) throws Throwable
	{
//		Step 1: Open the document in Java Readable file
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commondata.properties");
		
//		Step 2: Create the object of properties class from java.util
		Properties pro=new Properties();
		
//		Step 3: Load the input stream to properties
		pro.load(fis);
		
//		Step 4: Provide the key and read the value
		String value=pro.getProperty("url");
		System.out.println(value);
	
	}
}
