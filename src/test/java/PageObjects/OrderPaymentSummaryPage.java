package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentSummaryPage extends BasePageObject {
	
	public OrderPaymentSummaryPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement cartTitle;
	
	@FindBy(xpath = "//span[.='I confirm my order']")
	private WebElement confirmOrderButton;
	
	public void getTextOfCartTitle(){
		cartTitle.getText();
	}
	
	public void confirmOrderButtonClick(){
		confirmOrderButton.click();
	}
	
}
