package Tests;

import PageObjects.AuthenticationPage;
import PageObjects.CreateAnAccountFormPage;
import PageObjects.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {
	
	private Utilities utilities;
	private MainPage mp;
	private CreateAnAccountFormPage caafp;
	private AuthenticationPage ap;
	private Utilities utillities;
	
	private String firstName = "Marian";
	private String lastName = "Kowalski";
	private static final Logger logger = Logger.getLogger(RegistrationTest.class.getName());
	
	@Before
	public void setUp(){
		utilities = new Utilities();
		driver = setUpBrowser();
		driver.get(utilities.getMainPagePath());
		Assert.assertEquals("My Store", driver.getTitle());
	}
	
	@Test
	public void verifyUserRegistration() throws IOException {
			mp = new MainPage();
			caafp = new CreateAnAccountFormPage();
			ap = new AuthenticationPage();
			
			mp.signUpButtonClick();
			assertEquals("AUTHENTICATION", ap.getAuthenticationHeader());
			
			ap.emailProvide(getRandomEmail() + "@o2.pl");
			ap.createAccountButtonClick();
			
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
			caafp.zipCodeProvide(00011);
			caafp.mobilePhoneProvide(123456789);
			caafp.registerButtonClick();
		}
		
	@After
	public void cleanUp(){
		logger.info("Test is ending");
		driver.quit();
	}
}
