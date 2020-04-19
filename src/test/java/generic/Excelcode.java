package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelcode
{
	
	@DataProvider(name="callme")
	public static Object[][] getData(String sheetname ) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./excel/data.xlsx");//give the path of excel
		Workbook wb = WorkbookFactory.create(fis);//open excel
		Sheet sh = wb.getSheet(sheetname);//give sheetname
		int lr = sh.getLastRowNum();
		Row r = sh.getRow(0);
		short c = r.getLastCellNum(); 

		Object [][] data=new Object[lr+1][c];//creates an object with mentioned num of rows nd column
		for(int i=0;i<lr+1;i++)
		{
			Row row = sh.getRow(i);
		
		for(int j=0;j<c;j++)
		{
		Cell column = r.getCell(j);
		String val = column.getStringCellValue();
		
		data[i][j]=val;
		}
		}
		return data;


	
}
}
