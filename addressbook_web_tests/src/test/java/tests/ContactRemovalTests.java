package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCounts() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru", "", "", "", ""));
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
            app.contacts().createContact(new ContactData("", "first_name", "last_name", "address", "123456789", "test@email.ru", "", "", "", ""));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getContactCounts());

    }

    @Test
    public void canRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withAddress(CommonFunctions.randomString(10)));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData()
                    .withName(CommonFunctions.randomString(10))
                    .withHeader(CommonFunctions.randomString(10))
                    .withFooter(CommonFunctions.randomString(10)));
        }

        var contact = app.hbm().getContactListDB().get(0);
        var group = app.hbm().getGroupList().get(0);
        var contactsInGroup = app.hbm().getContactsInGroup(group).contains(contact);
        if (!contactsInGroup) {
            app.contacts().addContactToGroup(contact, group);
        }
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().removeContactFromGroup(group, contact);
        var newRelated = app.hbm().getContactsInGroup(group);

        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(contact);
        Assertions.assertEquals(newRelated, expectedList);



    }

}