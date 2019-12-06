package Tests;

import PageObjects.CreateAnAccountFormPage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.MyStorePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurchuaseTest extends BaseTest {
	
	private Utilities utilities;
	private MyStorePage msp;
	private CreateAnAccountFormPage caafp;
	private LoginPage lp;
	private MyAccountPage map;
	
	private String firstName = "Marian";
	private String lastName = "Kowalski";
	private static final Logger logger = Logger.getLogger(PurchuaseTest.class.getName());
	
	@Before
	public void setUp(){
		utilities = new Utilities();
		driver = setUpBrowser();
		driver.get(utilities.getMainPagePath());
		Assert.assertEquals("My Store", driver.getTitle());
		logger.info("Set up is done");
	}
	
	@Test
	public void purchaseOneProduct(){
		logIn();
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done");
		//driver.quit();
	}
}
