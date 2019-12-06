package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentConfirmationPage extends BasePageObject {
	
	public OrderPaymentConfirmationPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement cartTitle;
	
	@FindBy(xpath = "(//div[@class='box'])/p/strong")
	private WebElement confirmationOrderText;
	
	@FindBy(xpath = "//span[.='I confirm my order']")
	private WebElement confirmOrderButton;
	
	@FindBy(css = "a[rel='nofollow']")
	private WebElement signOutButton;
	
	public String getTextOfCartTitle(){
		return cartTitle.getText();
	}
	
	public void confirmOrderButtonClick(){
		confirmOrderButton.click();
	}
	
	public String getConfirmationOrderText(){
		return confirmationOrderText.getText();
	}
	
	public void signOutButtonClick(){
		signOutButton.click();
	}
	
}
