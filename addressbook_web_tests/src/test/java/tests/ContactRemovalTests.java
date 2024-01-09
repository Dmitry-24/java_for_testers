package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        int contactCount = app.contacts().getContactCounts();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getContactCounts();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getContactCounts());

    }

}