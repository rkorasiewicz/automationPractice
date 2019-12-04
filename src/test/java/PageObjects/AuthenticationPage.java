package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePageObject {
	
	public AuthenticationPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[id='email_create']")
	private WebElement email;
	
	@FindBy(css = "button[id='SubmitCreate']")
	private WebElement createAccountButton;
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement authenticationHeader;
	
	public void emailProvide(String str){
		email.sendKeys(str);
	}
	
	public void createAccountButtonClick(){
		createAccountButton.click();
	}
	
	public String getAuthenticationHeader() {
		return authenticationHeader.getText();
	}
}
