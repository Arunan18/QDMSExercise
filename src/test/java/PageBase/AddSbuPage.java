package PageBase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSbuPage {
	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement ClickMasterBtn;
	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY']")
	public static WebElement ClickSbuBtn;
	
	@FindBy(xpath = "//button[@type='button'][@class='ant-btn sc-gZMcBi dMdnOw']")
	public static WebElement AddSbuBtn;
	@FindBy(xpath = "//input[@id='sub_business_unit']")
	public static WebElement SbuName;
	@FindBy(xpath = "//input[@id='description']")
	public static WebElement SbuDes;
	@FindBy(xpath = "//button[@type='button'][@class='ant-btn sc-gZMcBi dMdnOw'][@style='background: rgb(0, 19, 40); color: white; border: none;']")
	public static WebElement Submit;
	
	@FindBy(xpath = "//button[@type='button'][@class='ant-btn']")
	public static WebElement CancelSbuBtn;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']//tr//td[1]")
	public static List<WebElement> SbuColumn;
	
	@FindBy(xpath = "//p[@style='color: white;']")
	public static WebElement SbuFormHeading;
	@FindBy(xpath = "//label[@for='sub_business_unit'][@class='label']")
	public static WebElement SbuNameHeading;
	@FindBy(xpath = "//label[@for='description'][@class='label']")
	public static WebElement SbuDescriptionHeading;
	@FindBy(xpath = "//span[@role='img'][@aria-label='close-circle']")
	public static WebElement CloseBtn;
}
