package PageObjects;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;

public class BasePageObject {
	
	WebDriver driver;
	
	public BasePageObject(){
		this.driver = BaseTest.driver;
	}
}
