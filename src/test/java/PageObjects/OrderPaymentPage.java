package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage extends BasePageObject {
	
	public OrderPaymentPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement cartTitle;
	
	@FindBy(css = "a[title='Pay by bank wire']")
	private WebElement payByBankWire;
	
	public void getTextOfCartTitle(){
		cartTitle.getText();
	}
	
	public void payByBankWireClick(){
		payByBankWire.click();
	}
	
}
