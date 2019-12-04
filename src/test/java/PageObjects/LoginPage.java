package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[name='username']")
	private WebElement email;
	
	@FindBy(css = "input[name='password']")
	private WebElement password;
	
	@FindBy(linkText = "Login")
	private WebElement loginButton;
	
	@FindBy(css = "label[for='remember-me']")
	private WebElement rememberMeButton;
	
	public void emailProvide(String str){
		email.sendKeys(str);
	}
	
	public void passwordProvide(String str){
		password.sendKeys(str);
	}
	
	public void loginButtonClick(){
		loginButton.click();
	}
	
	public void rememeberMeButtonClick(){
		rememberMeButton.click();
	}
}
