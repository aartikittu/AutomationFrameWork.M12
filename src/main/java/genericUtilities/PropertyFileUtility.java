package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author dell
 *
 */

public class PropertyFileUtility 
{
	/**
	 * This method will read the data from property file and return the value to caller
	 * @throws Throwable 
	 */
	public String readDataFromProperty(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
}
