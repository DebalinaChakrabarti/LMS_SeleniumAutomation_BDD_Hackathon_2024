package PageObjects;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class editUserPage {

	private WebDriver driver;
	
 
	private By user = By.id("user");
	private By searchBox = By.id("filterGlobal");
	private By edit = By.xpath("//tbody/tr[1]/td[6]/div[1]/span[1]/button[1]/span[1]");
	private By userPopUp = By.xpath("//span[contains(text(), 'User Details')]");
	private By fName = By.xpath("//input[@data-placeholder='First name']");
	private By mName = By.xpath("//input[@data-placeholder='Middle name']");
	private By lName = By.xpath("//input[@data-placeholder='Last name']");
	private By location = By.xpath("//input[@data-placeholder='Location']");
	private By ph = By.xpath("//input[@data-placeholder='Phone no']");
	private By email = By.xpath("//input[@data-placeholder='Email address']");
	private By tymZone = By.xpath("//input[@data-placeholder='Time Zone']");
	private By updateMsg = By.xpath("//div[@role='alert']");
	private By failedMsg = By.xpath("//div[@role='alert']");
	
	public editUserPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
//----------- below functions to click on elements -------	

	 public void clickOnUserTab() {
		    driver.findElement(user).click();
	 }

	 public void clickOnEdit() {
		    driver.findElement(edit).click();
	 }
	 public void getsucessUpdateMsg() {
			driver.findElement(updateMsg).getText();
		}
	 
	 public void getfailedUpdateMsg() {
			driver.findElement(failedMsg).getText();
		}

		// -------- below functions for getting If page elements are displayed--------	
				
	 public String searchUser() {
		   WebElement sBox = driver.findElement(searchBox);
		   sBox.clear();
		   sBox.sendKeys("TestLMS");
		return sBox.getAttribute("value");
	         }
	 
	 public void clearFeildNames() {
		 driver.findElement(mName).clear();
		 driver.findElement(lName).clear();
		 driver.findElement(location).clear();
		 driver.findElement(ph).clear();
		 driver.findElement(lName).clear();
		 driver.findElement(email).clear();
		 driver.findElement(tymZone).clear();
		 
		 
	 }
	 
	 
	 
	 
	 public boolean isUserDetailsPopupOpen() {
		
	 try {
	        WebElement userWin = driver.findElement(userPopUp);
	        System.out.println("Print the popUp Heading: " + userWin.getText());
	        return userWin.isDisplayed();
	        	        // Return true if the user pop-up element is displayed
	    } catch (NoSuchElementException e) {
	        // If the user pop-up element is not found, it means the pop-up is closed
	        return false;
	    }
}
}	
	      
		  
	

