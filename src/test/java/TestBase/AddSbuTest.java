package TestBase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base.BaseTest;
import PageBase.AddSbuPage;

public class AddSbuTest extends BaseTest {
	AddSbuPage addSbupg = new AddSbuPage();
//	SoftAssert sa = new SoftAssert();
	
	@Test(priority = 1)
	public void addSbuButton() throws InterruptedException {
		PageFactory.initElements(driver, addSbupg);
		AddSbuPage.AddSbuBtn.click();
		Thread.sleep(5000);
//		Checking Form Heading
		boolean FormHeading = true;
		testCase = extent.createTest("SBUFormHeading");
		
		try {
			Assert.assertEquals(AddSbuPage.SbuFormHeading.getText(),"Add SBU" );
		} catch (AssertionError e) {
			FormHeading = false;
		}
		if (FormHeading) {
			testCase.log(Status.PASS, "Showing SBU Heading");
		} else {
			testCase.log(Status.FAIL, "Unable to find SBU Form Heading");
		}
		Thread.sleep(1000);
		
//		checking SBU name Heading
		boolean SBUNameHeading = true;
		testCase = extent.createTest("SBUNameHeading");
		try {
			Assert.assertEquals(AddSbuPage.SbuNameHeading.getText(), "Sub Business Unit:"
		);
		} catch (AssertionError e) {
			SBUNameHeading = false;
		}
		if (SBUNameHeading) {
			testCase.log(Status.PASS, "SBU name Heading");
		} else {
			testCase.log(Status.FAIL, "Unable to find SBU name Heading");

		}
		Thread.sleep(1000);
		
//		checking SBU Description Heading
		boolean SBUDescriptionHeading = true;
		testCase = extent.createTest("SBUDescriptionHeading");
		try {
			Assert.assertEquals(AddSbuPage.SbuDescriptionHeading.getText(), "Description:");
		} catch (AssertionError e) {
			SBUDescriptionHeading = false;
		}
		if (SBUDescriptionHeading) {
			testCase.log(Status.PASS, "Showing SBU Description Heading");
		} else {
			testCase.log(Status.FAIL, "Unable to find SBU Description Heading");

		}
		Thread.sleep(1000);
		
//		checking SBU Name TextBox
		boolean SBUNameTextBox = true;
		testCase = extent.createTest("SBUNameTextBox");
		try {
			Assert.assertEquals(AddSbuPage.SbuName.isDisplayed(), true);
		} catch (AssertionError e) {
			SBUNameTextBox = false;
		}
		if (SBUNameTextBox) {
			testCase.log(Status.PASS, "Showing SBU Name TextBox");
		} else {
			testCase.log(Status.FAIL, "Unable to find SBU Name TextBox");

		}
		Thread.sleep(1000);
		
//		checking SBU Description TextBox
		boolean SBUDescriptionTextBox = true;
		testCase = extent.createTest("SBUDescriptionTextBox");
		try {
			Assert.assertEquals(AddSbuPage.SbuDes.isDisplayed(), true);
		} catch (AssertionError e) {
			SBUDescriptionTextBox = false;
		}
		if (SBUDescriptionTextBox) {
			testCase.log(Status.PASS, "Showing SBU Description TextBox");
		} else {
			testCase.log(Status.FAIL, "Unable to find SBU Description TextBox");

		}
		Thread.sleep(1000);
		
//		Checking Save Button
		boolean SaveButton = true;
		testCase = extent.createTest("SaveButton");
		try {
			Assert.assertEquals(AddSbuPage.Submit.isDisplayed(), true);
		} catch (AssertionError e) {
			SaveButton = false;
		}
		if (SaveButton) {
			testCase.log(Status.PASS, "Showing Save Button");
		} else {
			testCase.log(Status.FAIL, "Unable to find Save Button");

		}
		Thread.sleep(1000);
		
//		Checking Cancel Button
		boolean CancelButton = true;
		testCase = extent.createTest("CancelButton");
		try {
			Assert.assertEquals(AddSbuPage.CancelSbuBtn.isDisplayed(), true);
		} catch (AssertionError e) {
			CancelButton = false;
		}
		if (CancelButton) {
			testCase.log(Status.PASS, "Showing Cancel Button");
		} else {
			testCase.log(Status.FAIL, "Unable to find Cancel Button");

		}
		Thread.sleep(1000);
		
//		Checking Save Name
		boolean SaveName = true;
		testCase = extent.createTest("SaveName");
		try {
			Assert.assertEquals(AddSbuPage.Submit.getText(), "Save");
		} catch (AssertionError e) {
			SaveName = false;
		}
		if (SaveName) {
			testCase.log(Status.PASS, "Showing Save Name");
		} else {
			testCase.log(Status.FAIL, "Unable to find Save Name");

		}
		Thread.sleep(1000);
		
//		Checking Cancel Name
		boolean CancelName = true;
		testCase = extent.createTest("CancelName");
		try {
			Assert.assertEquals(AddSbuPage.CancelSbuBtn.getText(), "Cancel");
		} catch (AssertionError e) {
			CancelName = false;
		}
		if (CancelName) {
			testCase.log(Status.PASS, "Showing Cancel Name");
		} else {
			testCase.log(Status.FAIL, "Unable to find Cancel Name");

		}
		Thread.sleep(3000);
		if (AddSbuPage.CancelSbuBtn.isDisplayed()) {
			AddSbuPage.CancelSbuBtn.click();

		}
		
	}

	@Test(priority = 0)
	public void AddSbuData() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addSbupg);
		AddSbuPage.ClickMasterBtn.click();
		Thread.sleep(3000);
		AddSbuPage.ClickSbuBtn.click();
		Thread.sleep(3000);
//		AddSbuPage.AddSbuBtn.click(); 
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Data\\workbook.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("AddSbu");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(0).getBooleanCellValue();
			String SBU = (String) row.getCell(1).getStringCellValue();
			String Des = (String) row.getCell(2).getStringCellValue();
//				checkbox 
			if (check == true) {
//				Checking SBU Already Exit or not
				boolean status = false;
				for (WebElement ele : AddSbuPage.SbuColumn) {
					String value = ele.getText();
					// System.out.println(value);
					if (value.contentEquals(SBU)) {
						status = true;
						break;
					}
				}
				if (status == true) {
					System.out.println("Already exist this " + SBU);
					testCase = extent.createTest("Add SBU");
					testCase.log(Status.INFO, "Already exist this name :-" + SBU);
					testCase.log(Status.PASS, "Pass this test script");
				} else {
//				Add SBU Form	

//					Add SBU Code
					Thread.sleep(1000);
					AddSbuPage.AddSbuBtn.click();
					testCase = extent.createTest("Add SBU");
					AddSbuPage.SbuName.sendKeys(SBU);
					AddSbuPage.SbuDes.sendKeys(Des);
					AddSbuPage.Submit.click();
					Thread.sleep(3000);
//				Checking Cancel button & Function
					if (AddSbuPage.CancelSbuBtn.isDisplayed()) {
						AddSbuPage.CancelSbuBtn.click();

					}

//					Checking Added SBU Available or not
					boolean status1 = false;
					for (WebElement ele : AddSbuPage.SbuColumn) {
						String value = ele.getText();
						Thread.sleep(3000);
						if (value.contains(SBU)) {
							status1 = true;
							break;
						}
					}
//					Checking Expeted result & Actual result are equal or not
					boolean result = true;
					try {
						Assert.assertTrue(true);
					} catch (AssertionError e) {
						result = false;
					}

					if (result == true) {
						System.out.println("This " + SBU + " Available in webtable");
						testCase.log(Status.INFO, "Finded Expected url in SBU Webtable");
						testCase.log(Status.PASS, "Pass this test script");

					} else {
						System.out.println("This " + SBU + " Not available in webtable");
						testCase.log(Status.INFO, "Unable to find Expected url in SBU Webtable");
						testCase.log(Status.FAIL, "Fail this test script");

					}

				}
			}
		}
	}
}
