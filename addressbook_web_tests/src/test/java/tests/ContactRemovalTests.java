package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        app.contacts().removeContact();
    }

}