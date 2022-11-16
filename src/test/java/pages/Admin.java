package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Admin {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Admin']")
	WebElement tabAdmin;
	
	public Admin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminTab() {
		tabAdmin.click();
	}
	
}
