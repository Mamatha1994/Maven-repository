package generic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods 

{
	
	public void mouseHover (WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void righClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void selectByPositionk(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public List<String> selectAllOptions(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> options=s.getOptions();
		List<String> l=new ArrayList<String>();
		for (WebElement e1:options)
		{
			l.add(e1.getText());
		}
return l;
	}
	public int finAllElements(WebDriver driver,String index)
	{
		List<WebElement> alladdress =driver.findElements(By.xpath(index));
		int count=alladdress.size();
		return count;
		
				
		
	}

}
