package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class BuyCloraCreationWomen extends Base_Page {
	
	@FindBy(className="size-buttons-unified-size")
	private WebElement size;
	
	@FindBy(xpath="//div[contains(@class,'pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button pdp-flex pdp-center')]")
	private WebElement add;
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
	private WebElement bag;
	
	@FindBy(xpath="//button[@class='inlinebuttonV2-base-actionButton itemContainer-base-inlineButton removeButton']")
	private WebElement remove;
	
	@FindBy(xpath="//button[@class='inlinebutton-base-actionButton itemComponents-base-move itemComponents-base-inlineButton']")
	private WebElement removefromcart;
	
	public BuyCloraCreationWomen(WebDriver driver) {
		super(driver);
	}
	
	public void selectSize()
	{
		verifyElement(size, 10);
	size.click();

}
	public void addTobag()
	{
		verifyElement(add, 10);
	add.click();
}
	
	public void clickonbag()
	{
		verifyElement(bag, 10);
	bag.click();
}
	
	public void removebag()
	{
		verifyElement(remove, 10);
	remove.click();
}
	public void removfromcart1()
	{
		verifyElement(removefromcart, 10);
	removefromcart.click();
}
}
