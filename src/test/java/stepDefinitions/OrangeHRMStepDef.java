package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Admin;
import pages.Buzz;
import pages.DashBoard;
import pages.Directory;
import pages.Leave;
import pages.LoginPage;
import pages.MyInfo;
import pages.PIM;
import pages.PerformancePage;
import pages.Recruitment;
import pages.TimePage;
import utilities.CommonMethods;
import utilities.DriverUtils;

public class OrangeHRMStepDef {
	WebDriver driver;
	DashBoard dashboard;
	Directory directory;
	LoginPage loginpage;
	Admin admin;
	Buzz buzz;
	Leave leave;
	MyInfo myinfo;
	PerformancePage performancepage;
	PIM pim;
	Recruitment recruitment;
	TimePage timePage;
	CommonMethods commonmethods;
	Scenario scenario;
	final Logger logger = LogManager.getLogger(stepDefinitions.OrangeHRMStepDef.class);
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Given("^User Opens the required application$")
	public void user_Opens_the_required_application() throws Throwable {
		driver = DriverUtils.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    dashboard = new DashBoard(driver);
	    directory = new Directory(driver);
	    loginpage = new LoginPage(driver);
	    admin = new Admin(driver);
	    buzz = new Buzz(driver);
	    leave = new Leave(driver);
	    myinfo = new MyInfo(driver);
	    performancepage = new PerformancePage(driver);
	    pim = new PIM(driver);
	    recruitment = new Recruitment(driver);
	    timePage = new TimePage(driver);
	    commonmethods = new CommonMethods(driver);
	    logger.info("Test Started");
	}

	@When("^User logs in the application$")
	public void user_logs_in_the_application() throws Throwable {
		logger.info("Step Started : user Logs in the Application");
	    loginpage.login();
	}

	@Then("^Verify User is on DashBoard$")
	public void verify_User_is_on_DashBoard() throws Throwable {
	    dashboard.verifyDBTitle(); 
	}
	
	@Then("^User navigates to the Admin tab$")
	public void user_navigates_to_the_Admin_tab() throws Throwable {
	    admin.clickOnAdminTab();
	}

	@Then("^User verifies that header of the tab is \"([^\"]*)\"$")
	public void user_verifies_that_header_of_the_tab_is(String header) throws Throwable {
	    commonmethods.verifyHeader(header);
	}

	@Then("^User navigates to the PIM tab$")
	public void user_navigates_to_the_PIM_tab() throws Throwable {
	    pim.clickOnPIMTab();
	}

	@Then("^User navigates to the Leave tab$")
	public void user_navigates_to_the_Leave_tab() throws Throwable {
	    leave.clickOnLeaveTab();
	}

	@Then("^User navigates to the Time tab$")
	public void user_navigates_to_the_Time_tab() throws Throwable {
	    timePage.clickOnTimeTab();
	}

	@Then("^User navigates to the Recruitment tab$")
	public void user_navigates_to_the_Recruitment_tab() throws Throwable {
	    recruitment.clickOnRecruitmentTab();
	}

	@Then("^User navigates to the My Info tab$")
	public void user_navigates_to_the_My_Info_tab() throws Throwable {
	    myinfo.clickOnMyInfoTab();
	}

	@Then("^User navigates to the Performance tab$")
	public void user_navigates_to_the_Performance_tab() throws Throwable {
	    performancepage.clickOnPerformanceTab();
	}

	@Then("^User navigates to the Directory tab$")
	public void user_navigates_to_the_Directory_tab() throws Throwable {
	    directory.clickOnDirectoryTab();
	}

	@Then("^User navigates to the Buzz tab$")
	public void user_navigates_to_the_Buzz_tab() throws Throwable {
		buzz.clickOnBuzzTab();
	}
	
	@Then("^User closes the Browser$")
	public void user_closes_the_Browser() throws Throwable {
	    driver.quit();
	    
	}
	
	
}
