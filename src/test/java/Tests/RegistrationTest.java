package Tests;

import PageObjects.AuthenticationPage;
import PageObjects.CreateAnAccountFormPage;
import PageObjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PageObjects.MyAccountPage;
import java.io.IOException;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
	
	private Utilities utilities;
	private MainPage mp;
	private CreateAnAccountFormPage caafp;
	private AuthenticationPage ap;
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
			mp = new MainPage();
			caafp = new CreateAnAccountFormPage();
			ap = new AuthenticationPage();
			map = new MyAccountPage();
			
			logger.info("Signing in");
			mp.signUpButtonClick();
			assertEquals("AUTHENTICATION", ap.getAuthenticationHeader());
			
			logger.info("Creating new account");
			ap.emailProvide(getRandomEmail() + "@o2.pl");
			ap.createAccountButtonClick();
			
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
