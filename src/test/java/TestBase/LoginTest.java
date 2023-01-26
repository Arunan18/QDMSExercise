package TestBase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.BaseTest;
import PageBase.LoginPage;


public class LoginTest extends BaseTest{

LoginPage loginpg = new LoginPage();
	
	@Test
	public void Login() throws InterruptedException, IOException  {
		
		PageFactory.initElements(driver, loginpg);
		
		Thread.sleep(2000);
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Data\\workbook.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("Login");
		
	    int rowcount = sheet.getLastRowNum();
	    for(int i=0; i<=rowcount;i++) {		
      XSSFRow row = sheet.getRow(i);	
      			
      		boolean check = (boolean)row.getCell(0).getBooleanCellValue();
			String uName = (String)row.getCell(1).getStringCellValue();
			String pWord = (String)row.getCell(2).getStringCellValue();
			
			
			//if(driver.getCurrentUrl().contains(URL)) {
		
			if (check==true) {
				LoginPage.Username.sendKeys(uName);
				LoginPage.Password.sendKeys(pWord);
				LoginPage.LoginButton.click();
				Thread.sleep(2500); 
			}
			
			
		}
		
	}
}
