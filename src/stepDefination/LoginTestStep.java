package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestStep 
{

	WebDriver driver;
	@Given("^Open Browser and launch facebook$")
	public void open_Browser_and_launch_facebook() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
	}

	@When("^User enters user name \"([^\"]*)\" and password \"([^\"]*)\" and Click Login$")

	public void user_enters_user_name_and_password_and_Click_Login(String userName,String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();

	}


	@Then("^User should be able to login Successfully$")
	public void user_should_be_able_to_login_Successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String currentURL=driver.getCurrentUrl();
		Assert.assertTrue("Redirected to URL: "+currentURL+" Test Fail",currentURL.contains("welcome"));

	}


	@Then("^User should not be able to login and get error message$")
	public void user_should_not_be_able_to_login_and_get_error_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String currentURL=driver.getCurrentUrl();
		Assert.assertTrue("Redirected to URL: "+currentURL+" Test Fail",currentURL.contains("https://www.facebook.com/login.php?login_attempt="));

	}

	@And("^Close browser$")
	public void Close_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
	}



}
