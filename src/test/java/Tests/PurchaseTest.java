package Tests;

import PageObjects.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurchaseTest extends BaseTest {
	
	private Utilities utilities;
	private MyStorePage msp;
	private CreateAnAccountFormPage caafp;
	private LoginPage lp;
	private MyAccountPage map;
	private TShirtsPage tsp;
	private OrderSummaryPage osump;
	private OrderAddressPage oap;
	private OrderShippingPage osp;
	private OrderPaymentPage opp;
	private OrderPaymentSummaryPage opsp;
	private OrderPaymentConfirmationPage opcp;
	private static final Logger logger = Logger.getLogger(PurchaseTest.class.getName());
	
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
		map = new MyAccountPage();
		tsp = new TShirtsPage();
		osump = new OrderSummaryPage();
		oap = new OrderAddressPage();
		osp = new OrderShippingPage();
		opp = new OrderPaymentPage();
		opsp = new OrderPaymentSummaryPage();
		opcp = new OrderPaymentConfirmationPage();
		
		logIn();
		map.tShirtsClick();
		assertEquals("T-shirts - My Store", driver.getTitle());
		
		tsp.addToCartButtonHoverAndClick();
		assertTrue(tsp.getProductImageContainer().isDisplayed());
		tsp.proceedButtonClick();
		assertEquals("Order - My Store", driver.getTitle());
		
		assertTrue(osump.getTextOfCartTitle().contains("SHOPPING-CART SUMMARY"));
		osump.proceedButtonClick();
		
		assertEquals("ADDRESSES", oap.getTextOfCartTitle());
		oap.proceedButtonClick();
		
		assertEquals("SHIPPING", osp.getTextOfCartTitle());
		osp.termsOfServiceTick();
		osp.proceedButtonClick();
		
		assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", opp.getTextOfCartTitle());
		opp.payByBankWireClick();
		
		assertEquals("ORDER SUMMARY", opsp.getTextOfCartTitle());
		opsp.confirmOrderButtonClick();
		
		assertEquals("ORDER CONFIRMATION", opcp.getTextOfCartTitle());
		assertEquals("Your order on My Store is complete.", opcp.getConfirmationOrderText());
		opcp.signOutButtonClick();
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done");
		driver.quit();
	}
}
