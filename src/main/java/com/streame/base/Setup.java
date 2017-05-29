package com.streame.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Setup {
	
	private WebDriver driver;
	static String driverPath = "C:\\Users\\dmarroquin\\Documents\\QA\\";

			
		public WebDriver getDriver() {
		return driver;
	    }
		
		private void setDriver(String browserType, String appURL) {
			switch (browserType) {
			case "chrome":
				driver = initChromeDriver(appURL);
				break;
			case "firefox":
				driver = initFirefoxDriver(appURL);
				break;
			default:
				System.out.println("browser : " + browserType
						+ " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver(appURL);
			}
		}

		private static WebDriver initChromeDriver(String appURL) {
			System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 ChromeOptions options = new ChromeOptions();
			    options.addArguments("--start-maximized");
			    options.addArguments("--disable-web-security");
			    options.addArguments("--no-proxy-server");
			    Map<String, Object> prefs = new HashMap<String, Object>();
			    prefs.put("credentials_enable_service", false);
			    prefs.put("profile.password_manager_enabled", false);
			    options.setExperimentalOption("prefs", prefs);
			    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
		}

		private static WebDriver initFirefoxDriver(String appURL) {
			System.out.println("Launching Firefox browser..");
			System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
		}
		
		@Parameters({ "browserType", "appURL" })
		@BeforeClass
		public void initializeTestBaseSetup(String browserType, String appURL) {
			try {
				setDriver(browserType, appURL);

			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
}