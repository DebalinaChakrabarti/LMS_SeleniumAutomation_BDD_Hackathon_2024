package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	private WebDriver driver;
	private By logoutbutton = By.xpath("//span[normalize-space()='Logout']");
	
	
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogoutBtn()
	{
		driver.findElement(logoutbutton);
	}

	
	
	
	
}
