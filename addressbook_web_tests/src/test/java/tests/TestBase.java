package tests;

import manager.ApplicationManager;
import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    protected static ApplicationManager app;
    protected static WebDriver driver;

    protected static void removeContact() {
        driver.findElement(By.linkText("home")).click();
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    @BeforeEach
    public void setUp2() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1550, 830));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public boolean isElementPresent2(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void createContact(ContactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(contact.phone());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    protected void openContactsPage() {
        if (!isElementPresent2(By.linkText("add new"))) {
            driver.get("http://localhost/addressbook/");
        }
    }

    protected boolean isContactPresent() {
        return isElementPresent2(By.name("selected[]"));
    }
}
