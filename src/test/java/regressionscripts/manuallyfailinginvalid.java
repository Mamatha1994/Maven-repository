package regressionscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Generic_Test;
import generic.genericmethodtoreadfromEXCEL;
import pom.LoginPage;

public class manuallyfailinginvalid extends Generic_Test
{
	@Test
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		 String username9 = genericmethodtoreadfromEXCEL.getData("Datadriven", 2, 0);
		 String password9 = genericmethodtoreadfromEXCEL.getData("Datadriven", 2, 1);
		 String etitle = genericmethodtoreadfromEXCEL.getData("Datadriven", 1, 2);
		 test=reports.createTest("INValidlogin", "Checking for Authentication"); 
		 
		LoginPage  lp=new LoginPage(driver);
		lp.MouseoverONProfile(driver);
		lp.clicklog();
		test.info("test started");
		lp.setUsername(username9);
		test.pass("User Entered UserName");
		lp.setPassword(password9);
		test.pass("User Entered Passsword");
		lp.Login();
		test.pass("User clicked on login");
		test.info("test ended");
		String atitle = driver.getTitle();
		Assert.assertEquals(atitle, etitle);
		Assert.fail();//manually failing
		System.out.println(etitle);

}

}
