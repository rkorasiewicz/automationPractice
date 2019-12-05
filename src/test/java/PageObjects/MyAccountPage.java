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
	
	public WebElement getCustomerAccount() {
		return customerAccount;
	}
}
