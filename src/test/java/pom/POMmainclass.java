package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generic.Generic_Test;
import generic.genericmethodtoreadfromEXCEL;

public class POMmainclass extends Generic_Test 
{
	@Test
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		 String username9 = genericmethodtoreadfromEXCEL.getData("Sheet2", 1, 0);
		 String password9 = genericmethodtoreadfromEXCEL.getData("Sheet2", 1, 1);
		 String etitle = genericmethodtoreadfromEXCEL.getData("Sheet2", 1, 2);
		 System.out.println("fETCHED");
		LoginPage  lp=new LoginPage(driver);
		lp.MouseoverONProfile(driver);
		lp.clicklog();
		lp.setUsername(username9);
		lp.setPassword(password9);
		lp.Login();
		
		WomenTopApparelTshirtsPage wp = new WomenTopApparelTshirtsPage(driver);
		wp.mouseOverOnMen1(driver);
		wp.mouseOverOnethnic(driver);
		wp.ethnicDresses();
		BuyCloraCreationWomen by = new BuyCloraCreationWomen(driver);
		by.selectSize();
		by.addTobag();
		by.clickonbag();
		by.removebag();
		by.removfromcart1();
	}

}
