package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author dell
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This method read the data from excel file and return the value to caller
	 * @throws Throwable 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readStringDataFromExcel(String sheet,int row,int cell) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value= wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public String readNumericDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		Cell cell1= wb.getSheet(sheet).getRow(row).getCell(cell);
		DataFormatter data=new DataFormatter();
		String value=data.formatCellValue(cell1);
		return value;
	}
}
