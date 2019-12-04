package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountFormPage extends BasePageObject {
	
	public CreateAnAccountFormPage(){
		PageFactory.initElements(driver,this);
	}

	@FindBy (css = "div[id='uniform-id_gender1']")
	private WebElement mrRadioButton;
	
	@FindBy(css = "input[name='customer_firstname']")
	private WebElement firstName;
	
	@FindBy(css = "input[name='customer_lastname']")
	private WebElement lastName;
	
	@FindBy(css = "input[name='email']")
	private WebElement email;
	
	@FindBy(css = "input[name='passwd']")
	private WebElement password;
	
	@FindBy(css = "select[name='days']")
	private WebElement dayOfBirth;
	
	@FindBy(css = "select[name='months']")
	private WebElement monthOfBirth;
	
	@FindBy(css = "select[name='years']")
	private WebElement yearOfBirth;
	
	@FindBy(css = "input[id='firstname']")
	private WebElement addressFirstName;
	
	@FindBy(css = "input[id='lastname']")
	private WebElement addressLastName;
	
	@FindBy(css = "input[name='confirmpassword']")
	private WebElement confirmPassword;
	
	@FindBy(css = "button[type='submitAccount']")
	private WebElement registerButton;
	
	@FindBy(css = "input[id='address1']")
	private WebElement address;
	
	@FindBy(css = "input[id='city']")
	private WebElement city;
	
	@FindBy(css = "select[id='id_state']")
	private WebElement state;
	
	@FindBy(css = "select[id='postcode']")
	private WebElement zipCode;
	
	@FindBy(css = "select[id='phone_mobile']")
	private WebElement mobilePhone;
	
	@FindBy(css = "h3[class='page-subheading']")
	private WebElement yourPersonalInformationSubHeading;
	
	public void firstNameProvide(String str){
		firstName.sendKeys(str);
	}
	
	public void lastNameProvide(String str){
		lastName.sendKeys(str);
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
	
	public void registerButtonClick(){
		registerButton.click();
	}
	
	public void mrRadioButtonClick(){
		mrRadioButton.click();
	}
	
	public void addressFirstNameProvide(String str){
		addressFirstName.sendKeys(str);
	}
	
	public void addressLastNameProvide(String str){
		addressLastName.sendKeys(str);
	}
	
	public void addressProvide(String str){
		address.sendKeys(str);
	}
	
	public void cityProvide(String str){
		city.sendKeys(str);
	}
	
	public void stateNameSelectFromList(String stateName){
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText(stateName);
	}
	
	public void dayOfBirthSelect(int day){
		Select dropdown = new Select(dayOfBirth);
		dropdown.selectByValue(Integer.toString(day));
	}
	
	public void monthOfBirthSelect(int month){
		Select dropdown = new Select(monthOfBirth);
		dropdown.selectByValue(Integer.toString(month));
	}
	
	public void yearOfBirthSelect(int year){
		Select dropdown = new Select(yearOfBirth);
		dropdown.selectByValue(Integer.toString(year));
	}
	
	public void zipCodeProvide(int zipNumber){
		zipCode.sendKeys(Integer.toString(zipNumber));
	}
	
	public void mobilePhoneProvide(int mobileNumber){
		mobilePhone.sendKeys(Integer.toString(mobileNumber));
	}
	
	public String yourPersonalInformationSubHeadingRead() {
		return yourPersonalInformationSubHeading.getText();
	}
	
	public WebElement getYourPersonalInformationSubHeading() {
		return yourPersonalInformationSubHeading;
	}
}
