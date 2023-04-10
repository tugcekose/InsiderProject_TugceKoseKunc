package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseDriver {
    protected WebDriver driver;
    protected String URL = "https://useinsider.com/";
    protected String URLForSecondWindow = "https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("--remote-allow-origins=*");
        Options.addArguments("disable-notifications");


        if (browser.equals("chrome")) {

            //System.setProperty("webdriver.gecko.driver","pathOfTheChromeOnTheComputer"); >>>>> with the new update of selenium there is no need to use this line anymore or no need to add bonigarcia.
            driver = new ChromeDriver(Options);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get(URL);

        } else if (browser.equals("firefox")) {

            //System.setProperty("webdriver.gecko.driver","pathOfTheChromeOnTheComputer");

            driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get(URL);

        }


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
