package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.Constants;



public class HomePage {

	private WebDriver driver;

	private By signOutlink = By.xpath("//a[contains(text(),'Sign out')]");
	private By tryherelink = By.linkText("Try here>>>");
	private By runbutton = By.xpath("//button[contains(text(),'Run')]");
	private By arrayGetStart = By.xpath("//a[@href ='array']");
	private By datastructuresGetStart = By.xpath("//a[@href ='data-structures-introduction']");
	private By linkedlistGetStart = By.xpath("//a[@href ='linked-list']");
	private By stackGetStart = By.xpath("//a[@href ='stack']");
	private By queueGetStart = By.xpath("//a[@href ='queue']");
	private By treeGetStart = By.xpath("//a[@href ='tree']");
	private By graphGetStart = By.xpath("//a[@href ='graph']");
	private By tryeditor = By.xpath("//div[@class='input'] ");
	private By answerform = By.id("output");
	private By signInlink = By.xpath("//a[contains(text(),'Sign in')]");
	private By getstarted = By.linkText("Get Started");
	private By register = By.linkText(" Register ");


	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
//----------- below functions to click on elements which are commonly used for all modules -------	
	public void clickOnTryHere()
	{
		driver.findElement(tryherelink).click();
		System.out.println("Hello");
	}
	public void clickOnRunButton()
	{
		driver.findElement(runbutton).click();
	}
	
	public void clickOnGetStarted()
	{
		driver.findElement(getstarted).click();
	}
	public void clickOnSignIn()
	{
		driver.findElement(signInlink).click();
	}
	public void startHomePage(String pageName)
	{
		if(pageName.equalsIgnoreCase("array"))
			driver.findElement(arrayGetStart).click();
		else if(pageName.equalsIgnoreCase("data-structures-introduction"))
			driver.findElement(datastructuresGetStart).click();
		else if(pageName.equalsIgnoreCase("linked-list"))
			driver.findElement(linkedlistGetStart).click();
		else if(pageName.equalsIgnoreCase("stack"))
			driver.findElement(stackGetStart).click();
		else if(pageName.equalsIgnoreCase("queue"))
			driver.findElement(queueGetStart).click();
		else if(pageName.equalsIgnoreCase("tree"))
			driver.findElement(treeGetStart).click();
		else if(pageName.equalsIgnoreCase("graph"))
			driver.findElement(graphGetStart).click();
		else
			System.out.println("Page cannot be found-home");
		
	}
// -------- below funtions for getting page's url and title --------	
	
	public void getTryEditor()
	{
		driver.get(Constants.tryEditor);
	}
	public void getDsAlgoPortalUrl()
	{
		driver.get(Constants.dsAlgoLandingUrl);
	}
	public void getHomeUrl()
	{
		driver.get(Constants.homeUrl);
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public String getCurrentPageTitle()
	{
		return driver.getCurrentUrl();
	}
	public void getHomePage(String pageName)
	{
		if(pageName.equalsIgnoreCase("array"))
			driver.get(Constants.arrayUrl);
		else if(pageName.equalsIgnoreCase("data-structures-introduction"))
			driver.get(Constants.dsUrl);
		else if(pageName.equalsIgnoreCase("linked-list"))
			driver.get(Constants.linkedlistUrl);
		else if(pageName.equalsIgnoreCase("stack"))
			driver.get(Constants.stackUrl);
		else if(pageName.equalsIgnoreCase("queue"))
			driver.get(Constants.queueUrl);
		else if(pageName.equalsIgnoreCase("tree"))
			driver.get(Constants.treeUrl);
		else if(pageName.equalsIgnoreCase("graph"))
			driver.get(Constants.graphUrl);
		else
			System.out.println("Page cannot be found-home");
	}
// ------------------- below functions are to check whether an element exixts --------------
	
	public boolean isSignInExists()
	{
		return driver.findElement(signInlink).isDisplayed();
	}
	public boolean istryEditorExists()
	{
		return driver.findElement(tryeditor).isDisplayed();
	}
	public boolean isRunButtonExists()
	{
		return driver.findElement(runbutton).isDisplayed();
	}
	public boolean isRegisterLinkExists()
	{
		return driver.findElement(register).isDisplayed();
	}
	public boolean isSignOutExists()
	{
		return driver.findElement(signOutlink).isDisplayed();
	}
	public boolean isAnswerDisplayed() throws InterruptedException
	{
		String text =  driver.findElement(answerform).getText();
		if(text.isBlank())
			return false;
		return true;
	}

	public void fillCodeEditor(String code) throws InterruptedException
	{
		WebElement textarea = driver.findElement(tryeditor);
		Actions action = new Actions(driver);
		action.sendKeys(textarea, code).build().perform();

		
	}
	
}
