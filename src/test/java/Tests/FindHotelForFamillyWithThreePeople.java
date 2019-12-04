package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class FindHotelForFamillyWithThreePeople extends BaseTest {
	
	private Utilities utilities;
	private static final Logger logger = Logger.getLogger(FindHotelForFamillyWithThreePeople.class.getName());
	
	@Before
	public void setUp() throws IOException {
		utilities = new Utilities();
		driver = setUpBrowser();
		driver.get(utilities.getMainPagePath());
		Assert.assertEquals("PHPTRAVELS | Travel Technology Partner", driver.getTitle());
	}
	
	@Test
	public void verifyUserRegistration() throws IOException {
		registration();
	}
	
	@Test
	public void verifyUserLogin() throws IOException {
		login();
	}

	@After
	public void cleanUp(){
		logger.info("Test is ending");
		driver.quit();
	}
}
