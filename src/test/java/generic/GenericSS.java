package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GenericSS {

	public static String caputureimg(WebDriver driver,String testName) throws IOException//pass parameter String Testname
	{
		//String path=("D://Screenshot/.png");
		Date d=new Date();
		String d1 = d.toString();
		String date1 = d1.replace(":", "-");
		//String path1="./photo/"+date1+testName+".png";
		String path2=System.getProperty("user.dir")+"./photo/"+date1+testName+".png";
	TakesScreenshot	ts=(TakesScreenshot)driver;
	File scr = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(path2);//concatinate TestName
	FileHandler.copy(scr, dest);
	return path2;

	}

}
