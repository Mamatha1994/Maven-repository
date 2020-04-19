package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class genericmethodtoreadfromEXCEL {

	public static String getData(String sheetname,int row,int cell) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./excel/data.xlsx");//give the path of excel
		Workbook wb = WorkbookFactory.create(fis);//open excel
		 Cell cel = wb.getSheet(sheetname).getRow(row).getCell(cell);
		String va = cel.getStringCellValue();
		
		return va;


	}

}
