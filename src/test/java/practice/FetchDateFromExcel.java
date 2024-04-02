package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import genericUtilities.ExcelFileUtility;

public class FetchDateFromExcel {

	public static void main(String[] args) throws Throwable 
	{
		ExcelFileUtility eutil=new ExcelFileUtility();
		String EVENTSTARTS1=eutil.readNumericDataFromExcel("Calendar", 1, 3);
		System.out.println(EVENTSTARTS1);
		SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = inputFormat.parse(EVENTSTARTS1);
	    String EVENTSTARTS = outputFormat.format(date);
	    System.out.println(EVENTSTARTS);
		String EVENTENDS1=eutil.readNumericDataFromExcel("Calendar", 1, 4);
	    System.out.println(EVENTENDS1);
		Date date1 = inputFormat.parse(EVENTENDS1);
	    String EVENTENDS = outputFormat.format(date1);
	    System.out.println(EVENTENDS);
	}

}
