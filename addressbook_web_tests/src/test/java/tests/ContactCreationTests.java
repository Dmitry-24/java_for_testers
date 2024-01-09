package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        int contactCount = app.contacts().getContactCounts();
        app.contacts().createContact(new ContactData("first_name", "last_name", "address", "123456789", "test@email.ru"));
        int newContactCount = app.contacts().getContactCounts();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());

    }

    @Test
    public void canCreateContactWithFirst_nameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("some first_name"));
    }

    @Test
    public void canCreateMultipleContact() {
        int n = 5;
        int contactCount = app.contacts().getContactCounts();
        for (int i = 0; i < n; i++) {
            app.contacts().createContact(new ContactData(randomString(i), "last_name", "address", "123456789", "test@email.ru"));
        }
        int newContactCount = app.contacts().getContactCounts();
        Assertions.assertEquals(contactCount + n, newContactCount);
    }
}
