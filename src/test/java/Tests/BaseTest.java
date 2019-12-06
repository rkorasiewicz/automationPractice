package Tests;


import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.MyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseTest {
	
	private LoginPage lp;
	private MyAccountPage map;
	private MyStorePage msp;
	public static WebDriver driver;
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	public BaseTest() {
	}
	
	public static WebDriver setUpBrowser() {
		logger.info("Starting browser set up");
		Utilities utilities = new Utilities();
		System.setProperty("webdriver.chrome.driver", utilities.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Browser has been set up");
		return driver;
	}
	
	public String getRandomEmail() {
		logger.info("Generating random email base");
		String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * RANDOMCHARS.length());
			salt.append(RANDOMCHARS.charAt(index));
		}
		String randomEmail = salt.toString();
		logger.info("Random email base has been generated");
		return randomEmail;
	}
	
	public void logIn(){
		lp = new LoginPage();
		map = new MyAccountPage();
		msp = new MyStorePage();
		
		logger.info("Signing in");
		msp.signUpButtonClick();
		assertEquals("Login - My Store", driver.getTitle());
		
		logger.info("Providing email and password for logging");
		lp.emailForLoginProvide("dsoifjglkdsfjlg@o2.pl");
		lp.passwordForLoginProvide("mPEpyDfU9@MCSnL");
		lp.signInButtonClick();
		
		logger.info("Moving to 'my account' page");
		assertTrue(map.getCustomerAccount().isDisplayed());
		assertEquals("My account - My Store", driver.getTitle());
	}
}

