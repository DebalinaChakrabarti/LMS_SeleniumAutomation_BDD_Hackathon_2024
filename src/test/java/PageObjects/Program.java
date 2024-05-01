package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constants;

public class Program {
	
	private WebDriver driver;
	private By programLink = By.id("program");
	private By batchLink = By.id("batch");
	private By userLink = By.id("user");
    private By programFirstRecordChk=By.xpath("//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]");
//    private By programFirstRecordChk=By.xpath("//tr[1]/td[1]");
    private By programSecondRecordChk=By.xpath("//tr[2]/td[1]");
    private By listOfChkBox=By.xpath("//tr/td[1]");
    private By programNameFirstRecord=By.xpath("//tr[1]/td[2]");
    private By programNameSecondRecord=By.xpath("//tr[2]/td[2]");
    private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
    private By yesButton = By.xpath("//*[text()='Yes']");
//    private By specificDelYesButton = By.xpath("//button[@class='ng-tns-c133-9 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']");
    private By specificDelYesButton = By.xpath("/html[1]/body[1]/app-root[1]/app-program[1]/p-confirmdialog[1]/div[1]/div[1]/div[3]/button[2]/span[2]");
    private By noButton = By.xpath("//*[text()='No']");
    private By closeButton = By.xpath("/html[1]/body[1]/app-root[1]/app-program[1]/p-confirmdialog[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]");
//    private By deleteConfirmHeader = By.xpath("//span[@class='p-dialog-title ng-tns-c133-42 ng-star-inserted']");
	private By specificDeleteButton = By.id("deleteProgram");
//	private By specificDeleteConfirmMsg = By.xpath("//span[@class='p-confirm-dialog-message ng-tns-c133-42']");
	private By specificDeleteConfirmMsg = By.xpath("/html[1]/body[1]/app-root[1]/app-program[1]/p-confirmdialog[1]/div[1]/div[1]/div[2]/span[1]");

	private By deleteConfirmHeader = By.xpath("/html[1]/body[1]/app-root[1]/app-program[1]/p-confirmdialog[1]/div[1]/div[1]/div[1]/span[1]");
    
    private By programHeaderName = By.xpath("//*[contains(text(),'Manage Program')]");
    private By batchHeaderName = By.xpath("//*[contains(text(),'Manage Batch')]");
    private By userHeaderName = By.xpath("//*[contains(text(),'Manage User')]");
	private By logoutLink = By.id("logout");
	private By programNameColumnHeader = By.xpath("//tr/th[2]");
	private By programNameList = By.xpath("//tr/td[2]");
	private By programDescColumnHeader = By.xpath("//tr/th[3]");
	private By programDescList = By.xpath("//tr/td[3]");
	private By programStatuscColumnHeader = By.xpath("//tr/th[4]");
	private By programStatusList = By.xpath("//tr/td[4]");
//	private By tableDataRecord = By.xpath("//tr/td[4]");
	
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	private By firstPageButton = By.xpath("//button[text()='1']");
	
	

	public Program(WebDriver driver)
	{
		this.driver = driver;
		
		
	}
	public void getProgramPage()
	{
		driver.get(Constants.baseUrl);
	}

	public String getProgramPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getProgramHeaderName() {
		return driver.findElement(programHeaderName).getText();
	}
	
	public void clickProgramLink() {
		driver.findElement(programLink).click();
	}
	public void selectOneProgramChk() {
		driver.findElement(programFirstRecordChk).click();
	}

	public String isSelectedProgramChk() {
        String isSelected = driver.findElement(programFirstRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelected);
        return isSelected;
	}

	public boolean isEnabledCommonDeleteBtn() {
        boolean isEnabled = driver.findElement(commonDeleteButton).isEnabled();
        System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
        return isEnabled;
	}
	public void clickCommonDeleteButton() {
		driver.findElement(commonDeleteButton).click();
	}

	public void clickSpecificDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

		driver.findElement(specificDeleteButton).click();
	}

	public boolean commonDeleteAlertConfirmYes() throws InterruptedException {
		
		//storing selected program to be deleted in a string
		String targetedDeleteProgramName = driver.findElement(programNameFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeleteProgramName "+targetedDeleteProgramName);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(yesButton).click();
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
		
		//check selected program is deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteAlertConfirmYes getOriginalProgramNameList "+originalProgramNameList);

		boolean isDeleted = !originalProgramNameList.contains(targetedDeleteProgramName);
		System.out.println("isDeleted "+isDeleted);
		
		return isDeleted;
	}

	public boolean commonDeleteAlertConfirmNo() throws InterruptedException {

		//storing selected program to be deleted in a string
		String targetedDeleteProgramName = driver.findElement(programNameFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeleteProgramName "+targetedDeleteProgramName);

		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(noButton).click();
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check selected program is deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteAlertConfirmNo getOriginalProgramNameList "+originalProgramNameList);

		boolean isNotDeleted = originalProgramNameList.contains(targetedDeleteProgramName);
		System.out.println("isNotDeleted "+isNotDeleted);
		//to uncheck the selected textbox
		selectOneProgramChk();
		
		return isNotDeleted;
	}

	public void selectMultipleProgramChk() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(programFirstRecordChk).click();
		Thread.sleep(500);
		driver.findElement(programSecondRecordChk).click();
		
//        List<WebElement> checkboxes = driver.findElements(listOfChkBox);
//
//		for(int i=0;i<=1;i++)
//		{
//			checkboxes.get(i).click();
//			Thread.sleep(2000);
//		}
	}
	


	public boolean commonDeleteMultipleAlertConfirmYes() throws InterruptedException {
		
		//adding targeted multiple selected programs to be deleted in a list
		List<String> targetedDeleteProgramNames = new ArrayList<String>();
		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteProgramNames "+targetedDeleteProgramNames);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(yesButton).click();
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
		
		//check if selected programs are deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteMultipleAlertConfirmYes getOriginalProgramNameList "+originalProgramNameList);

		boolean isDeleted = !originalProgramNameList.containsAll(targetedDeleteProgramNames);
		System.out.println("Selected programs are Deleted "+isDeleted);
		
		return isDeleted;
	}

	public boolean commonDeleteMultipleAlertConfirmNo() throws InterruptedException {

		//adding targeted multiple selected programs to be deleted in a list
		List<String> targetedDeleteProgramNames = new ArrayList<String>();
		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteProgramNames "+targetedDeleteProgramNames);
		
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(noButton).click();
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check if selected programs are deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalProgramNameList);

		boolean isNotDeleted = originalProgramNameList.containsAll(targetedDeleteProgramNames);
		System.out.println("Selected programs are Deleted "+isNotDeleted);
		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}
	
	
	public boolean checkLogoutLink() {
        return driver.findElement(logoutLink).isDisplayed();
	}

	public void clickProgramNameColumnHeader() {
        driver.findElement(programNameColumnHeader).click();
	}

	//List of program name of one page
	public List<String> getOriginalProgramNameList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(programNameList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalList "+originalList);
			  
		  return originalList;
	}
	
	
	public List<String> getSortedProgramNameListAsc() {
		
		  //sort on the original list of step3 ->sorted list in Ascending order
		  List<String> sortedlList = getOriginalProgramNameList().stream().sorted().collect(Collectors.toList());
		  System.out.println("sortedlList "+sortedlList);

		  return sortedlList;

	}
		
	public List<String> getSortedProgramNameListDesc() {
		
		  //sort on the original list of step3 ->sorted list in Ascending order
		  List<String> sortedlListdesc = getOriginalProgramNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		  System.out.println("getOriginalProgramNameList() "+getOriginalProgramNameList());
		  System.out.println("sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickProgramDescColumnHeader() {
        driver.findElement(programDescColumnHeader).click();
	}
	
	public List<String> getOriginalProgramDescList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(programDescList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalProgramDescriptionList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalProgramDescList "+originalProgramDescriptionList);
	  return originalProgramDescriptionList;
}

	public List<String> getSortedProgramDescriptionListAsc() {
		
		  //sort on the original list of step3 ->sorted list in Ascending order
		  List<String> desiredlList = getOriginalProgramDescList();
	        // Sort the list
	        Collections.sort(desiredlList);
	        
	        System.out.println("getSortedProgramDescriptionListAsc "+desiredlList);  

		  return desiredlList;

	}

	public List<String> getSortedProgramDescriptionListDesc() {
		
		  //sort on the original list of step3 ->sorted list in Ascending order
		  List<String> sortedlListdesc = getOriginalProgramDescList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("getSortedProgramDescriptionListDesc sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	
	public void clickProgramStatusColumnHeader() {
        driver.findElement(programStatuscColumnHeader).click();
	}
	
	public List<String> getOriginalProgramStatusList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(programStatusList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalProgramStatusList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalProgramStatusList "+originalProgramStatusList);
		  return originalProgramStatusList;
	}

		public List<String> getSortedProgramStatusListAsc() {
			
			  //sort on the original list of step3 ->sorted list in Ascending order
			  List<String> desiredlList = getOriginalProgramStatusList();
		        // Sort the list
		        Collections.sort(desiredlList);
		        
		        System.out.println("getSortedProgramStatusListAsc "+desiredlList);  

			  return desiredlList;

		}

		public List<String> getSortedProgramStatusListDesc() {
			
			  //sort on the original list of step3 ->sorted list in Ascending order
			  List<String> sortedlListdesc = getOriginalProgramStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			  System.out.println("getSortedProgramDescriptionListDesc sortedlList desc "+sortedlListdesc);

			  return sortedlListdesc;

		}
		
		public void clickNextLink()
		{
			driver.findElement(nextBtn).click();
		}

		public boolean isActiveNextLink()
		{
	        // Wait for the table to reload with the next page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isNextEnabled;
	        List<WebElement> elements = driver.findElements(nextBtn);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isNextEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, handle accordingly
	        	isNextEnabled = false;
	        }

	        return isNextEnabled;

		}
		
		public void clickLastLink()
		{
			driver.findElement(lastBtn).click();
		}

		public boolean isActiveLastLink()
		{
	        // Wait for the table to reload with the Last page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

			
			// Check if the last button is enabled

	        boolean isLastEnabled;
	        List<WebElement> elements = driver.findElements(lastBtn);
//	        List<WebElement> data = driver.findElements(tableDataRecord);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isLastEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, handle accordingly
	        	isLastEnabled = false;
	        }
	        System.out.println("isLastEnabled "+isLastEnabled);  
//	        System.out.println("data "+data.getText());  

	        return isLastEnabled;

		
		}
		
		public void clickFirstLink()
		{
			driver.findElement(firstBtn).click();
		}
		
		public void clickPreviousLink()
		{
			driver.findElement(prevBtn).click();
		}
		
		public boolean isActivePreviousLink()
		{
	        // Wait for the table to reload with the Last page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isPrevEnabled;
	        List<WebElement> elements = driver.findElements(prevBtn);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isPrevEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, handle accordingly
	        	isPrevEnabled = false;
	        }
	        System.out.println("isPrevEnabled "+isPrevEnabled);  

	        return isPrevEnabled;
		
		}

		public boolean isFirstPage()
		{
	        // Wait for the table to reload with the First page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isOneButtonHighlighted  = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")).getText().contains("1");
	        System.out.println("isOneButtonHighlighted "+isOneButtonHighlighted);  

	        boolean isFirstPage;
	        if(isOneButtonHighlighted && getOriginalProgramNameList().size()>0)
	        {
	        	isFirstPage = true;
	        }
	        else
	        	isFirstPage = false;
	        
	        return isFirstPage;
		
		}

		public boolean isDisplayedConfirmHeader()
		{
			boolean isDisplayedConfirmHeader = false;
	        isDisplayedConfirmHeader  = driver.findElement(deleteConfirmHeader).getText().equalsIgnoreCase("Confirm");
	        System.out.println("isDisplayedConfirmHeader"+isDisplayedConfirmHeader);  
	        return isDisplayedConfirmHeader;
		
		}

		public boolean isDisplayedConfirmHeaderYesNo()
		{

//	        boolean isDisplayedConfirmHeader  = driver.findElement(deleteConfirmHeader).getText().equalsIgnoreCase("Confirm");
	        boolean isDisplayedYes  = driver.findElement(yesButton).isDisplayed();
	        boolean isDisplayedNo  = driver.findElement(noButton).isDisplayed();
	        System.out.println("isDisplayedConfirmHeader + isDisplayedYes + isDisplayedNo "+isDisplayedConfirmHeader() + isDisplayedYes + isDisplayedNo);  

	        boolean isDisplayedConfirmHeaderYesNo;
	        if(isDisplayedConfirmHeader() && isDisplayedYes && isDisplayedNo)
	        {
	        	isDisplayedConfirmHeaderYesNo = true;
	        }
	        else
	        	isDisplayedConfirmHeaderYesNo = false;
	        
	        return isDisplayedConfirmHeaderYesNo;
		
		}
		
		public boolean isDisplayedSpecificDeleteConfirmMsg()
		{

	        boolean isDisplayedSpecificDeleteConfirmMsg  = driver.findElement(specificDeleteConfirmMsg).getText().contains("Are you sure you want to delete");
	        System.out.println("isDisplayedSpecificDeleteConfirmMsg "+isDisplayedSpecificDeleteConfirmMsg);  

	        return isDisplayedSpecificDeleteConfirmMsg;
		
		}
		

		public void clickBatchLink() {
			driver.findElement(batchLink).click();
		}
		public void clickUserLink() {
			driver.findElement(userLink).click();
		}
		public void clickLogoutLink() {
			driver.findElement(logoutLink).click();
		}
		
		public boolean specificDeleteAlertConfirmYes() throws InterruptedException {
			
			//storing selected program to be deleted in a string
			String targetedDeleteProgramName = driver.findElement(programNameFirstRecord).getText().toLowerCase().trim();
			System.out.println("targetedDeleteProgramName "+targetedDeleteProgramName);
			
			Thread.sleep(1000);
		    driver.findElement(specificDelYesButton).click();
			
			Thread.sleep(1000);
			
			//check selected program is deleted from the data table
			List<String> originalProgramNameList = getOriginalProgramNameList();
			System.out.println("specificDeleteAlertConfirmYes getOriginalProgramNameList "+originalProgramNameList);

			boolean isDeleted = !originalProgramNameList.contains(targetedDeleteProgramName);
			System.out.println("isDeleted "+isDeleted);
			boolean isSuccessMsgPresent = !driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-program[1]/p-toast[1]/div[1]/p-toastitem[1]/div[1]/div[1]/div[1]/div[1]")).getText().isEmpty();
//			// Switch to the alert
//	        Alert alert = driver.switchTo().alert();
//	        
//	        // Get the text of the alert
//	        String alertMessage = alert.getText();
//	        System.out.println("Alert message: " + alertMessage);
//	        
//	        // Accept the alert
//	        alert.accept(); // Use 'dismiss()' to dismiss the alert instead of accepting
//			
			if(isSuccessMsgPresent && isDeleted)
				return true;
			else
				return false;

//			return isDeleted;
		}

		public boolean specificDeleteAlertConfirmNo() throws InterruptedException {

			//storing selected program to be deleted in a string
			String targetedDeleteProgramName = driver.findElement(programNameFirstRecord).getText().toLowerCase().trim();
			System.out.println("targetedDeleteProgramName "+targetedDeleteProgramName);

			    
			    driver.findElement(noButton).click();
			    
			Thread.sleep(1000);
			
			//check selected program is deleted from the data table
			List<String> originalProgramNameList = getOriginalProgramNameList();
			System.out.println("specificDeleteAlertConfirmNo getOriginalProgramNameList "+originalProgramNameList);

			boolean isNotDeleted = originalProgramNameList.contains(targetedDeleteProgramName);
			System.out.println("isNotDeleted "+isNotDeleted);
			
			return isNotDeleted;
		}

		public boolean specificDeleteAlertConfirmClose() throws InterruptedException {

			//storing selected program to be deleted in a string
			String targetedDeleteProgramName = driver.findElement(programNameFirstRecord).getText().toLowerCase().trim();
			System.out.println("targetedDeleteProgramName "+targetedDeleteProgramName);

			    
			    driver.findElement(closeButton).click();
			    
			Thread.sleep(1000);
			
			//check selected program is deleted from the data table
			List<String> originalProgramNameList = getOriginalProgramNameList();
			System.out.println("specificDeleteAlertConfirmClose getOriginalProgramNameList "+originalProgramNameList);

			boolean isNotDeleted = originalProgramNameList.contains(targetedDeleteProgramName);
			System.out.println("isNotDeleted "+isNotDeleted);
			
			return isNotDeleted;
		}
		
		public void clickCloseConfirmDelete()
		{
			driver.findElement(closeButton).click();
		}
		
		public void clickNoConfirmDelete()
		{
			driver.findElement(noButton).click();
		}
		
}
