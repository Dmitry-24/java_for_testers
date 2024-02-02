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
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", ""));
        }
        var contacts = app.hbm().getContactListDB();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var expected = Stream.of(contact.phone(), contact.mobile(), contact.work(), contact.secondary())
                .filter(s -> s != null & ! "".equals(s))
                .collect(Collectors.joining("/n"));
        Assertions.assertEquals(expected, phones);

    }

    @Test
    void testAllPhones() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "first name", "last name", "address", "12345678", "test@yandex.ru", "", "", "", ""));
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


    }








}
