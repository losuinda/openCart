package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	TakesScreenshot takesScreenshot;

	@BeforeClass(groups = {"Regration","Master","Sanity"} )
	@Parameters({ "browser" })
	public void setUp(String browser) {

//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});

		rb = ResourceBundle.getBundle("config");

		WebDriverManager.chromedriver().setup();

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("loginurl"));
		driver.manage().window().maximize();
		logger = LogManager.getLogger(this.getClass());

	}

	@AfterClass(groups = {"Regration","Master","Sanity"} )

	public void tearDown() throws InterruptedException {
		// Thread.sleep(3000);
		// driver.close();

	}

	public String randomAlpha() {
		String rand = RandomStringUtils.randomAlphanumeric(5);
		return rand;

	}

	public String randomNumber() {
		String rand = RandomStringUtils.randomNumeric(5);
		return rand;
	}

	public String randomNumberAlapha() {
		String st = RandomStringUtils.randomAlphanumeric(5);
		String rand = RandomStringUtils.randomNumeric(5);
		return (rand + st);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
