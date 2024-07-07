package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserSetup {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        System.out.println("INFO: Browser is started");
    }

    @After
    public void shutDown(){
        driver.close();
        driver.quit();

        System.out.println("INFO: Browser is closed");
    }
}
