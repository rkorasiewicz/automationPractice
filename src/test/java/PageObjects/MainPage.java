package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePageObject {
	
	public MainPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "div[class='dropdown dropdown-login dropdown-tab']")
	private WebElement myAccountButton;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signUpButton;
	
	@FindBy(linkText = "Login")
	private WebElement loginButton;
	
	public void myAccountButtonClick(){
		myAccountButton.click();
	}
	
	public void signUpButtonClick(){
		signUpButton.click();
	}
	
	public void loginButtonClick(){
		loginButton.click();
	}
	
	
}
