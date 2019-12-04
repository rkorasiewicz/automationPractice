package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePageObject {
	
	public MyAccountPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "img[class='img-responsive go-right img-thumbnail']")
	private WebElement avatar;
	
	public WebElement getAvatar() {
		return avatar;
	}
}
