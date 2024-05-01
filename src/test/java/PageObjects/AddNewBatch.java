package PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constants;
import Utilities.ExcelReader;

public class AddNewBatch {

	private WebDriver driver;


	private By newbatchname = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[1]");
	private By newbatchdesc = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[2]");
	private By newpgmname = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[3]");
	private By newstatus = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[4]");
	private By newclasses = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[5]");
	private By addnewbatchname = By.id("batchName");
	private By addnewbatchdesc = By.id("batchDescription");
	//private By addnewpgmname = By.id("programName");
	private By addnewpgmname = By.xpath("//*[@id=\"programName\"]/div/div[2]/span");
	private By addnewpgmname1 = By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li/span");
	
	private By addnewstatus = By.id("batchStatus");
	private By addnewclasses = By.id("batchNoOfClasses");
	private By addbutton = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[3]/button[2]");
	private By batchnew = By.xpath("//*[@id=\"new\"]/span[2]");
	private By closebutton = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[1]/div/button/span");
	private By batchnav = By.xpath("//button[@id='batch']/span[1]");
	private By errorclose = By.xpath("/p-toastitem/div/div/button");
	private By textdanger = By.id("text-danger");
	
	String ExcelPath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx"; 
	
	ExcelReader reader = new ExcelReader();
	
	public AddNewBatch(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void clicknewbatch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(batchnew).click();
	}
	

	public void newbatchname() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		assertEquals(true, driver.findElement(newbatchname).isEnabled());
	}
	
	public void newbatchdesc() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		assertEquals(true, driver.findElement(newbatchdesc).isEnabled());

	}
	public void newpgmname() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		assertEquals(true, driver.findElement(newpgmname).isEnabled());
	}
	public void newstatus() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		assertEquals(true, driver.findElement(newstatus).isEnabled());
	}
	public void newclasses() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		assertEquals(true, driver.findElement(newclasses).isEnabled());
	}
	

	public void fillallfields() {
		
		List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
		
		String bname = testdata.get(0).get("batchname"); 
		String bdesc = testdata.get(0).get("batchdesc"); 
		String noclass = testdata.get(0).get("noofclasses"); 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		
	
		driver.findElement(addnewbatchname).sendKeys(bname);
		driver.findElement(addnewbatchdesc).sendKeys(bdesc);
        driver.findElement(addnewpgmname).click();
        driver.findElement(addnewpgmname1).click();
		driver.findElement(addnewstatus).click();
		driver.findElement(addnewclasses).sendKeys(noclass);
		driver.findElement(addbutton).click();
		driver.findElement(closebutton).click();
		
	}
	
	public void invalidfields() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		
  
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
		
		String bname = testdata.get(1).get("batchname");
		String bdesc = testdata.get(1).get("batchdesc");
		String noclass = testdata.get(1).get("noofclasses");

        
	//	driver.findElement(batchnav).click();
	//	driver.findElement(batchnew).click();
		
		driver.findElement(addnewbatchname).sendKeys(bname); 
		driver.findElement(addnewbatchdesc).sendKeys(bdesc);
        driver.findElement(addnewpgmname).click();
        driver.findElement(addnewpgmname1).click();
		driver.findElement(addnewstatus).click();
		driver.findElement(addnewclasses).sendKeys(noclass);
		driver.findElement(addbutton).click();
		//driver.findElement(errorclose).click();
		driver.findElement(closebutton).click();
		//assertEquals(true, driver.findElement(textdanger).isEnabled());

	}
	
	public void missingfields() {
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

		List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
		
		String bname = testdata.get(2).get("batchname");
		String bdesc = testdata.get(2).get("batchdesc");
		String noclass = testdata.get(2).get("noofclasses");

	//	driver.findElement(batchnav).click();
	//	driver.findElement(batchnew).click();
		
	
		driver.findElement(addnewbatchname).sendKeys(bname); 
		driver.findElement(addnewbatchdesc).sendKeys(bdesc);
        driver.findElement(addnewpgmname).click();
        driver.findElement(addnewpgmname1).click();
		driver.findElement(addnewstatus).click();
		driver.findElement(addnewclasses).sendKeys(noclass);
		driver.findElement(addbutton).click();
		//driver.findElement(errorclose).click();
		driver.findElement(closebutton).click();
		//assertEquals(true, driver.findElement(textdanger).isEnabled());

	}
	
}
