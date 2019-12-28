package Tests;

import PageObjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScreenshotTest extends BaseTest {
	
	private MyAccountPage map;
	private TShirtsPage tsp;
	private OrderSummaryPage osump;
	private OrderAddressPage oap;
	private OrderShippingPage osp;
	private OrderPaymentPage opp;
	private OrderPaymentSummaryPage opsp;
	private OrderPaymentConfirmationPage opcp;
	private static final Logger logger = Logger.getLogger(ScreenshotTest.class.getName());
	
	@Before
	public void starting(){
		setUpMainPage();
	}
	
	@Test
	public void takeScreenshot() throws IOException {
		Utilities.takeScreenShoot(driver);
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done. Quiting browser");
		driver.quit();
	}
}
