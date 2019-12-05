package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[id='email_create']")
	private WebElement email;
	
	@FindBy(css = "input[id='email']")
	private WebElement emailForLogin;
	
	@FindBy(css = "input[id='passwd']")
	private WebElement passwordForLogin;
	
	@FindBy(css = "button[id='SubmitCreate']")
	private WebElement createAccountButton;
	
	@FindBy(css = "h1[class='page-heading']")
	private WebElement authenticationHeader;
	
	@FindBy(css = "button[name='SubmitLogin']")
	private WebElement signInButton;
	
	public void emailProvide(String str){
		email.sendKeys(str);
	}
	
	public void createAccountButtonClick(){
		createAccountButton.click();
	}
	
	public String getAuthenticationHeader() {
		return authenticationHeader.getText();
	}
	
	public void emailForLoginProvide(String email){
		emailForLogin.sendKeys(email);
	}
	
	public void passwordForLoginProvide(String password) {
		passwordForLogin.sendKeys(password);
	}
	
	public void signInButtonClick(){
		signInButton.click();
	}
}
