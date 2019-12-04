package Tests;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.MyAccountPage;
import PageObjects.RegisterPage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class BaseTest {
	
	public static WebDriver driver;
	private MainPage mp;
	private RegisterPage rp;
	private MyAccountPage map;
	private Utilities utilities;
	private LoginPage lp;
	
	private String name = "Adam";
	private String lastName = "Bondar";
	private String phone = "123456789";
	private String email = "1khalid-l7ob3@calfocus.com";
	private String password = "dwertyksa34!";
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	public BaseTest() {
	}
	
	public static WebDriver setUpBrowser() {
		Utilities util = new Utilities();
		System.setProperty("webdriver.chrome.driver", util.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	protected String getRandomEmail() {
		String RANDOMCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * RANDOMCHARS.length());
			salt.append(RANDOMCHARS.charAt(index));
		}
		String randomEmail = salt.toString();
		return randomEmail;
	}
	
	public void registration () throws IOException {
		mp = new MainPage();
		rp = new RegisterPage();
		map = new MyAccountPage();

		mp.myAccountButtonClick();
		mp.signUpButtonClick();
		
		assertEquals("Register", driver.getTitle());
		logger.info("Start providing data to registration form");
		rp.firstNameProvide(name);
		rp.lastNameProvide(lastName);
		rp.phoneProvide(phone);
		String randomEmail = getRandomEmail()+"@yahoo.com";
		rp.emailProvide(randomEmail);
		logger.info("Saving generated email to external excel file");
		setValuesInExcel("email", randomEmail);
		rp.passwordProvide(getValuesFromExcel("email", "Registration"));
		rp.confirmPasswordProvide(getValuesFromExcel("email", "Registration"));
		rp.signUpButtonClick();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(map.getAvatar()));
		assertEquals("My Account", driver.getTitle());
	}
	
	public void login() throws IOException {
		mp = new MainPage();
		lp = new LoginPage();
		
		mp.myAccountButtonClick();
		mp.loginButtonClick();
		assertEquals("Login", driver.getTitle());
		
		lp.emailProvide(getValuesFromExcel("email", "Registration"));
		lp.passwordProvide(getValuesFromExcel("password", "Registration"));
		lp.rememeberMeButtonClick();
		lp.loginButtonClick();
		
		assertEquals("Login", driver.getTitle());
	}
	
	public void setValuesInExcel(String fieldName, String valueToBeSaved) throws IOException {
		File file = new File(utilities.getDataForTestExecutingPath());
		FileInputStream fis = new FileInputStream(file);
		Workbook credentials = null;
		String fileExtensionName = file.getName().substring(file.getName().indexOf("."));
		if (fileExtensionName.equalsIgnoreCase(".xlsx")){
			credentials = new XSSFWorkbook(fis);
		}
		if (fileExtensionName.equalsIgnoreCase(".xls")) {
			credentials = new HSSFWorkbook(fis);
		}
		Sheet credentialsSheet = credentials.getSheet("Registration");
		
		int rowCount = credentialsSheet.getLastRowNum() - credentialsSheet.getFirstRowNum();
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = credentialsSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getStringCellValue().equalsIgnoreCase(fieldName)) {
					row.getCell(j + 1).setCellValue(valueToBeSaved);
				}
			}
		}
		FileOutputStream fileOut = new FileOutputStream(utilities.getDataForTestExecutingPath());
		credentials.write(fileOut);
		fileOut.close();
	}
	
	public String getValuesFromExcel(String fieldName, String sheetName) throws IOException {
		String answer = "";
		DataFormatter dataFormatter = new DataFormatter();
		File file = new File(utilities.getDataForTestExecutingPath());
		FileInputStream fis = new FileInputStream(file);
		Workbook credentials = null;
		String fileExtensionName = file.getName().substring(file.getName().indexOf("."));
		if (fileExtensionName.equalsIgnoreCase(".xlsx")){
			credentials = new XSSFWorkbook( fis );
		}
		if (fileExtensionName.equalsIgnoreCase(".xls")){
			credentials = new HSSFWorkbook(fis);
		}
		Sheet credentialsSheet = credentials.getSheet(sheetName);
		
		int rowCount = credentialsSheet.getLastRowNum() - credentialsSheet.getFirstRowNum();
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = credentialsSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++){
				String formatted = dataFormatter.formatCellValue(row.getCell(j));
				String formattedCell = dataFormatter.formatCellValue(row.getCell(j+1));
				if (formatted.equals(fieldName)) {
					answer = formattedCell;
				}
			}
		}
		return answer;
	}
	
}
