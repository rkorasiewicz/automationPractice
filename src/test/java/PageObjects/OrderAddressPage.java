package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage extends BasePageObject {
	
	public OrderAddressPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement cartTitle;
	
	@FindBy(xpath = "//span[.='Proceed to checkout']")
	private WebElement proceedButton;
	
	public String getTextOfCartTitle(){
		return cartTitle.getText();
	}
	
	public void proceedButtonClick(){
		proceedButton.click();
	}
	
}
