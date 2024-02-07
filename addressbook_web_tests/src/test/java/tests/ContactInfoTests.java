package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {


    @Test
    void testPhonesForAllContactsAsDB() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "", ""));
        }
        var contacts = app.hbm().getContactListDB();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.phone(), contact.mobile(), contact.work(), contact.secondary())
                    .filter(s -> s != null & ! "".equals(s))
                    .collect(Collectors.joining("/n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);

        }




    @Test
    void testPhones() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "test1@yandex.ru", "test2@yandex.ru"));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var id = contact.id();
        var phones = app.contacts().getPhones(contact);
        var result = new HashMap<String, String>();
        result.put(id, phones);
        var expected = app.contacts().getEditPagePhones(contact);
        Assertions.assertEquals(result, expected);


    }


    @Test
    void testEmails() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "test1@yandex.ru", "test2@yandex.ru"));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var id = contact.id();
        var emails = app.contacts().getEmails(contact);
        var result = new HashMap<String, String>();
        result.put(id, emails);
        var expected = app.contacts().getEditPageEmails(contact);
        Assertions.assertEquals(result, expected);


    }

    @Test
    void testAdress() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "1111", "2222", "3333", "", "test1@yandex.ru", "test2@yandex.ru"));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var addresses = app.contacts().getAdress(contact);
        var expected = app.contacts().getEditPageAdress(contact);
        Assertions.assertEquals(addresses, expected);


    }

        


    }









