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
	public void starting(){
		setUpMainPage();
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
		logger.info("Moving to T-shirts page");
		map.tShirtsClick();
		
		assertEquals("T-shirts - My Store", driver.getTitle());
		tsp.addToCartButtonHoverAndClick();
		assertTrue(tsp.getProductImageContainer().isDisplayed());
		logger.info("Moving to Order summary page");
		tsp.proceedButtonClick();
		
		assertEquals("Order - My Store", driver.getTitle());
		assertTrue(osump.getTextOfCartTitle().contains("SHOPPING-CART SUMMARY"));
		logger.info("Moving to Order address page");
		osump.proceedButtonClick();
		
		assertEquals("ADDRESSES", oap.getTextOfCartTitle());
		logger.info("Moving to Order shipping page");
		oap.proceedButtonClick();
		
		assertEquals("SHIPPING", osp.getTextOfCartTitle());
		osp.termsOfServiceTick();
		logger.info("Moving to Order payment page");
		osp.proceedButtonClick();
		
		assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", opp.getTextOfCartTitle());
		logger.info("Moving to Order payment summary page");
		opp.payByBankWireClick();
		
		assertEquals("ORDER SUMMARY", opsp.getTextOfCartTitle());
		logger.info("Moving to Order payment confirmation page");
		opsp.confirmOrderButtonClick();
		
		assertEquals("ORDER CONFIRMATION", opcp.getTextOfCartTitle());
		assertEquals("Your order on My Store is complete.", opcp.getConfirmationOrderText());
		logger.info("Signing out");
		opcp.signOutButtonClick();
	}
		
	@After
	public void cleanUp(){
		logger.info("Test is done. Quiting browser");
		driver.quit();
	}
}
