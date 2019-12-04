package Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
	
	public static WebDriver driver;
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	public BaseTest() {
	}
	
	public static WebDriver setUpBrowser() {
		Utilities utilities = new Utilities();
		System.setProperty("webdriver.chrome.driver", utilities.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	protected String getRandomEmail() {
		String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * RANDOMCHARS.length());
			salt.append(RANDOMCHARS.charAt(index));
		}
		String randomEmail = salt.toString();
		return randomEmail;
	}
}

