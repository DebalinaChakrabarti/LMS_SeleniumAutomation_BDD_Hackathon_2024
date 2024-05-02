package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import Utilities.Constants;

public class loginpage {
	private WebDriver driver;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");
	private By errorMessage = By.xpath("//mat-error[@id='errormessage']");
	private By errorMessage1 = By.xpath("//mat-form-field[1]/div/div[3]/div/mat-error");
	private By errorMessage2 = By.xpath("//mat-form-field[2]/div/div[3]/div/mat-error");
	private By logout = By.xpath("//*[@id=\"logout\"]/span[1]");
	private By loginPageImage = By.xpath("/html/body/app-root/app-login/div/div/img");
	private By LoginHeadingText = By.xpath("//p[normalize-space()='Please login to LMS application']");
	private By userfieldLabel = By.xpath("//span[@class='mat-form-field-label-wrapper ng-tns-c78-0']");
	private By passwordfieldLabel = By.xpath("//span[@class='mat-form-field-label-wrapper ng-tns-c78-1']");
	private By loginbtnLabel = By.xpath("//*[@id=\"login\"]/span[1]");
	private By pageNotFoundErrMsg = By.xpath("/html/body/div[2]/div");
	private By usercolor = By.xpath("(//span[@class='ng-tns-c78-0 ng-star-inserted'])[1]");
	private By passwordcolor = By.xpath("(//span[@class='ng-tns-c78-1 ng-star-inserted'])[1]");
	private By logoimage = By.xpath("/html/body/app-root/app-login/div/div/img");
	private By loginFieldsPosition = By.xpath("/html/body/app-root/app-login/div/mat-card");
	

	
	public loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void getloginUrl() {
		driver.get(Constants.baseUrl);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}


	public String getLoginHeadingText() {
		return driver.findElement(LoginHeadingText).getText().trim();

	}

	public boolean userNameFieldExist() {
		return driver.findElement(username).isDisplayed();
	}

	public boolean passwordFieldExist() {
		return driver.findElement(password).isDisplayed();
	}

	public boolean usernameLabelExist() {
		return driver.findElement(userfieldLabel).isDisplayed();
	}

	public String getusernameLabelText() {
		return driver.findElement(userfieldLabel).getText().trim();
	}

	public boolean LoginHeadingTextFieldExist() {
		return driver.findElement(LoginHeadingText).isDisplayed();
	}

	public boolean passwordLabelFieldExist() {
		return driver.findElement(passwordfieldLabel).isDisplayed();
	}

	public String getpasswordLabelText() {
		return driver.findElement(passwordfieldLabel).getText().trim();
	}

	public boolean loginButtonExists() {
		return driver.findElement(login).isDisplayed();
	}

	public String getloginBtnLabelText() {
		return driver.findElement(loginbtnLabel).getText().trim();
	}

	public String getPageNotFoundText() {
		return driver.findElement(pageNotFoundErrMsg).getText().trim();
	}

	

	public String getusercolorText() {
		WebElement test = driver.findElement(usercolor);
		String s = test.getCssValue("color");

		System.out.println("Color is :" + s);

	      return s;
	}

	public String getpasswordcolorText() {
		WebElement test = driver.findElement(passwordcolor);
		String s = test.getCssValue("color");

		System.out.println("Color is :" + s);

	      return s;
	}


	public String getLoginErrorMgs() {
		if (driver.findElement(errorMessage).isDisplayed()) {
			System.out.println("Expected error message 'invalid credentials' element exists");
			return driver.findElement(errorMessage).getText().trim();
		} else if (driver.findElement(errorMessage1).isDisplayed()) {
			System.out.println("Expected error message 'Enter username' element exists");
			return driver.findElement(errorMessage1).getText().trim();
		} else if (driver.findElement(errorMessage2).isDisplayed()) {
			System.out.println("Expected error message 'Enter password' element exists");
			return driver.findElement(errorMessage1).getText().trim();
		}

		else {
			System.out.println("Expected error message element not exists");
			return null;
		}
	}

	public void EnterUserName(String Uname) throws InterruptedException {
		WebElement Username = driver.findElement(username);
		Actions action = new Actions(driver);
		action.sendKeys(Username, Uname).build().perform();
	}

	public void EnterPassword(String Pwd) throws InterruptedException {
		WebElement pwd = driver.findElement(password);
		Actions action = new Actions(driver);
		action.sendKeys(pwd, Pwd).build().perform();
	}


	public void clickOnloginButton() {
		driver.findElement(login).click();
	}

	public WebElement returnlogoutbutton() {
		return driver.findElement(logout);
	}

	public void getinvalidloginUrl() {
		driver.get(Constants.invalidbaseUrl);
	}

	public void clickOnloginButtonThroughKeypad() {
		driver.findElement(login).sendKeys(Keys.RETURN);
	}
	

	
	public String getloginfieldsposition() {
		WebElement e = driver.findElement(loginFieldsPosition);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	
	
	public String getloginimage() {
		WebElement e = driver.findElement(logoimage);
		String elementsource = e.getAttribute("src");
		return elementsource;
		
	}
	
	
}