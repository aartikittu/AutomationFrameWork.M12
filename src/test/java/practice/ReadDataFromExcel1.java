package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel1 {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\BasicSeleniumPractice\\src\\main\\resources\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cell=row.getCell(0);
		String value=cell.getStringCellValue();
		System.out.println(value);
		wb.close();
		
		
				
	}

}
