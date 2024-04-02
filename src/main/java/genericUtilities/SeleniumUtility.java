package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

/**
 * This class contains generic methods related to selenium web driver
 * @author dell
 *
 */

public class SeleniumUtility 
{
	/**
	 * This method is to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is to minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add 10 seconds to implicitly wait
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for a web element to be visible 
	 * @param driver
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for 10 seconds for a web element to be present 
	 * @param driver
	 */
	public void waitForElementAlertPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method will wait for 10 seconds for a web element to before clicking
	 * @param driver
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for 10 seconds for a web element to be selected 
	 * @param driver
	 */
	public void waitForElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * This method will wait for 10 seconds for a text to be present in web element
	 * @param driver
	 */
	public void waitForElemtToBePresentText(WebDriver driver,WebElement element,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle dropdown by visibleText
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will move to specified Element 
	 * @param driver
	 * @param ele
	 */
	public void moveToElementAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method will click on specified element 
	 * @param ele
	 * @param driver
	 */
	public void clickAction(WebElement ele, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.click(ele).click().perform();
	}
	/**
	 * This method will drag the element to specified drop location
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void dragAndDropAction(WebDriver driver, WebElement drag,WebElement drop)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
	}
	/**
	 * This method will click on the given x,y coordinates
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffsetAction(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	/**
	 * This method will right click action on webelement
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * This method will right click action on webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform double click on webelement
	 * @param driver
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	/**
	 * This method will send the value to specified element
	 * @param driver
	 * @param ele
	 * @param value
	 */
	public void sendKeysAction(WebDriver driver, WebElement ele, String value)
	{
		Actions act=new Actions(driver);
		act.sendKeys(ele,value).perform();	
	}
	/**
	 * This element will click and then hold the element
	 * @param driver
	 * @param ele
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(ele).perform();	
	}
	/**
	 * This method will release the hold element to the target place
	 * @param driver
	 * @param ele
	 */
	public void ReleaseAction(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.release(ele).perform();
	}
	/** 
	 * This method will scroll down to cordinate given
	 * @param driver
	 * @param value
	 */
	public void ScrollDownAction(WebDriver driver, int X)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(X,0)");
	}
	/** 
	 * This method will scroll up to cordinate given
	 * @param driver
	 * @param value
	 */
	public void ScrollUpAction(WebDriver driver, int X)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-X)");
	}
	/** 
	 * This method will scroll up to cordinate given
	 * @param driver
	 * @param value
	 */
	public void ScrollRightAction(WebDriver driver, int Y)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,Y)");
	}	
	/** 
	 * This method will scroll up to cordinate given
	 * @param driver
	 * @param value
	 */
	public void ScrollLeftAction(WebDriver driver, int Y)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(-Y,0)");
	}	
	/**
	 * This method will scroll to the webelement given
	 * @param e
	 * @param driver
	 */
	public void ScrollToElement(WebElement e, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(e).perform();
	}
	/**
	 * This method will scroll until the webelement is visible
	 * @param e
	 * @param driver
	 */
	public void ScrollIntoView(WebElement e, WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	/**
	 * This method will scroll to given Coordinates
	 * @param driver
	 * @param e
	 */
	public void ScrollByCoordinates(WebDriver driver, int X, int Y)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(X,Y)");
	}
	/**
	 * This method will scroll to end of the page
	 * @param driver
	 */
	public void ScrollToPageEnd(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/**
	 * This method will scroll to start of the page
	 * @param driver
	 */
	public void ScrollToPageStart(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	/**
	 * This method will switch to frame by frame index
	 * @param driver
	 * @param FrameIndex
	 */
	public void handleFrame(WebDriver driver,int FrameIndex)
	{
		driver.switchTo().frame(FrameIndex);
	}
	/**
	 * This method will switch to frame by frame name or id
	 * @param driver
	 * @param FrameIndex
	 */
	public void handleFrame(WebDriver driver,String name_or_id)
	{
		driver.switchTo().frame(name_or_id);
	}
	/**
	 * This method will switch to frame by frame path
	 * @param driver
	 * @param FrameIndex
	 */
	public void handleFrame(WebDriver driver,WebElement e)
	{
		driver.switchTo().frame(e);
	}
	/**
	 * This method will switch to default content
	 * @param driver
	 * @param FrameIndex
	 */
	public void handleDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch to parent frame
	 * @param driver
	 * @param FrameIndex
	 */
	public void handleParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
		alt.accept();		
	}
	/**
	 * This method will cancel the alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
		alt.dismiss();		
	}
	/**
	 * This method will get the value of alert pop up
	 * @param driver
	 */
	public String getTextAlert(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
		String value=alt.getText();
		return value;
	}
	/**
	 * This method will send the value to alert pop up
	 * @param driver
	 */
	public void enterTextAlert(WebDriver driver,String value)
	{
		Alert alt= driver.switchTo().alert();
		alt.sendKeys(value);
	}
	/**
	 * This method will capture the screenshot and reutrn the path to caller
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws Throwable
	 */
	public String captureScreenShot(WebDriver driver , String ScreenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(".\\Screenshot\\"+ScreenShotName+".png");
		Files.copy(src, des);
		return des.getAbsolutePath();//used for extent reports
	}

}
