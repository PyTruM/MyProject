package test_work;

public class MainTestClass {

    public static void main(String[] args) {

        LogicTestClass test = new LogicTestClass();
        Browser browser = Browser.chrome;
        test.initBrowser(browser);
        test.launchApp();

        test.searchOnPage("fominaelena", "1P73BP4Z");
        test.shutDownTest();
    }

}
