package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePageObject {
	
	public RegisterPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[name='firstname']")
	private WebElement firstName;
	
	@FindBy(css = "input[name='lastname']")
	private WebElement lastName;
	
	@FindBy(css = "input[name='phone']")
	private WebElement phone;
	
	@FindBy(css = "input[name='email']")
	private WebElement email;
	
	@FindBy(css = "input[name='password']")
	private WebElement password;
	
	@FindBy(css = "input[name='confirmpassword']")
	private WebElement confirmPassword;
	
	@FindBy(css = "button[type='submit']")
	private WebElement signUpButton;
	
	public void firstNameProvide(String str){
		firstName.sendKeys(str);
	}
	
	public void lastNameProvide(String str){
		lastName.sendKeys(str);
	}
	
	public void phoneProvide(String str){
		phone.sendKeys(str);
	}
	
	public void emailProvide(String str){
		email.sendKeys(str);
	}
	
	public void passwordProvide(String str){
		password.sendKeys(str);
	}
	
	public void confirmPasswordProvide(String str){
		confirmPassword.sendKeys(str);
	}
	
	public void signUpButtonClick(){
		signUpButton.click();
	}
	
}
