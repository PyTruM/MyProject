package test_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class TestHomePage {

    private final By byUser = By.name("user");
    private final By byPass = By.name("password");
    private final By byBtn = By.id("button_submit_login_form");

    private final WebDriver driver;
    private final String emptiness = "";

    private WebElement user;
    private WebElement pass;
    private WebElement btn;

    public TestHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getUser() {
        return user = driver.findElement(byUser);
    }

    public void setUser(WebElement user) {
        this.user = user;
    }

    public WebElement getPass() {
        return pass = driver.findElement(byPass);
    }

    public void setPass(WebElement pass) {
        this.pass = pass;
    }

    public WebElement getBtn() {
        return btn = new WebDriverWait(driver, Duration.ofSeconds(1000)).
                until(d -> d.findElement(byBtn));
    }

    public void setBtn(WebElement btn) {
        this.btn = btn;
    }

    public void logic(String login, String password) {
        emptyLoginAndPassword();
        inValidLogin(login, password);
        inValidPassword(login, password);
        inValidLoginAndPassword(login, password);
        clickForgotPassword();
    }

    public void emptyLoginAndPassword() {

        String login = getUser().getText();
        String password = getPass().getText();

        if (login.equalsIgnoreCase(emptiness) && password.equalsIgnoreCase(emptiness)
                || login.equalsIgnoreCase(emptiness) || password.equalsIgnoreCase(emptiness)) {
            System.out.println("Пустые поля прошли проверку");
            getBtn().click();
            driver.switchTo().alert().accept();
        }
    }

    public void inValidLogin(String validLogin, String validPassword) {

        String inValidLogin = "qwerty";
        getUser().sendKeys(inValidLogin);
        getPass().sendKeys(validPassword);
        String login = getUser().getText();
        String password = getPass().getText();

        if (!login.equalsIgnoreCase(validLogin) && password.equalsIgnoreCase(emptiness)
                || !login.equalsIgnoreCase(validLogin) && password.equalsIgnoreCase(validPassword)) {
            System.out.println("Невалидный логин прошёл проверку");
            getBtn().click();
            driver.switchTo().alert().accept();
        }
    }

    public void inValidPassword(String validLogin, String validPassword) {

        String inValidPassword = "ytrewq";
        getUser().sendKeys(validLogin);
        getPass().sendKeys(inValidPassword);
        String login = getUser().getText();
        String password = getPass().getText();

        if (!password.equalsIgnoreCase(validPassword) && login.equalsIgnoreCase(emptiness)
                || !password.equalsIgnoreCase(validPassword) && login.equalsIgnoreCase(validLogin)) {
            System.out.println("Невалидны пароль прошёл проверку");
            getBtn().click();
            driver.switchTo().alert().accept();
        }
    }

    public void inValidLoginAndPassword(String validLogin, String validPassword) {

        String inValidLogin = "qwerty";
        String inValidPassword = "ytrewq";
        getUser().sendKeys(inValidLogin);
        getPass().sendKeys(inValidPassword);
        String login = getUser().getText();
        String password = getPass().getText();

        if (!login.equalsIgnoreCase(validLogin) && !password.equalsIgnoreCase(validPassword)) {
            System.out.println("Невалидные логин и пароль прошли проверку");
            getBtn().click();
            driver.switchTo().alert().accept();
        }
    }

    public void joinCorrectValue(String validLogin, String validPassword) {
        getUser().sendKeys(validLogin);
        getPass().sendKeys(validPassword);
        getBtn().click();
        System.out.println("Успешный вход в личный кабинет");
    }

    public void clickForgotPassword() {
        WebElement forgotPassword = driver.findElement(By.xpath("//*[@id='login_form_panel']/table[2]/tbody/tr/td/a"));
        forgotPassword.click();
        System.out.println("Переход на страницу восстановления пароля");
    }
}