package PageObjects;

import java.sql.Timestamp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class dashboardPage {
	private WebDriver driver;
	private By manageprgheader = By.xpath(" //div[normalize-space()='Manage Program']");
	private By LearningManagementSystem = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	private By programbutton = By.xpath(" //span[normalize-space()='Program']");
	private By batchbutton = By.xpath("//span[normalize-space()='Batch']");
	private By userbutton = By.xpath("//span[normalize-space()='User']");
	private By logoutbutton = By.xpath("//span[normalize-space()='Logout']");

	public dashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	


	public String getManageprogrameBtnLabelText() {

		return driver.findElement(manageprgheader).getText().trim();
	}
	

	@SuppressWarnings("null")
	public long navigation_Time() {
		long start = System.currentTimeMillis();
		start = (int) (start / 1000) % 60;
		long totalTime;
		WebElement ele = driver.findElement(manageprgheader);
		if (ele.isDisplayed()) {
			long finish = System.currentTimeMillis();
			finish = (int) (finish / 1000) % 60;
			totalTime = finish - start;
			return totalTime;
		} else {
			return totalTime = (Long) null;
		}

	}

	public String getLearningManagementSystemTitle() {

		return driver.findElement(LearningManagementSystem).getText().trim();
	}

	public String getProgrambuttonlink() {

		return driver.findElement(programbutton).getText().trim();
	}

	public String getbatchbuttonlink() {

		return driver.findElement(batchbutton).getText().trim();
	}

	public String getuserbuttonlink() {

		return driver.findElement(userbutton).getText().trim();
	}

	public String getlogoutbuttonlink() {

		return driver.findElement(logoutbutton).getText().trim();
	}

	public void getorder(int i, String btnNames) {
		driver.findElement(programbutton).click();
		WebElement e = driver.findElement(By.xpath("//button[" + i + "]//span[1][@class='mat-button-wrapper']"));
		System.out.println(e);
		if (e.isDisplayed()) {
			Assert.assertTrue(e.getText().trim().contains(btnNames),
					btnNames + " button is not displayed in " + i + " order");
			System.out.println(btnNames + " button is displayed in order:" + i);
		} else {
			System.out.println(btnNames + "element is not displayed");
		}
	}
	
	
	public String getProgrambuttonFieldposition() {
		WebElement e = driver.findElement(programbutton);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	public String getBatchbuttonFieldposition() {
		WebElement e = driver.findElement(batchbutton);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	public String getUserbuttonFieldposition() {
		WebElement e = driver.findElement(By.xpath("//button[@id='user']"));
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	public String getLogoutbuttonFieldposition() {
		WebElement e = driver.findElement(logoutbutton);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	public String getLMSTitleposition() {
		WebElement e = driver.findElement(LearningManagementSystem);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
		
	}
	
	
	
	
}
