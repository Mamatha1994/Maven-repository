package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Base_Page;

public class LoginPage extends Base_Page
{
	//declaration
	
	@FindBy(xpath="//span[contains(text(),'Profile')]")
	private WebElement profile;
	
	@FindBy(xpath="//a[contains(text(),'log in')]")
	private WebElement log;
	
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(className="login-login-button")
	private WebElement login;
	
	
//initialization
	public LoginPage(WebDriver driver) {
		super(driver);//calling the generic contructer from base_Page
	}

	//utilization
	
	public void MouseoverONProfile(WebDriver driver)
	{
		verifyElement(profile, 5);
		Actions act=new Actions(driver);
		act.moveToElement(profile).perform();	
	}
	
	public void clicklog()
	{
		verifyElement(log, 5);
		log.click();
	}
	
	public void setUsername(String Username1)
	{
		verifyElement(username, 5);
		username.sendKeys(Username1);
	}
	public void setPassword(String Password1)
	{

		verifyElement(password, 5);
		password.sendKeys(Password1);
	}
	public void Login()
	{verifyElement(login, 5);
		login.click();
	}
	
	
	
}