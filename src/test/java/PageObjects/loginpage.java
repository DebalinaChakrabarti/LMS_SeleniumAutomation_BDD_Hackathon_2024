package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.Constants;

public class loginpage {
	private WebDriver driver;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");
	private By errorMessage = By.xpath("//mat-error[@id='errormessage']");
	private By logout = By.xpath("//*[@id=\"logout\"]/span[1]");
	

	public loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void getloginUrl() {
		driver.get(Constants.baseUrl);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginErrorMgs() {
		return driver.findElement(errorMessage).getText().trim();
	}

	public void EnterUserName(String Uname ) throws InterruptedException {
		WebElement Username = driver.findElement(username);
		Actions action = new Actions(driver);
		action.sendKeys(Username, Uname).build().perform();
	}

	public void EnterPassword(String Pwd ) throws InterruptedException {
		WebElement pwd = driver.findElement(password);
		Actions action = new Actions(driver);
		action.sendKeys(pwd, Pwd ).build().perform();
	}
//	public void Entercredential(String  Uname ) and (String Pwd  ) throws InterruptedException {
//		WebElement Username = driver.findElement(username);
//		Actions action = new Actions(driver);
//		action.sendKeys(Username, Uname).build().perform();
//		WebElement pwd = driver.findElement(password);
//		action.sendKeys(pwd, Pwd ).build().perform();
//	}
	public void clickOnloginButton() {
		driver.findElement(login).click();
	}
	
	public WebElement returnlogoutbutton() {
		return driver.findElement(logout);
	}

}