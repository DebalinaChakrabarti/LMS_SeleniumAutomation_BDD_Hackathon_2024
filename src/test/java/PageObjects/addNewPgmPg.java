package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addNewPgmPg {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	private By Pgmlink = By.xpath("//*[@id=\"program\"]");
	private By Pgmtxt =By.xpath("//div[normalize-space()='Manage Program']");
	private By pgmDetailwin =By.id("pr_id_2-label");
	private By newpgmlink =By.xpath("//button[@id='new']");
	private By cancelBtn =By.xpath("//span[normalize-space()='Cancel']");
	private By saveBtn =By.xpath("//span[normalize-space()='Save']");
	private By pgmName =By.xpath("//input[@id='programName']");
	private By desc =By.id("programDescription");
	private By stsone =By.xpath("//body[1]/app-root[1]/app-program[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[3]/div[2]/p-radiobutton[1]/div[1]");
	private By ststwo =By.xpath("//body[1]/app-root[1]/app-program[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[3]/div[3]/p-radiobutton[1]/div[1]");
	private By closeIcon =By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']");
	private By PgmNameErr =By.xpath("//small[normalize-space()='Program name is required.']");
	private By PgmDescErr =By.xpath("//small[normalize-space()='Description is required.']");
	private By PgmNameErrinvalid =By.xpath("//small[contains(text(),'This field should start with an alphabet, no speci')]");
	private By PgmDescErrinvalid =By.xpath("//small[contains(text(),'This field should start with an alphabet and min 2')]");
	private By PgmStsErr =By.xpath("//small[normalize-space()='Status is required.']");
	private By toastmsg =By.xpath("//div[@role='alert']");
	private By toastmsgcls =By.xpath("//button[@class='p-toast-icon-close p-link ng-tns-c90-20 p-ripple ng-star-inserted']");
		

	public addNewPgmPg(WebDriver driver) {
		this.driver = driver;
	}

	public String getPgmPageTitletxt()
	{
		return driver.findElement(Pgmtxt).getText();
	}
	
	public String getdashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPgmEditWin()
	{
		return driver.findElement(pgmDetailwin).getText();
	}
	
	public void clickprogramLink() {
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("program"))).click();

//		WebElement PgmLink = wait.until(elementToBeClickable(WebElement Pgmlink));
//		PgmLink.click();
	    driver.findElement(Pgmlink).click();
    }
	
	public void clickanewpgmLink() {
	    driver.findElement(newpgmlink).click();
    }
	
	public void closeanewpgm() {
	    driver.findElement(closeIcon).click();
    }
	
	public boolean cancelBtn()
	{
		return driver.findElement(cancelBtn).isDisplayed();	
	}
	
	public boolean saveBtn()
	{
		return driver.findElement(saveBtn).isDisplayed();	
	}
	
	public boolean name()
	{
		return driver.findElement(pgmName).isDisplayed();	
	}
	
	public boolean desc()
	{
		return driver.findElement(desc).isDisplayed();	
	}
	
	public boolean stsone()
	{
		return driver.findElement(stsone).isDisplayed();	
	}
	
	public boolean ststwo()
	{
		return driver.findElement(ststwo).isDisplayed();	
	}
	
	public void clicksave() {
	    driver.findElement(saveBtn).click();
    }
	
	
	public void EnterPgmName(String name ) throws InterruptedException {
		WebElement Pgmname = driver.findElement(pgmName);
		Actions action = new Actions(driver);
		action.sendKeys(Pgmname, name).build().perform();
	}
	
	public void EnterPgmdesc(String description ) throws InterruptedException {
		WebElement Pgmdesc = driver.findElement(desc);
		Actions action = new Actions(driver);
		action.sendKeys(Pgmdesc, description).build().perform();
	}
		
	
	public void ClickStatusActive(String status ) throws InterruptedException {
		System.out.println(driver.findElement(stsone).isEnabled());
					driver.findElement(stsone).click();
	}
	  
	public void ClickStatusInActive(String status ) throws InterruptedException {

			System.out.println(driver.findElement(ststwo).isEnabled());
			driver.findElement(ststwo).click();
	}
	
	
	
	public String pgmNameErr()
	{
		return driver.findElement(PgmNameErr).getText();
	}
	public String pgmDescErr()
	{
		return driver.findElement(PgmDescErr).getText();
	}
	
	public String pgmNameErrInvalid()
	{
		return driver.findElement(PgmNameErrinvalid).getText();
	}
	public String pgmDescErrInvalid()
	{
		return driver.findElement(PgmDescErrinvalid).getText();
	}
	
	public String pgmStsErr()
	{
		return driver.findElement(PgmStsErr).getText();
	}
	
	public String toastMsg()
	{
		return driver.findElement(toastmsg).getText();
	}
	public void closeToast() {
	    driver.findElement(toastmsgcls).click();
    }
}
