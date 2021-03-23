package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.HomePage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

	WebDriver driver = DriverFactory.getdriver();

	HomePage homepage = new HomePage();

	@Given("user is on home page and validate title {string}")
	public void user_is_on_home_page_and_validate_title(String Homepagetitle) {

		driver.get("http://www.google.com");
		String title = homepage.getpagetitle();
		System.out.println("Title of the Page is ::  " + title);
		Assert.assertEquals(title, Homepagetitle);

	}

	@Then("user validate the logo")
	public void user_validate_the_logo() {
		boolean flag = homepage.validatelogo();
		System.out.println("Google logo is displayed at HomePage :: " + flag);
	}

	@Then("user click on search bar and type {string}")
	public void user_click_on_search_bar_and_type(String searchwith) {

		homepage.searchlink(searchwith);

	}

	@Then("user verify that the search button is enable")
	public void user_verify_that_the_search_button_is_enable() {
		boolean flag = homepage.validatesearchbutton();
		System.out.println("Search Button is Enable  : " + flag);
	}

	@Then("user click on search button without entering anything")
	public void user_click_on_search_button_without_entering_anything() {
		homepage.clickonsearchbutton();
		Assert.assertNotEquals("Google","search terms - Google Search");

	}

}
