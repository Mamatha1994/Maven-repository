package generic;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Generic_Test implements Auto_const
{
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static  ExtentTest test;
	Filemanager fm=new Filemanager();
	BrowserFactory bff=new BrowserFactory();//since the getBrowser in BrowserFactory is made nonstatic create oject 
Logger log=Logger.getLogger(Generic_Test.class);
	@BeforeSuite
	public void setUp()
	{
		//htmlReporter=new ExtentHtmlReporter("./reports/E.html");
		htmlReporter=new ExtentHtmlReporter("./reports/"+new Date().toString().replace(":", "-")+"E.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	@Parameters({"browser"})
	
	@BeforeMethod
	public void openApp(@Optional("chrome")String browser)//@Optionalparameter is used to run specifiv testcase with out xml.application runs 
	//for specific testcase with out xml
	{
		if(browser.equals("chrome"))
		{
			log.info("STARTING BROWSER");
			driver=bff.getBrowser("chrome");
			driver.get(fm.getUrl());
			/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(Filemanager.getappurl());*/			
		}
		else if(browser.equals("firefox"))
		{
			driver=bff.getBrowser("firefox");
			driver.get(fm.getUrl());//call the method through reference variable
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.get(Filemanager.getappurl());
			
		}
		
	}
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException//ITestResult is an listener interface(doubt y it is interface)
	{
		System.out.println(res.getStatus());//using variable res we use inbuit method getstatus as1 pass 2 fail 3 skip if 2 take SS
		if(ITestResult.FAILURE==res.getStatus())
		{
			String testName = res.getName();
			test.fail("test script failed", MediaEntityBuilder.createScreenCaptureFromPath(new GenericSS().caputureimg(driver, testName)).build());//getname inbuilt method is used to the name of testcase that failed
			test.assignAuthor("MAMATHA BK");
			test.assignCategory("Regression Automation");
			test.assignDevice("LAPTOP");
			reports.setSystemInfo("SONY VAIO ","WINDOWS 7");
				//GenericSS.caputureimg(driver, testName);//classname.method name fron GenericSS since static directly we are accessing
			
			
		}
		else if(ITestResult.FAILURE==res.getStatus())
		{
			String testName = res.getName();
			test.fail("test script skipped", MediaEntityBuilder.createScreenCaptureFromPath(new GenericSS().caputureimg(driver, testName)).build());//getname inbuilt method is used to the name of testcase that failed
			
				//GenericSS.caputureimg(driver, testName);//classname.method name fron GenericSS since static directly we are accessing
			
			
		}
		
		
	driver.quit();
	log.info("CLOSING THE BROWSER ");
	}
	@AfterSuite
	public void tearDown()
	{
		
		reports.flush();
		
	}

}

