package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("first_name", "last_name", "address", "123456789", "test@email.ru"));
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());

    }

    @Test
    public void canCreateContactWithFirst_nameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("some first_name"));
    }
}
