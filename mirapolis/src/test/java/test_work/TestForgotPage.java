package test_work;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestForgotPage {
    private final WebDriver driver;

    @FindBy(name = "loginOrEmail")
    private WebElement loginOrEmail;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/button")
    private WebElement btn;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/form/table[2]/tbody/tr/td/a")
    private WebElement backOnHomePage;

    public TestForgotPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void logic() {
        writeLoginOrEmail();
        clickBtnSend();
        clickBackOnHomePage();
    }

    public WebElement getLoginOrEmail() {

        return loginOrEmail;
    }

    public void writeLoginOrEmail() {
        loginOrEmail.sendKeys("fominaelena");
        System.out.println("Ввод логина");
    }

    public void clickBtnSend() {
        btn.click();
        System.out.println("Восстановление");
    }

    public void clickBackOnHomePage() {
        backOnHomePage.click();
        System.out.println("Возвращение на главную страницу");
    }
}
