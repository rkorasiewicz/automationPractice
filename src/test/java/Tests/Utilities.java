package Tests;

import com.google.common.io.Files;
import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Utilities {
	private static final String MAIN_PAGE_PATH = "http://automationpractice.com/index.php";
	private static final String CHROME_PATH = "resources\\chromedriver.exe";
	private static final String SCREEN_PATH  = "resources\\screenshots\\";
	
	public static String getScreenPath() {
		return SCREEN_PATH;
	}
	
	public static String getChromePath() {
		return CHROME_PATH;
	}
	
	public String getMainPagePath(){
		return MAIN_PAGE_PATH;
	}
	
	public static void takeScreenShoot(WebDriver driver, String destFileName) throws IOException {
		File screenShoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenShoot, new File(SCREEN_PATH + destFileName + ".png"));
	}

}
