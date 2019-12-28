package Tests;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Utilities {
	private static final String MAIN_PAGE_PATH = "http://automationpractice.com/index.php";
	private static final String CHROME_PATH = "resources\\chromedriver.exe";
	private static final String SCREEN_PATH  = "resources\\screenshots\\screenshot.png";
	
	public static String getChromePath() {
		return CHROME_PATH;
	}
	
	public String getMainPagePath(){
		return MAIN_PAGE_PATH;
	}
	
	public static void takeScreenShoot(WebDriver driver) throws IOException {
		TakesScreenshot screenShoot = ((TakesScreenshot)driver);
		File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
		File destFile =new File(SCREEN_PATH);
		Files.copy(srcFile,destFile);
	}

}
