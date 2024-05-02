package PageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constants;
import io.cucumber.messages.types.Duration;

public class LoginPage {
	
	private WebDriver driver;

	
	private By userName = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("login");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void getLoginPage()
	{
		driver.get(Constants.baseUrl);
	}

	public String getLoginPageTitle()
	{
		return driver.getTitle();
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
    
 	
}
