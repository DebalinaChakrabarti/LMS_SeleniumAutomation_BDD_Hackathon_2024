package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class editPgmPg {
	
	private WebDriver driver;

	private By programLink =By.id("program");
	private By pgmname =By.id("programName");
	private By desc =By.id("programDescription");
	private By sortone =By.xpath("//p-sorticon[@field='programName']");
	private By stsone =By.xpath("//body[1]/app-root[1]/app-program[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[3]/div[2]/p-radiobutton[1]/div[1]");
	private By ststwo =By.xpath("//body[1]/app-root[1]/app-program[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[3]/div[3]/p-radiobutton[1]/div[1]");
	private By saveBtn =By.xpath("//span[normalize-space()='Save']");
	private By editIcon =By.id("editProgram");
	private By pgmDetailwin =By.id("pr_id_2-label");
	private By cancelBtn =By.xpath("//span[normalize-space()='Cancel']");
	private By Pgmtxt =By.xpath("//div[normalize-space()='Manage Program']");
	private By toastmsg =By.xpath("//div[@role='alert']");
	private By PgmNameErrinvalid =By.xpath("//small[contains(text(),'This field should start with an alphabet, no speci')]");
	private By PgmDescErrinvalid =By.xpath("//small[contains(text(),'This field should start with an alphabet and min 2')]");
	

	
	public editPgmPg(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProgramLink() {
		driver.findElement(programLink).click();
	}
	
	public String getPgmPageTitletxt()
	{
		return driver.findElement(Pgmtxt).getText();
	}
	
	public void clickEdit() {
		driver.findElement(editIcon).click();
	}
		
	public void clickEditByname(String PgmName) {
		By editIconByname =By.xpath("//td[normalize-space()='"+PgmName+"']//following-sibling::td//button[1]");
		driver.findElement(editIconByname).click();
	}
	
	public String getPgmEditWin()
	{
		return driver.findElement(pgmDetailwin).getText();
	}
	
	public void clearPgmName() {
		driver.findElement(pgmname).clear();;
	}
	
	public void clearDesc() {
		driver.findElement(desc).clear();;
	}
	
	public void EnterPgmName(String name ) throws InterruptedException {
		WebElement Pgmname = driver.findElement(pgmname);
		Actions action = new Actions(driver);
		action.sendKeys(Pgmname, name).build().perform();
	}
	public void EnterPgmdesc(String PgmDesc ) throws InterruptedException {
		WebElement Pgmdesc = driver.findElement(desc);
		Actions action = new Actions(driver);
		action.sendKeys(Pgmdesc, PgmDesc).build().perform();
	}
		
	
	public void ClickStatusActive(String status ) throws InterruptedException {
		System.out.println(driver.findElement(stsone).isEnabled());
					driver.findElement(stsone).click();
	}
	  
	public void ClickStatusInActive(String status ) throws InterruptedException {

			System.out.println(driver.findElement(ststwo).isEnabled());
			driver.findElement(ststwo).click();
	}
	
	public void clickPgmnamesort() {
	    driver.findElement(sortone).click();
    }
	
	public void clicksave() {
	    driver.findElement(saveBtn).click();
    }
	
	public void cancelBtn() {
	    driver.findElement(cancelBtn).click();
    }
	
	public String pgmNameErrInvalid()
	{
		return driver.findElement(PgmNameErrinvalid).getText();
	}
	
	public String pgmDescErrInvalid()
	{
		return driver.findElement(PgmDescErrinvalid).getText();
	}
	
	public String toastMsg()
	{
		return driver.findElement(toastmsg).getText();
	}
	
}
