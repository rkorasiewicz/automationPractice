package Tests;

public class Utilities {
	private static final String mainPagePath = "http://automationpractice.com/index.php";
	private static final String chromePath = "resources\\chromedriver.exe";
	
	public static String getChromePath() {
		return chromePath;
	}
	
	public String getMainPagePath(){
		return mainPagePath;
	}

}
