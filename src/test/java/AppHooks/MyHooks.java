package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.Util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	DriverFactory driverfactory;
	WebDriver driver;
	Properties prop;
	ConfigReader configreader;

	@Before
	public void initilize_driver() {
		configreader = new ConfigReader();
		prop = configreader.ReadProp();
		driverfactory = new DriverFactory();

		String browsername = prop.getProperty("browser");
		System.out.println("Browser Open Method is working fine");
		driver = driverfactory.init_driver(browsername);

	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
		Thread.sleep(1000);
		driver.quit();

	}
}
