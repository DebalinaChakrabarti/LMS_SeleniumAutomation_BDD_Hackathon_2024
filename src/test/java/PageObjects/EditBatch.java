package PageObjects;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.ExcelReader;

public class EditBatch {

	private WebDriver driver;

	private By editicon = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[1]/button");
	private By editbatchname = By.xpath("//*[@id=\"batchName\"]");
	private By editbatchdesc = By.xpath("//*[@id=\"batchDescription\"]");
	private By editnoofclass = By.xpath("//*[@id=\"batchNoOfClasses\"]");
	private By saveedit = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[3]/button[2]");
	private By editclose = By.xpath("/html/body/app-root/app-batch/p-dialog/div/div/div[1]/div/button");
	private By textdanger = By.id("text-danger"); 
	

	String ExcelPath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx";
	
	ExcelReader reader = new ExcelReader();
	
	public EditBatch(WebDriver driver)
	{
		this.driver = driver;
		
	}

	   public void editenable() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			assertEquals(true, driver.findElement(editicon).isEnabled());
		   
	   }
	   public void clickedit() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(editicon).click();
		   
	   }
	   
	   public void updatevalues() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
			
			String bdesc = testdata.get(3).get("batchdesc"); 
			String noclass = testdata.get(3).get("noofclasses"); 

	
			driver.findElement(editbatchdesc).clear();
			driver.findElement(editbatchdesc).sendKeys(bdesc);
			driver.findElement(editnoofclass).clear();
			driver.findElement(editnoofclass).sendKeys(noclass);
		    driver.findElement(saveedit).click();
			
	   }

	   public void updateinvalidvalues() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
			
			String bdesc = testdata.get(4).get("batchdesc"); 
			String noclass = testdata.get(4).get("noofclasses"); 

		
			driver.findElement(editbatchdesc).clear();
			driver.findElement(editbatchdesc).sendKeys(bdesc);
			driver.findElement(editnoofclass).clear();
			driver.findElement(editnoofclass).sendKeys(noclass);
		    driver.findElement(saveedit).click();
		    driver.findElement(editclose).click();
		   // assertEquals(true, driver.findElement(textdanger).isEnabled());			
	   }

	   public void erasemandatory() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			List<Map<String,String>> testdata = reader.getData(ExcelPath, "Sheet1");
			
			String bdesc = testdata.get(5).get("batchdesc");
			String noclass = testdata.get(5).get("noofclasses"); 
			
			driver.findElement(editbatchdesc).clear();
			//driver.findElement(editbatchdesc).sendKeys(bdesc);
			driver.findElement(editbatchdesc).sendKeys("");
			driver.findElement(editnoofclass).clear();
			driver.findElement(editnoofclass).sendKeys(noclass);
		    driver.findElement(saveedit).click();
		    driver.findElement(editclose).click();

	   }

}
