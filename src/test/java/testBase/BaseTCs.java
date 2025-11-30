package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTCs {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"Master", "Regressio", "Sanity", "DataDriven"})
	@Parameters({"OS","browser"})
	public void setUp(String os, String br) throws IOException {
		
		FileReader pFile = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(pFile);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//OS
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("Invalid OS");
				return;
			}
			
			//Browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default: System.out.println("Invalid Browser"); return;
			}
			
			String hubUrl = "http://localhost:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid Browser"); return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		pFile.close();
		
	}
	
	@AfterClass(groups= {"Master", "Regressio", "Sanity", "DataDriven"})
	public void tearDown() {
		driver.quit();
	}
	
	
	//Screenshot
	public String captureSS(String nameOfSS) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+nameOfSS+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	
	

	@SuppressWarnings("deprecation")
	public String randomAlphabates() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumbers() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNums() {
		String generatedNumbers = RandomStringUtils.randomNumeric(3);
		String generatedAlphabates = RandomStringUtils.randomAlphabetic(5);
		return (generatedAlphabates+"@"+generatedNumbers);
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphanumerics() {
		String AlphaNumerics = RandomStringUtils.randomAlphanumeric(8);
		System.out.println("Random AlphaNumeric is: "+AlphaNumerics);
		return AlphaNumerics;
	}
	
	
	
}
