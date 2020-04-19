package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory implements Auto_const
{
	//creating map struture private static(this is made non static) map<>=new HashMap<>(); to get key and value pair
	//so before it was static (since static is single copy and nonstativc is mutiple copy)i make nonstatic
	private  Map<String,WebDriver> drivers=new HashMap<String,WebDriver>();//using map to get key values pair
	//method is also made nonstatic
	public  WebDriver getBrowser(String browserName)
	{
		WebDriver driver=null;
	
			
		switch (browserName) 
		{
		case "chrome":
			driver=drivers.get("chrome");
			if(driver==null)
				System.setProperty(chrome_key, chrome_value);
				driver=new ChromeDriver();
				drivers.put("chrome", driver);//adding data to hashmap from chrome
			break;
		case "firefox":
			driver=drivers.get("firefox");
			if(driver==null)
				System.setProperty(gecko_key, gecko_value);
				driver=new FirefoxDriver();
				drivers.put("firefox", driver);//adding data to hashmap from chrome
			break;

		default:
			System.out.println("no such browser");
			break;
		}
	return driver;
	}
}
