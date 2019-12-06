package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage extends BasePageObject {
	
	public OrderShippingPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement cartTitle;
	
	@FindBy(css = "input[name='cgv']")
	private WebElement termsOfService;
	
	@FindBy(css = "button[name='processCarrier']")
	private WebElement proceedButton;
	
	public String getTextOfCartTitle(){
		return cartTitle.getText();
	}
	
	public void proceedButtonClick(){
		proceedButton.click();
	}
	
	public void termsOfServiceTick(){
		termsOfService.click();
	}
	
}
