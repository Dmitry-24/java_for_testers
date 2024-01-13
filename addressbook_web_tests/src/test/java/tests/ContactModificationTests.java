package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        app.contacts().modifyContact(new ContactData().withFirstName("modified first_name"));

    }

}
