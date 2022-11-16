package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class CommonMethods {
WebDriver driver;
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement tabHeader;
	
	public CommonMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeader(String header) {
		Assert.assertEquals(header, tabHeader.getText());
	}
}
