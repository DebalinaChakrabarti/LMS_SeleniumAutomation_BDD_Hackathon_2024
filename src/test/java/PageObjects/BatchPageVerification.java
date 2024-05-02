package PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BatchPageVerification {

	private WebDriver driver; 

	private By batchnav = By.xpath("//button[@id='batch']/span[1]");
	private By batchheader = By.xpath("//div[@class='box']");	
	private By batchpaginator = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[2]");
	private By batchnametable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]");
	private By batchdesctable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]");
	private By batchstatustable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]");	
	private By batchclasstable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]");	
	private By batchpgmnametable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]");
	private By batchedittable = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]");
	private By batchdisabledelete = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button");
	private By batchnew = By.xpath("//*[@id=\"new\"]/span[2]");	
	private By batchcheckbox = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]");
	private By batchediticon = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[1]/button/span[1]");
	private By batchdeleteicon = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[2]/button/span[1]");	
	private By newbatchname = By.xpath("//*[@id=\"batchName\"]");	
	private By batchclose = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[1]/div/button");
	private By dTable = By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']");
	private By chkBox = By.xpath("//div[@class='p-checkbox p-component']");
	private By pginationText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By pginationIcon = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");
	
	

	public BatchPageVerification(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void clickbatch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(batchnav).click();
	}

	public void checkurl() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String geturl = driver.getCurrentUrl();
		assertEquals(true, geturl.contains("batch"));
	}

	public void checkheader() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		String getheader = driver.findElement(batchheader).getText();
		assertEquals(true, getheader.equals("Manage Batch"));
	}
	
	public void checkpaginator() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//System.out.println("page "+driver.findElement(batchpaginator).getText());
		
		assertEquals(true, driver.findElement(pginationIcon).isDisplayed());

	}
	
	public void checktableheader() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		assertEquals(true, driver.findElement(batchnametable).getText().equals("Batch Name"));
		assertEquals(true, driver.findElement(batchdesctable).getText().equals("Batch Description"));
		assertEquals(true, driver.findElement(batchstatustable).getText().equals("Batch Status"));		
		assertEquals(true, driver.findElement(batchclasstable).getText().equals("No Of Classes"));
		assertEquals(true, driver.findElement(batchpgmnametable).getText().equals("Program Name"));
		assertEquals(true, driver.findElement(batchedittable).getText().equals("Edit / Delete"));
		
	}
	
	public void checkdisabledeleteicon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		assertEquals(false, driver.findElement(batchdisabledelete).isEnabled());
		
	}
	
	public void checknewbatch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		assertEquals(true, driver.findElement(batchnew).getText().equals("A New Batch"));
		
	}
	
	public void batchcheckbox() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
       // System.out.println("checkbox "+driver.findElement(batchcheckbox).getAttribute("role"));
		//assertEquals(true, driver.findElement(batchcheckbox).getAttribute("role").equals("checkbox"));
		
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

        // System.out.println("totalcheck "+totalRowsWithCheckBoxes);
         assertEquals(true, totalRowsWithCheckBoxes > 0);
	}
	
	public void checkediticon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	    //System.out.println("checkbox "+driver.findElement(batchcheckbox).getCssValue(""));
		//assertEquals(true, driver.findElement(batchcheckbox).getAttribute("role").equals("checkbox"));
		
	
        WebElement dataTable = driver.findElement(dTable);
        List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
        int totalRowsWithediticon = 0;
        
        // Iterating over each row to check for checkboxes
        for (WebElement row : rows) {
            // Finding all checkboxes in the current row
            List<WebElement> checkboxes = row.findElements(batchediticon);
          
            // Checking if the current row contains a checkbox
            if (!checkboxes.isEmpty()) {
                totalRowsWithediticon++; // Incrementing the count of rows with checkboxes
            }
        }
    // System.out.println("totaledit "+totalRowsWithediticon);
        assertEquals(true, totalRowsWithediticon > 0);
		
	}
	
	public void checkdeleteicon() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	    //System.out.println("checkbox "+driver.findElement(batchcheckbox).getCssValue(""));
		//assertEquals(true, driver.findElement(batchcheckbox).getAttribute("role").equals("checkbox"));
		
        WebElement dataTable = driver.findElement(dTable);
        List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
        int totalRowsWithdeleteicon = 0;
        
        // Iterating over each row to check for checkboxes
        for (WebElement row : rows) {
            // Finding all checkboxes in the current row
            List<WebElement> checkboxes = row.findElements(batchdeleteicon);
          
            // Checking if the current row contains a checkbox
            if (!checkboxes.isEmpty()) {
                totalRowsWithdeleteicon++; // Incrementing the count of rows with checkboxes
            }
        }
     //   System.out.println("totaldelete "+totalRowsWithdeleteicon);
        assertEquals(true, totalRowsWithdeleteicon > 0);
	}
	public void clicknewbatch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(batchnew).click();
	}
	
	public void checknewbatchdetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		assertEquals(true, driver.findElement(newbatchname).getAttribute("type").equals("text"));
	}
}
