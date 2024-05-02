//package PageObjects;
//
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class DeleteUserPage {
//	
//          private WebDriver driver;
//          private By logoutLink = By.id("logout");
//          //private By userButton = By.id("user");
//          private By userButton = By.xpath("//span[normalize-space()='User']");
//          private By userHeader= By.xpath("//*[contains(text(),'Manage User')]");
//         
//         private By confirmDelete= By.xpath("//div[@class='p-toast-detail ng-tns-c90-41']");
//         
//         private By yesNoDialogue = By.xpath("//div[@class='p-dialog-header ng-tns-c133-25 ng-star-inserted']");
//         private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
//         private By  FirstCheckBox =By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
//         private By yesButton = By.xpath("//*[text()='Yes']");
//         private By noButton = By.xpath("//*[text()='No']");
//         private By  MyRecord=  By.xpath("//td[contains(text(),'Madhavi')]");
//         
//         private By assignStudent= By.xpath("//span[normalize-space()='Assign Student']");
//         private By assignStaff= By.xpath("//span[normalize-space()='Assign Staff']");
//         private By saveButton= By.xpath("//span[normalize-space()='Save']");
//         private By cancelbutton=By.xpath("//span[normalize-space()='Cancel']");
//         
//         public DeleteUserPage(WebDriver driver)
//     	 {
//     		this.driver = driver;
//     		
//     	 }
//		
//		public boolean checkLogoutLink() {
//	        return driver.findElement(logoutLink).isDisplayed();
//	        
//		}
//     //----------- below functions to click on elements which are commonly used for all modules -------	
//
//     	 public void clickOnUserTab() {
//     		    driver.findElement(userButton).click();
//     		    System.out.println("user click");
//     	 }
//     	 
//     	public String getUserHeaderName() {
//    		return driver.findElement(userHeader).getText();
//    	}
//     	
//     	public void selectOneUserChk() {
//    		driver.findElement(FirstCheckBox).click();
//    	}
//
//    	public String isSelectedUserChk () {
//            String isSelected = driver.findElement(FirstCheckBox).getAttribute("aria-checked");
//            System.out.println("Is checkbox selected? " + isSelected);
//            return isSelected;
//    	}
//    	public boolean isEnabledCommonDeleteBtn() {
//            boolean isEnabled = driver.findElement(commonDeleteButton).isEnabled();
//            System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
//            return isEnabled;
//    	}
//     	public void clickCommonDeleteButton() {
//    		driver.findElement(commonDeleteButton).click();
//     	}
//     
//     	public void yesNoDialogueBox() {
//    		driver.findElement(yesNoDialogue).clear();;
//     	}
//     	public void selectOneProgramChk() {
//    		driver.findElement(FirstCheckBox).click();
//     	}
//
//         public void deleteYes() {
//         // Get the current window handle
// 		String currentWindowHandle = driver.getWindowHandle();
// 		// Get all window handles
// 		Set<String> allWindowHandles = driver.getWindowHandles();
//
//        // Iterate through all handles
// 		for (String handle : allWindowHandles) {
// 		    // Switch to the window
// 		    driver.switchTo().window(handle);
// 		   
// 		    driver.findElement(yesButton).click();
// 		}
// 		// Switch back to the original window
// 		driver.switchTo().window(currentWindowHandle);
//
//         }
//         public void deleteNo() {
//             // Get the current window handle
//     		String currentWindowHandle = driver.getWindowHandle();
//     		// Get all window handles
//     		Set<String> allWindowHandles = driver.getWindowHandles();
//
//            // Iterate through all handles
//     		for (String handle : allWindowHandles) {
//     		    // Switch to the window
//     		    driver.switchTo().window(handle);
//     		   
//     		    driver.findElement(noButton).click();
//     		}
//     		// Switch back to the original window
//     		driver.switchTo().window(currentWindowHandle);
//
//             }      
//         public void getmessage() { 
//        	 WebElement successMessage = driver.findElement(confirmDelete);
//		
//		String actualMessage = successMessage.getText();
//         String expectedMessage = "Successful User Deleted";  
//         if (actualMessage.equals(expectedMessage)) {
//             System.out.println("Success! " + actualMessage);
//         } else {
//             System.out.println("Failure! Expected: " + expectedMessage + ", Actual: " + actualMessage);
//         }  
//         }
//}
package PageObjects;





