package StepDefinations;

import org.testng.Assert;

import com.Pages.Resultpage;

import io.cucumber.java.en.And;

public class ResultPageSteps {

	
	Resultpage resultpage = new Resultpage();
	
	
	
	
	
	@And("user check the title of the page {string}")
	public void user_check_the_title_of_the_page(String title_after_search) {
		String title2 = resultpage.get_title_after_search();
		System.out.println("Title of the Page after search is ::"+title2);
		Assert.assertEquals(title2, title_after_search);
	}
}
