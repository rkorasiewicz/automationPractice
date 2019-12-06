package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage extends BasePageObject {
	
	public TShirtsPage(){
		PageFactory.initElements(driver,this);
	}
	
	//@FindBy(css = ".product-container")
	//private WebElement productContainer;
	
	@FindBy(css = "a[title='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(css = "img[title='Faded Short Sleeve T-shirts']")
	private WebElement productImageContainer;
	
	@FindBy(css = "a[title='Proceed to checkout']")
	private WebElement proceedButton;
	
	@FindBy(css = "h1[id='cart_title']")
	private WebElement cartTitle;
	
	//@FindBy(css = "div[id='layer_cart']")
	//private WebElement layerCard;
	
	public void addToCartClick(){
		addToCartButton.click();
	}
	
	public void addToCartButtonHoverAndClick(){
		Actions builder = new Actions(driver);
		builder.moveToElement(productImageContainer).perform();
		addToCartButton.click();
	}
	
	public void proceedButtonClick(){
		proceedButton.click();
	}
	
	public WebElement getProductImageContainer() {
		return productImageContainer;
	}
	
}
