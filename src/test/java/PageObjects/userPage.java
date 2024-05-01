package PageObjects;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class userPage {

	private WebDriver driver;
	
 
	private By user = By.id("user");
	private By pgHeading = By.xpath("//div[normalize-space()='Manage User']");
	private By pginationText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By pginationIcon = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");
	private By columnId = By.xpath("//th[normalize-space()='ID']");
	private By columnName = By.xpath("//th[normalize-space()='Name']");
	private By columnLocation = By.xpath("//th[normalize-space()='Location']");
	private By columnPhNo = By.xpath("//th[normalize-space()='Phone Number']");
	private By columnEditDel = By.xpath("//th[normalize-space()='Edit / Delete']");
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
	private By close = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']");
	
	
	public userPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
//----------- below functions to click on elements -------	

	 public void clickOnUserTab() {
		    driver.findElement(user).click();
	 }

// -------- below functions for getting page's url and heading--------	
	
	 public String getPageHeading()
		{
			return driver.findElement(pgHeading).getText();
		}
		public String getUserPageURL()
		{
			return driver.getCurrentUrl();
		}
	
		// -------- below functions for getting If page elements are displayed--------	
				
		
		public boolean isPaginationTextDisplayed() {
		    return driver.findElement(pginationText).isDisplayed();
		}

		public boolean isPaginationIconDisplayed() {
		    return driver.findElement(pginationIcon).isDisplayed();
		}
		
		public boolean isColumnIDDisplayed() {
		    return driver.findElement(columnId).isDisplayed();
		}

		public boolean isColumnNameDisplayed() {
		    return driver.findElement(columnName).isDisplayed();
		}
		
		public boolean isColumnLocationDisplayed() {
		    return driver.findElement(columnLocation).isDisplayed();
		}
		
		public boolean isColumnPhoneNoDisplayed() {
		    return driver.findElement(columnPhNo).isDisplayed();
		}
		
		public boolean isColumnEditDisplayed() {
		    return driver.findElement(columnEditDel).isDisplayed();
		}
		
		public boolean isAddNewUserDisplayed() {
		    return driver.findElement(addUser).isDisplayed();
		}
		
		public boolean isAssignStudentDisplayed() {
		    return driver.findElement(assignStu).isDisplayed();
		}
		public boolean isAssignStaffDisplayed() {
		    return driver.findElement(assignStaff).isDisplayed();
		}
		public boolean isSearchTextBoxVisible() {
		    return driver.findElement(searchBox).isDisplayed();
		}
		
		public void isDataTableVisible() {
		 WebElement dataTable = driver.findElement(dTable);
		    List<WebElement> rows = dataTable.findElements(Rows);
		    // ------Printing the no. of records visible-------
		    System.out.println("Number of records displayed: " + (rows.size() - 1));
		   
		}
		
		public int isCheckBoxVisible() {
	        WebElement dataTable = driver.findElement(dTable);
	        List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
	        int totalRowsWithCheckBoxes = 0;
	        
	        // Iterating over each row to check for checkboxes
	        for (WebElement row : rows) {
	            // Finding all checkboxes in the current row
	            List<WebElement> checkboxes = row.findElements(chkBox);
	          
	            // Checking if the current row contains a checkbox
	            if (!checkboxes.isEmpty()) {
	                totalRowsWithCheckBoxes++; // Incrementing the count of rows with checkboxes
	            }
	        }

	         return totalRowsWithCheckBoxes;
		}
		
	        public boolean isEditButtonEnabled() {
	        	// Finding the data table
	            WebElement dataTable = driver.findElement(dTable); // Assuming the data table has id "dataTable"
	            
	            // Finding all rows in the table
	            List<WebElement> rows = dataTable.findElements(By.tagName("tr"));

	            // Iterating over each row to check for edit icons
	            for (WebElement row : rows) {
	                // Finding the edit icon in the current row
	                WebElement editIcon = row.findElement(edit); 
	                
	                // Checking if the edit icon is enabled
	                boolean isEnabled = editIcon.isEnabled();
	                
	                // If edit icon is enabled, return true
	                if (isEnabled) {
	                    return true;
	                }
	            }
	            // If no enabled edit icon found in any row, return false
	            return false;
	        }
	            
	            public boolean isDeleteButtonEnabled() {
		        	// Finding the data table
		            WebElement dataTable = driver.findElement(dTable); // Assuming the data table has id "dataTable"
		            
		            // Finding all rows in the table
		            List<WebElement> rows = dataTable.findElements(By.tagName("tr"));

		            // Iterating over each row to check for edit icons
		            for (WebElement row : rows) {
		                // Finding the edit icon in the current row
		                WebElement deleteIcon = row.findElement(delete); 
		                
		                // Checking if the edit icon is enabled
		                boolean isEnabled = deleteIcon.isEnabled();
		                
		                // If edit icon is enabled, return true
		                if (isEnabled) {
		                    return true;
		                }
		            }
		            // If no enabled edit icon found in any row, return false
		            return false;
	            }
		
	            public String enterValidUser() {
		   WebElement sBox = driver.findElement(searchBox);
		   sBox.clear();
		   sBox.sendKeys("Testing Squad");
		return sBox.getAttribute("value");
	            }
	            
	            public String enterInValidUser() {
	     		   WebElement sBox = driver.findElement(searchBox);
	     		   sBox.clear();
	     		   sBox.sendKeys("MahaTeam");
	     		return sBox.getAttribute("value");
	     	            }
	            
	            public String searchedValidUser() throws InterruptedException {
	            	WebElement resultBox = driver.findElement(searchResult);
	            	Thread.sleep(3000);
//	            	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		return resultBox.getText();
	            }
		  public boolean searchedInValidUser() throws InterruptedException {
          	boolean isResultSize0 = driver.findElement(pginationText).getText().contains("0");
//          	System.out.println("print the result for invalid result " + isResultSize0);
          	Thread.sleep(5000);
//          	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
	return isResultSize0;
	       
	    }}	
	  
//		  public void closeAddUser() {
//		        driver.findElement(close).click();
//		    }
//			}
	

