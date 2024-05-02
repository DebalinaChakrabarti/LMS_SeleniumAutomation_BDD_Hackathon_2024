package PageObjects;



import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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



public class sortUserPage {

	
	private static WebDriver driver;
	
 
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
	private By userNameList = By.xpath("//tr/td[2]");
	private By programLink = By.id("program");
		public sortUserPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
		public void clickColumIDHeader() {
	        driver.findElement(columnId).click();
		}
		
		public void clickPrgButton() {
	        driver.findElement(programLink).click();
		}
		
		 public void clickOnUserTab() {
			    driver.findElement(user).click();
		 }
		
		public void clickColumnNameHeader() {
	        driver.findElement(columnName).click();
		}
		

		public void clickColumnLocationHeader() {
	        driver.findElement(columnLocation).click();
		}

		public void clickColumnPhoneNoHeader() {
	        driver.findElement(columnPhNo).click();
		}
		public void clearSeactchBox() {
		 WebElement sBox = driver.findElement(searchBox);
		   sBox.clear();
		}
		 public boolean isUserDetailsSortedByID() {
		        List<WebElement> userIdElements = driver.findElements(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"));
		        List<Integer> userIds = userIdElements.stream()
		                .map(webElement -> webElement.getText())
		                .filter(text -> text.matches("\\d+")) // Filter out non-integer values
		                .map(Integer::parseInt)
		                .collect(Collectors.toList());

		        return isSorted(userIds);
		    }

		    private boolean isSorted(List<Integer> list) {
		        for (int i = 0; i < list.size() - 1; i++) {
		            if (list.get(i) > list.get(i + 1)) {
		                return false;
		            }
		        }
		        return true;
		    }
		    
		    public boolean isUserDetailsSortedByName() {
		        List<WebElement> userName = driver.findElements(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
		        List<Integer> name = userName.stream()
		                .map(webElement -> webElement.getText())
		                .filter(text -> text.matches("\\d+")) // Filter out non-integer values
		                .map(Integer::parseInt)
		                .collect(Collectors.toList());

		        return isSorted(name);
		    }

  
		    
		    public boolean isUserDetailsSortedByLocation() {
		        List<WebElement> userLocation = driver.findElements(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
		        List<Integer> location = userLocation.stream()
		                .map(webElement -> webElement.getText())
		                .filter(text -> text.matches("\\d+")) // Filter out non-integer values
		                .map(Integer::parseInt)
		                .collect(Collectors.toList());

		        return isSorted(location);
		    }

		    
		    public boolean isUserDetailsSortedByPhoneNo() {
		        List<WebElement> userPhNo = driver.findElements(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
		        List<Integer> phone = userPhNo.stream()
		                .map(webElement -> webElement.getText())
		                .filter(text -> text.matches("\\d+")) // Filter out non-integer values
		                .map(Integer::parseInt)
		                .collect(Collectors.toList());

		        return isSorted(phone);
		    }

//		    private boolean isSorted2(List<Integer> list) {
//		        for (int i = 0; i < list.size() - 1; i++) {
//		            if (list.get(i) > list.get(i + 1)) {
//		                return false;
//		            }
//		        }
//		        return true;
//		    }
}