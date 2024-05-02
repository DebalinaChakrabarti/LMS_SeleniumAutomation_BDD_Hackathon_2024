package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.Constants;

public class manageProgramPage {
	
	private WebDriver driver;
	
	private By userName = By.xpath("//input[@id='username']");
	private By password = By.id("password");
	private By loginButton = By.id("login");
	
	private By Pgmlink = By.xpath("//*[@id=\"program\"]");
	private By Pgmtxt =By.xpath("//div[normalize-space()='Manage Program']");
	private By Pgtntxt =By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By Fttxt =By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	private By muldltbtn =By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']");
	private By newPgm =By.xpath("//button[@id='new']");
	private By pgmName =By.xpath("//th[normalize-space()='Program Name']");
	private By pgmDesc =By.xpath("//th[normalize-space()='Program Description']");
	private By Pgmst =By.xpath("//th[normalize-space()='Program Status']");
	private By edtdlt =By.xpath("//th[normalize-space()='Edit / Delete']");
	private By sortone =By.xpath("//p-sorticon[@field='programName']");
	private By sortwo =By.xpath("//p-sorticon[@field='description']");
	private By sortthr =By.xpath("//p-sorticon[@field='status']");
	private By chkone =By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	private By chktwo =By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	private By chkthr =By.xpath("//tbody/tr[3]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	private By chkfour =By.xpath("//tbody/tr[4]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	private By chkfive =By.xpath("//tbody/tr[5]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	private By editicon =By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[1]");
	private By dlticon =By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[2]");
	private By srchbox =By.xpath("//input[@id='filterGlobal']");

	
	public manageProgramPage(WebDriver driver) {
		this.driver = driver;
	}
	//Login steps


	public void getLoginPage()
	{
		driver.get(Constants.baseUrl);
	}
	public void setUserName(String uname)
	{
		 driver.findElement(userName).sendKeys(uname);
	}
	public void setPassword(String passwd)
	{
		driver.findElement(password).sendKeys(passwd);
	}
  
	public void clickOnLoginButton() {
	    driver.findElement(loginButton).click();
    }
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}

	
	//Validating Program page
	
		
	public String getdashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickprogramLink() {
	    driver.findElement(Pgmlink).click();
    }
	
	public boolean getPgmPageTitle()
	{
		return driver.findElement(Pgmtxt).isDisplayed();
	}
	
	public String getPgmPageTitletxt()
	{
		return driver.findElement(Pgmtxt).getText();
	}
	
	public boolean getPaginationtxt()
	{
		return driver.findElement(Pgtntxt).isDisplayed();	
	}
	
	public boolean getFootertxt()
	{
		return driver.findElement(Fttxt).isDisplayed();		
	}

	public boolean multDelBtn()
	{
		return driver.findElement(muldltbtn).isDisplayed();	
	}

	public boolean newPgmBtn()
	{
		return driver.findElement(newPgm).isDisplayed();	
	}
	
	//Datatable header validation
	public boolean pgmName()
	{
		return driver.findElement(pgmName).isDisplayed();	
	}
	
	public boolean pgmDesc()
	{
		return driver.findElement(pgmDesc).isDisplayed();	
	}
	
	public boolean Pgmsts()
	{
		return driver.findElement(Pgmst).isDisplayed();	
	}
	
	public boolean edtdlt()
	{
		return driver.findElement(edtdlt).isDisplayed();	
	}
	
	//Sort icon validation
	public boolean srtOne()
	{
		return driver.findElement(sortone).isDisplayed();	
	}
	
	public boolean srtTwo()
	{
		return driver.findElement(sortwo).isDisplayed();	
	}
	
	public boolean srtThr()
	{
		return driver.findElement(sortthr).isDisplayed();	
	}
	
	//Checkbox validation
	
	public boolean chkOne()
	{
		return driver.findElement(chkone).isDisplayed();	
	}
	
	public boolean chkTwo()
	{
		return driver.findElement(chktwo).isDisplayed();	
	}
	
	public boolean chkThr()
	{
		return driver.findElement(chkthr).isDisplayed();	
	}
	
	public boolean chkFour()
	{
		return driver.findElement(chkfour).isDisplayed();	
	}
	
	public boolean chkFive()
	{
		return driver.findElement(chkfive).isDisplayed();	
	}
	
	//edit and delete icon validation
	public boolean editicon()
	{
		return driver.findElement(editicon).isDisplayed();	
	}
	
	public boolean deleteicon()
	{
		return driver.findElement(dlticon).isDisplayed();	
	}
	
	//Searchbox validation
	public boolean srchBox()
	{
		return driver.findElement(srchbox).isDisplayed();	
	}
	
	public String srchtxt()
	{
		return driver.findElement(srchbox).getAttribute("placeholder");	
	}
	
}
