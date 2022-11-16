package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class DashBoard {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement headerDB;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Dashboard']")
	WebElement tabDB;
	
	public DashBoard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDBTitle() {
		Assert.assertEquals("Dashboard", headerDB.getText());
	}
	
	public void clickOnDBTab() {
		tabDB.click();
	}
	
	
}
