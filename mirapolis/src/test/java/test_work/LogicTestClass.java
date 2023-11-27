package test_work;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class LogicTestClass {

    private WebDriver driver;
    Duration duration = Duration.ofSeconds(10);

    public void initBrowser(final Browser browser) {
        switch (browser) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case edge:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case opera:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case safari:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public void launchApp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    public void shutDownTest() {
        driver.manage().timeouts().implicitlyWait(duration);
        driver.quit();
        System.out.println("Завершение теста");
    }

    public void searchOnPage(final String login, final String password) {
        TestHomePage testHomePage = new TestHomePage(driver);
        TestForgotPage testForgotPage = new TestForgotPage(driver);
        testHomePage.logic(login, password);
        testForgotPage.logic();
        testHomePage.joinCorrectValue(login, password);
    }


}
