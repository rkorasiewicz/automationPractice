package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePageObject {
	
	public OrderSummaryPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[id='cart_title']")
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
