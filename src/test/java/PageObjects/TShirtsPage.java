package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage extends BasePageObject {
	
	public TShirtsPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".product-container")
	private WebElement productContainer;
	
	@FindBy(css = "a[title='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(css = "div[id='layer_cart']")
	private WebElement layerCard;
	
	public void addToCartClick(){
		addToCartButton.click();
	}
	
}
