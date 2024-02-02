package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactListDB();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testContactData = new ContactData().withFirstName("modified first_name");
        app.contacts().modifyContact(oldContacts.get(index), testContactData);
        var newContacts = app.hbm().getContactListDB();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testContactData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }

}
