package Tests;

import PageObjects.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	public void takeScreenshot() throws IOException{
		String testScreen = "test_screenshot";
		File filePathString = new File(Utilities.getScreenPath()+testScreen+".png");
		logger.info("Screenshot path is " + filePathString +"\n" + "Deleting previous screenshot if exists");
		if (filePathString.isFile()){
			filePathString.delete();
			assertTrue(!filePathString.exists());
		}
		
		logger.info("Creating screenshot");
		Utilities.takeScreenShoot(driver, testScreen);
		if (!filePathString.isFile()){
			fail("Screenshot hasn't been created");
		}
		logger.info("Screenshot has been created");
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done. Quiting browser");
		driver.quit();
	}
}
