package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class ExcelUtility {
	
	public String getExcelData(String sheetname,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/ExcelFetch.xlsx");
		Workbook book1= WorkbookFactory.create(fis);
		
		/*Sheet sheet1 = book1.getSheet(sheetname);
		Row row1 = sheet1.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		String Value = cell1.getStringCellValue();*/
		
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book1.getSheet(sheetname).getRow(rowNum).getCell(cellNum));
		
		return data;
	}

}
