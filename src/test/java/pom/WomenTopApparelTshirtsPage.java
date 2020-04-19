package pom;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Base_Page;

public class WomenTopApparelTshirtsPage extends Base_Page
{
	@FindBy(xpath="//a[contains(text(),'Women')]")
	private WebElement women;
	@FindBy(xpath="//a[contains(text(),'Skirts & Palazzos')]")
	private WebElement ethnic;
	@FindBy(xpath="//body/div[@id='mountRoot']/div/div[@class='application-base']/main[@class='search-base']/div[contains(@class,'row-base')]/div[@class='search-rightContainer column-base']/div[@id='desktopSearchResults']/div[@class='search-searchProductsContainer row-base']/section/ul[@class='results-base']/li[2]/a[1]/div[1]/div[1]")
	private WebElement dress;
	
	//initialization

	public WomenTopApparelTshirtsPage(WebDriver driver) {
		super(driver);
	}

	//utilization
	public void mouseOverOnMen1(WebDriver driver)
	{
	verifyElement(women, 5);
	Actions act=new Actions(driver);
	act.moveToElement(women).perform();	
	}
	
	public void mouseOverOnethnic(WebDriver driver)
	{
		verifyElement(ethnic, 5);
	Actions act=new Actions(driver);
	act.moveToElement(ethnic).click().perform();	
	}
	public void ethnicDresses()
	{
		verifyElement(dress, 5);
	dress.click();
	Set<String> all_windows = driver.getWindowHandles();
	for (String str : all_windows) {
		driver.switchTo().window(str);
		
	}
	}
	
	



}
