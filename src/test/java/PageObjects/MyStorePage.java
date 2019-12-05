package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage extends BasePageObject {
	
	public MyStorePage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "a[class='login']")
	private WebElement signUpButton;
	
	public void signUpButtonClick(){
		signUpButton.click();
	}
}
