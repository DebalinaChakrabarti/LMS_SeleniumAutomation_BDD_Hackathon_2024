package PageObjects;



import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;



public class addUserPage {

	
	private static WebDriver driver;
	
 
	private By user = By.id("user");
	private By userPopup = By.id("pr_id_13-label");
	private By addUser = By.id("new");
	private By assignStu = By.xpath("//button[@label='Assign Student']");
	private By assignStaff = By.xpath("//button[@label='Assign Staff']");
	private By searchBox = By.id("filterGlobal");
	private By dTable = By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']");
	private By Rows = By.tagName("tr");
	private By chkBox = By.xpath("//div[@class='p-checkbox p-component']");
	private By edit = By.xpath("//tbody/tr/td[6]/div[1]/span[1]/button[1]");
	private By delete = By.xpath("//tbody/tr/td[6]/div[1]/span[1]/button[2]");
	private By searchResult = By.xpath("//td[normalize-space()='Testing Squad']"); 
	private static By close = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']");
	private static By submit = By.xpath("//span[@class='mat-button-wrapper' and text()='Submit']");
	private static By fName = By.xpath("//input[@data-placeholder='First name']");
	private static By mName = By.xpath("//input[@data-placeholder='Middle name']");
	private static By lName = By.xpath("//input[@data-placeholder='Last name']");
	private static By location = By.xpath("//input[@data-placeholder='Location']");
	private static By ph = By.xpath("//input[@data-placeholder='Phone no']");
	private static By email = By.xpath("//input[@data-placeholder='Email address']");
	private static By linkedInUrl= By.xpath("//input[@data-placeholder='LinkedIn Url']");
	private static By ug = By.xpath("//input[@data-placeholder='Under Graduate']");
	private static By pg = By.xpath("//input[@data-placeholder='Post Graduate']");
	private static By tymZone = By.xpath("//input[@data-placeholder='Time Zone']");
	private static By userComm = By.xpath("//input[@data-placeholder='User Comments']");
	private static By userRole = By.xpath("//div[contains(@class, 'dropdown')]/span[contains(text(), 'Role')]");
	private static By userStatus = By.xpath("//div[contains(@class, 'dropdown')]/span[contains(text(), 'Role Status')]");
	private static By visaStatus = By.xpath("//div[contains(@class, 'dropdown')]/span[contains(text(), 'Visa Status')]");
	private By sucessMsg = By.xpath("//div[text()='User Added Successfully']");
	private By errorMsg = By.xpath("/html[1]/body[1]/app-root[1]/app-user[1]/p-toast[1]/div[1]/p-toastitem[1]/div[1]/div[1]/div[1]/div[2]");
//	private By errorMsg1 = By.xpath("//*[contains(@id, 'mat-error-')]");
	private By cancle = By.xpath("//span[@class='mat-button-wrapper' and text()='Cancel']");

	
		public addUserPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
//----------- below functions to click on elements -------	

	 public void clickOnUserTab() {
		    driver.findElement(user).click();
	 }
		
	  public void clickAddNewUser() {
		    driver.findElement(addUser).click();
	  }
	
		// -------- below functions for getting If page elements are displayed--------	
				
	

	  
	  public String popUpWindow() throws InterruptedException {
		    WebElement popUpText = driver.findElement(userPopup);
//		      Thread.sleep(2000);
		    return popUpText.getText() ;
		}

	  
		  public boolean AddNewUserValidate() throws InterruptedException {
			    
			    boolean isFirstNamePresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-10 ng-star-inserted']")).isDisplayed();
		        boolean isMiddleNamePresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-11 ng-star-inserted']")).isDisplayed();
		        boolean isLastNamePresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-12 ng-star-inserted']")).isDisplayed();
		        boolean isLocationPresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-13 ng-star-inserted']")).isDisplayed();
		        boolean isPhonePresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-14 ng-star-inserted']")).isDisplayed();
		        boolean isEmailPresent = driver.findElement(By.xpath("//input[@id='mat-input-8']")).isDisplayed();
		        boolean isLinkedInUrlPresent = driver.findElement(By.xpath("//span[@class='ng-tns-c78-15 ng-star-inserted']")).isDisplayed();
		        boolean isUserRolePresent = driver.findElement(By.xpath("//label[@for='userRole']")).isDisplayed();
		        boolean isRoleStatusPresent = driver.findElement(By.xpath("//label[@for='userRoleStatus']")).isDisplayed();
		        boolean isVisaStatusPresent = driver.findElement(By.xpath("//label[@for='userVisaStatus']")).isDisplayed();
		        boolean isUndergraduatePresent = driver.findElement(By.id("mat-form-field-label-19")).isDisplayed();
		        boolean isPostgraduatePresent = driver.findElement(By.id("mat-form-field-label-21")).isDisplayed();
		        boolean isTimeZonePresent = driver.findElement(By.id("mat-form-field-label-23")).isDisplayed();
		        boolean isUserCommentsPresent = driver.findElement(By.id("mat-form-field-label-25")).isDisplayed();
		        boolean isCancelButtonPresent = driver.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='Cancel']")).isDisplayed();
		        boolean isSubmitButtonPresent = driver.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='Submit']")).isDisplayed();
		        boolean isCloseButtonPresent = driver.findElement(close).isDisplayed();

		        // Return true if all fields and buttons are present
		        return isFirstNamePresent && isMiddleNamePresent && isLastNamePresent && isLocationPresent && isPhonePresent &&
		                isEmailPresent && isLinkedInUrlPresent && isUserRolePresent && isRoleStatusPresent && isVisaStatusPresent &&
		                isUndergraduatePresent && isPostgraduatePresent && isTimeZonePresent && isUserCommentsPresent && isCancelButtonPresent &&
		                isSubmitButtonPresent && isCloseButtonPresent;
		  }
		  
		  public boolean UserTextBoxes() throws InterruptedException {
			    
    boolean isFirstNameTbox = driver.findElement(By.xpath("//input[@data-placeholder='First name']")).getAttribute("data-placeholder").contains("First name");
    boolean isMiddleNameTbox = driver.findElement(By.xpath("//input[@data-placeholder='Middle name']")).getAttribute("data-placeholder").contains("Middle name");
    boolean isLastNameTbox = driver.findElement(By.xpath("//input[@data-placeholder='Last name']")).getAttribute("data-placeholder").contains("Last name");
    boolean isLocationTbox = driver.findElement(By.xpath("//input[@data-placeholder='Location']")).getAttribute("data-placeholder").contains("Location");
    boolean isPhoneTbox = driver.findElement(By.xpath("//input[@data-placeholder='Phone no']")).getAttribute("data-placeholder").contains("Phone no");
	boolean isEmailTbox = driver.findElement(By.xpath("//input[@data-placeholder='Email address']")).getAttribute("data-placeholder").contains("Email address");
	boolean isLinkedInUrlTbox = driver.findElement(By.xpath("//input[@data-placeholder='LinkedIn Url']")).getAttribute("data-placeholder").contains("LinkedIn Url");
	boolean isUndergraduateTbox = driver.findElement(By.xpath("//input[@data-placeholder='Under Graduate']")).getAttribute("data-placeholder").contains("Under Graduate");
	boolean isPostgraduateTbox = driver.findElement(By.xpath("//input[@data-placeholder='Post Graduate']")).getAttribute("data-placeholder").contains("Post Graduate");
	boolean isTimeZoneTbox = driver.findElement(By.xpath("//input[@data-placeholder='Time Zone']")).getAttribute("data-placeholder").contains("Time Zone");
	boolean isUserCommentsTbox = driver.findElement(By.xpath("//input[@data-placeholder='User Comments']")).getAttribute("data-placeholder").contains("User Comments");
		        

	 // Return true if all fields and buttons are present
	return isFirstNameTbox && isMiddleNameTbox && isLastNameTbox && isLocationTbox && isPhoneTbox && isEmailTbox
			&& isLinkedInUrlTbox && isUndergraduateTbox && isPostgraduateTbox && isTimeZoneTbox
			&& isUserCommentsTbox; 
		        }
		 
		  public boolean dropDownFields(List<String> fieldNames) {
			    boolean allDropdownsDisplayed = true;

			    for (String fieldName : fieldNames) {
			        WebElement dropdownElement = driver.findElement(By.id(fieldName));
			        if (!dropdownElement.isDisplayed()) {
			            System.out.println(fieldName + " dropdown is not displayed.");
			            allDropdownsDisplayed = false;
			        }
			    }

			    return allDropdownsDisplayed;
			}

		  public static void enterMandatoryFields(Map<String, String> userData)throws InterruptedException {
			  WebElement text = driver.findElement(fName);
			  text.sendKeys(userData.get("FName"));
			  
			  WebElement text2 = driver.findElement(mName);
			  text2.sendKeys(userData.get("MName"));
			  
			  WebElement text3 =  driver.findElement(lName);
			  text3.sendKeys(userData.get("LName"));
			  
			  WebElement text4 =  driver.findElement(location);
			  text4.sendKeys(userData.get("Location"));
			  
			  WebElement text5 =  driver.findElement(ph);
			  text5.sendKeys(userData.get("PhoneNo"));
			  
			  WebElement text6 =  driver.findElement(linkedInUrl);
			  text6.sendKeys(userData.get("LinkedinUrl"));
			  
			  WebElement text7 =  driver.findElement(userRole);
			  selectDropdownOption(text7, userData.get("userRole"));
			 
			  WebElement text8 =  driver.findElement(userStatus);
			  selectDropdownOption(text8, userData.get("userStatus"));
			  
			  WebElement text9 =  driver.findElement(visaStatus);
			selectDropdownOption(text9, userData.get("visaStatus"));
			 
			  WebElement text10 =  driver.findElement(email);
			  text10.sendKeys(userData.get("Email"));
			  
			  WebElement text11 =  driver.findElement(ug);
			  text11.sendKeys(userData.get("UG"));
			  
			  WebElement text12 =  driver.findElement(pg);
			  text12.sendKeys(userData.get("PG"));
			  
			  WebElement text13 =  driver.findElement(tymZone);
			  text13.sendKeys(userData.get("TimeZone"));
			  
			  WebElement text14 =  driver.findElement(userComm);
			  text14.sendKeys(userData.get("UserComment"));
		  }
		  
 
		  private static void selectDropdownOption(WebElement dropdown, String optionText) throws InterruptedException {
			
			  System.out.println(optionText);
			  
			    dropdown.click(); // Click to open the dropdown
			    // Locate and click on the option with the provided text
			   // WebElement option = dropdown.findElement(By.xpath(".//option[text()='" + optionText + "']"));
			    WebElement option = dropdown.findElement(By.xpath("//span[text()='" + optionText  + "']"));
			    		option.click();
			}
				public static void clickSubmit() {
		        driver.findElement(submit).click();
		    }
				
		public void getSucessMsg() {
			driver.findElement(sucessMsg).getText();
		}
		
		public boolean getErrorMsg() {
//			boolean isErrorMsgPresent = driver.findElement(errorMsg).getText().isEmpty();
//			System.out.println("eroorMsg" + driver.findElement(errorMsg).getText() );
//			return isErrorMsgPresent;
//		} 
			boolean isErrorMsgPresent = !driver.findElement(errorMsg).getText().isEmpty();
		    System.out.println("errorMsg: " + driver.findElement(errorMsg).getText());
		    return isErrorMsgPresent;
		}
		public void clickClose() {
			driver.findElement(close).click();	
		}
		
		public void clickCancle() {
			driver.findElement(cancle).click();	
		}
		
		public void ErrorMsg() {
			// Locate all error messages
		    List<WebElement> errorMessages = driver.findElements(By.xpath("//mat-error[contains(@id, 'mat-error-')]"));

		    // Check if any error messages are displayed
		    boolean isErrorMessageDisplayed = false;
		    for (WebElement errorMessage : errorMessages) {
		        if (errorMessage.isDisplayed()) {
		            isErrorMessageDisplayed = true;
		            break;
		        }}
		    // Locate the highlighted field
		    WebElement highlightedField = driver.findElement(By.xpath("//input[contains(@aria-describedby, 'mat-error')]"));
		    String color = highlightedField.getCssValue("color");

		 // Now you can use the color value as needed
		 System.out.println("Color of the error message: " + color);
		    // Check if the highlighted field's color is red
		    boolean isHighlightedFieldRed = color.equals("rgba(0, 0, 0, 0.87)");
		    
		    // Print the result based on the conditions
		    if (isErrorMessageDisplayed && isHighlightedFieldRed) {
		        System.out.println("Error message is displayed below the test field, and the field is highlighted in red color.");
		    } else {
		        System.out.println("Error message is not displayed below the test field, or the field is not highlighted in red color.");
		    }
		}
		
public static void missMandatoryFields(Map<String, String> userData)throws InterruptedException {
	
	 	  
	  WebElement text2 = driver.findElement(mName);
	  text2.sendKeys(userData.get("MName"));
	  
	  WebElement text6 =  driver.findElement(linkedInUrl);
	  text6.sendKeys(userData.get("LinkedinUrl"));
	  
	  WebElement text10 =  driver.findElement(email);
	  text10.sendKeys(userData.get("Email"));
	  
	  WebElement text11 =  driver.findElement(ug);
	  text11.sendKeys(userData.get("UG"));
	  
	  WebElement text12 =  driver.findElement(pg);
	  text12.sendKeys(userData.get("PG"));
	  
	  WebElement text13 =  driver.findElement(tymZone);
	  text13.sendKeys(userData.get("TimeZone"));
	  
	  WebElement text14 =  driver.findElement(userComm);
	  text14.sendKeys(userData.get("UserComment"));
}
public boolean isUserDetailsPopupOpen() {
//    // Check if the close button is displayed, assuming it disappears when the popup is closed
//    return driver.findElement(By.id("close")).isDisplayed(); 
	 try {
	        WebElement closeButton = driver.findElement(By.id("close"));
	        return !closeButton.isDisplayed();
	    } catch (NoSuchElementException e) {
	        // If the close button is not found, it means the popup is closed
	        return true;
	    }
	}
   

public String searchNewUser() {
	   WebElement sBox = driver.findElement(searchBox);
	   sBox.clear();
	   sBox.sendKeys("TestLMS");
	return sBox.getAttribute("value");
         }

}

