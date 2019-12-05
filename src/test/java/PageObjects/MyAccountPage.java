package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePageObject {
	
	public MyAccountPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "a[title='View my customer account']")
	private WebElement customerAccount;
	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	private WebElement tShirts;
	
	public WebElement getCustomerAccount() {
		return customerAccount;
	}
	
	public void tShirtsClick(){
		tShirts.click();
	}
}
