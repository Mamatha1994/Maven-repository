package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Genericdataprovider
{ WebDriver driver;
	@BeforeMethod
		public void setUp()
		{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.get("https://www.flipkart.com/?gclid=EAIaIQobChMI5pfZs_T75gIVjw4rCh0FHgKCEAAYASAAEgI3c_D_BwE&ef_id=EAIaIQobChMI5pfZs_T75gIVjw4rCh0FHgKCEAAYASAAEgI3c_D_BwE:G:s&s_kwcid=AL!739!3!326554990757!p!!g!!flipkart&semcmpid=sem_8024046704_brand_eta_goog");
		}
	@DataProvider(name="Authentication")
	public Object[][] getloginDetails() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Object arr[][]=Excelcode.getData("Datadriven");
		return arr;
	}
	@Test(dataProvider="Authentication")
	public void Login(String username,String password)
	{
		WebElement ele = driver.findElement(By.className("_2zrpKA"));
		ele.sendKeys(username);
		WebElement result1=driver.findElement(By.xpath("//input[@type='password']"));
		result1.sendKeys(password);
		WebElement result2=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		result2.click();
	}
	@AfterMethod
	public void Quit()
	{
		driver.quit(); //https://www.flipkart.com/?gclid=EAIaIQobChMI5pfZs_T75gIVjw4rCh0FHgKCEAAYASAAEgI3c_D_BwE&ef_id=EAIaIQobChMI5pfZs_T75gIVjw4rCh0FHgKCEAAYASAAEgI3c_D_BwE:G:s
	}
}
