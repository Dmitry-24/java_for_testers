package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        var oldContacts = app.hbm().getContactListDB();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactListDB();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getContactCounts());

    }

}