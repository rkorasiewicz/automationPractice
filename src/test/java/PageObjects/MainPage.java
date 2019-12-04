package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePageObject {
	
	public MainPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "a[class='login']")
	private WebElement signUpButton;
	
	public void signUpButtonClick(){
		signUpButton.click();
	}
}
