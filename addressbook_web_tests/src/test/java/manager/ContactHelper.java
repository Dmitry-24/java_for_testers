package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact() {
        openContactsPage();
        selectContact();
        removeSelectedContact();
    }

    private void fillContactForm(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"), contact.firstName());
        click(By.name("lastname"));
        type(By.name("lastname"), contact.lastName());
        click(By.name("address"));
        type(By.name("address"),contact.address());
        click(By.name("home"));
        type(By.name("home"), contact.phone());
        click(By.name("email"));
        type(By.name("email"), contact.email());
    }


    public void openContactsPage() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
            manager.driver.get("http://localhost/addressbook/");
        }
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }



    private static void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private static void initContactCreation() {
        click(By.linkText("add new"));
    }



    private static void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }



    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public int getContactCounts() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
