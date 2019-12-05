package Tests;

import PageObjects.LoginPage;
import PageObjects.CreateAnAccountFormPage;
import PageObjects.MyStorePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PageObjects.MyAccountPage;

import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
	
	private Utilities utilities;
	private MyStorePage msp;
	private CreateAnAccountFormPage caafp;
	private LoginPage lp;
	private MyAccountPage map;
	
	private String firstName = "Marian";
	private String lastName = "Kowalski";
	private static final Logger logger = Logger.getLogger(RegistrationTest.class.getName());
	
	@Before
	public void setUp(){
		utilities = new Utilities();
		driver = setUpBrowser();
		driver.get(utilities.getMainPagePath());
		Assert.assertEquals("My Store", driver.getTitle());
		logger.info("Set up is done");
	}
	
	@Test
	public void verifyUserRegistration() {
			msp = new MyStorePage();
			caafp = new CreateAnAccountFormPage();
			lp = new LoginPage();
			map = new MyAccountPage();
			
			logger.info("Signing in");
			msp.signUpButtonClick();
			assertEquals("AUTHENTICATION", lp.getAuthenticationHeader());
			
			logger.info("Creating new account");
			lp.emailProvide(getRandomEmail() + "@o2.pl");
			lp.createAccountButtonClick();
			
			logger.info("Providing data to form");
			caafp.mrRadioButtonClick();
			caafp.firstNameProvide(firstName);
			caafp.lastNameProvide(lastName);
			caafp.passwordProvide("testPassword");
			caafp.dayOfBirthSelect(2);
			caafp.monthOfBirthSelect(5);
			caafp.yearOfBirthSelect(1988);
			caafp.addressFirstNameProvide(firstName);
			caafp.addressLastNameProvide(lastName);
			caafp.addressProvide("Boston Street, 54, ST Holding Company");
			caafp.cityProvide("Chicago");
			caafp.stateNameSelectFromList("Kansas");
			caafp.zipCodeProvide(99501);
			caafp.mobilePhoneProvide(123456789);
			logger.info("Data has been provided");
			caafp.registerButtonClick();
			
			logger.info("Moving to 'my account' page");
			assertTrue(map.getCustomerAccount().isDisplayed());
		}
		
	@After
	public void cleanUp(){
		logger.info("Test is done");
		driver.quit();
	}
}
