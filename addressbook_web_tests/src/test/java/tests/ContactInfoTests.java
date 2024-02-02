package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "", ""));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var emails = app.contacts().getEmails(contact);
        var adress = app.contacts().getAdress(contact);
        var expectedPhones = Stream.of(contact.phone(), contact.mobile(), contact.work(), contact.secondary())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expectedPhones, phones);
        var expectedEmails = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expectedEmails, emails);
        var expectedAdress = Stream.of(contact.address())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expectedAdress, adress);


    }

    @Test
    void testPhonesForAllContacts() {
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
    void testEmails() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "", ""));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var emails = app.contacts().getEmails(contact);
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expected, emails);

    }

    @Test
    void testAdress() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", "", "", ""));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var adress = app.contacts().getAdress(contact);
        var expected = Stream.of(contact.address())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expected, adress);

    }

        


    }









