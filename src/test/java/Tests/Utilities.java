package Tests;

import java.util.logging.Logger;

public class Utilities {
	private static final String mainPagePath = "https://www.phptravels.net/";
	private static final String chromePath = "resources\\chromedriver.exe";
	private static final String dataForTestExecutingPath = "resources\\dataForTestExecuting.xlsx";
	
	public static String getChromePath() {
		return chromePath;
	}
	
	public String getMainPagePath(){
		return mainPagePath;
	}
	
	public static String getDataForTestExecutingPath() {
		return dataForTestExecutingPath;
	}
}
