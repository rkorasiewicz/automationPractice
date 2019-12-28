package Tests;

import PageObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RegistrationTest extends BaseTest {
	
	private MyStorePage msp;
	private CreateAnAccountFormPage caafp;
	private LoginPage lp;
	private MyAccountPage map;
	private OrderPaymentConfirmationPage opcp;
	private static final Logger logger = Logger.getLogger(RegistrationTest.class.getName());
	
	@Before
	public void starting(){
		setUpMainPage();
	}
	
	@Test
	public void verifyUserRegistration() throws IOException {
		msp = new MyStorePage();
		caafp = new CreateAnAccountFormPage();
		lp = new LoginPage();
		map = new MyAccountPage();
		opcp = new OrderPaymentConfirmationPage();
		
		String firstName = "Marian";
		String lastName = "Kowalski";
			
		logger.info("Signing in");
		msp.signUpButtonClick();
		assertEquals("AUTHENTICATION", lp.getAuthenticationHeader());
			
		logger.info("Creating new account");
		lp.emailProvide(getRandomEmail() + "@o2.pl");
		lp.createAccountButtonClick();
			
		logger.info("Providing data to form");
		try {
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
			//caafp.registerButtonClick();
			lp.createAccountButtonClick();
		}catch (Exception e){
			Utilities.takeScreenShoot(driver, getClass().getName());
			fail();
		}
			
		logger.info("Moving to My account page");
		assertTrue(map.getCustomerAccount().isDisplayed());
		
		logger.info("Signing out");
		opcp.signOutButtonClick();
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done");
		driver.quit();
	}
}
