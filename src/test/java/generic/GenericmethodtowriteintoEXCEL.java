package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericmethodtowriteintoEXCEL {

	public static void writeData(String sheet,int row,int cell,String data) throws FileNotFoundException
	{
		FileInputStream fis=new FileInputStream("./Excel/data.xlsx");//give the path of excel
		try {
		Workbook wb = WorkbookFactory.create(fis);//open excel
		Cell c = wb.getSheet("Sheet4").getRow(row).createCell(cell);
		c.setCellValue(data);
		FileOutputStream fout=new FileOutputStream("./Excel/data.xlsx");
		wb.write(fout);
	
	}
		catch(Exception e)
		{
			
		}

}
}
