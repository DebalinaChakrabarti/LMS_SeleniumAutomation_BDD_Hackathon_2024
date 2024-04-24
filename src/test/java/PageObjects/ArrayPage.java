package PageObjects;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Constants;
import io.cucumber.messages.types.Duration;

public class ArrayPage {
	
	private WebDriver driver;

	
	private By arrayInPy = By.xpath("//a[@href='arrays-in-python']");
	private By arraysList = By.xpath("//a[@href='arrays-using-list']");
	private By basicLists = By.xpath("//a[@href='basic-operations-in-lists']");
	private By appArray = By.xpath("//a[@href='applications-of-array']");
	private By arrayPracQues = By.xpath("//a[@href='/array/practice']");
	private By searchArray = By.xpath("//a[@href='/question/1']");
	private By maxConsecutive = By.xpath("//a[@href='/question/2']");
	private By findEvenNum = By.xpath("//a[@href='/question/3']");
	private By araaySortedSq = By.xpath("//a[@href='/question/4']");
	private By codeeditor = By.xpath("//div[@class='input']");
	private By answerform = By.id("output");
	private By runButton = By.xpath("//button[@type='button']");
	
	public ArrayPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void arrayPageHome()
	{
		driver.get(Constants.arrayUrl);
	}

	public String getArrayPageTitle()
	{
		return driver.getTitle();
	}
	
	public void navigateInArray(String string) {
	
	if(string.equals("Arrays in Python")) {
		driver.findElement(arrayInPy).click();
    }else if (string.equals("Arrays Using List")) {
    	driver.findElement(arraysList).click();
    }else if (string.equals("Basic Operations in Lists")) {
    	driver.findElement(basicLists).click();    
    }else if (string.equals("Applications of Array")) {
    	driver.findElement(appArray).click();   
    } else if (string.equals("Practice Questions")) {
    	driver.findElement(arrayPracQues).click();    
	} else if (string.equals("Search The Array")) {
		driver.findElement(searchArray).click(); 
	} else if (string.equals("Max Consecutive Ones")) {
		driver.findElement(maxConsecutive).click();
	} else if (string.equals("Find Numbers with Even Numbers")) {
		driver.findElement(findEvenNum).click();
	} else if (string.equals("Squares of a Sorted Array")) {
		driver.findElement(araaySortedSq ).click();    
	}  
	}

    public void clickOnRunButton() {
	    driver.findElement(runButton).click();
    }	
    
    public void getPracticeQuestUrl()
	{
		driver.get("https://dsportalapp.herokuapp.com/array/practice");
    }
		 
	public void fillCodeEditor(String code) throws InterruptedException
	{
		WebElement textarea = driver.findElement(codeeditor);
		Actions action = new Actions(driver);
		action.sendKeys(textarea, code).build().perform();
		

	}
	public void clearCodeEditor() throws InterruptedException{
	WebElement textarea = driver.findElement(codeeditor);
	Actions action = new Actions(driver);
	  action.keyDown(textarea,Keys.SHIFT)
	   .keyDown(textarea,Keys.ARROW_DOWN)
	   .sendKeys(textarea,Keys.DELETE)
	   .keyUp(textarea,Keys.ARROW_DOWN)
	   .keyUp(textarea,Keys.SHIFT)
	   .build()
	   .perform();

		}
	public boolean isAnswerDisplayed() throws InterruptedException
	{
		String text =  driver.findElement(answerform).getText();
		if(text.isBlank())
		return false;
		return true;
	}
	
	
	public void present_alertMsg() throws InterruptedException
	{

		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		String text = alert.getText();
		alert.accept();
		}
	
}
