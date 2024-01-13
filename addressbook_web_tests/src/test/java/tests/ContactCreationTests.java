package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {



    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "first_name")) {
            for (var lastName : List.of("", "last_name")) {
                for (var address : List.of("", "address")) {
                    for (var phone : List.of("", "12345678")) {
                        for (var email : List.of("", "test@email")) {
                            result.add(new ContactData().withFirstName(firstName).withLastName(lastName).withAddress(address).withPhone(phone).withEmail(email));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withPhone(randomString(i * 10))
                    .withEmail(randomString(i * 10)));
        }
        return result;
    }


    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name'", "","","","")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contacts().getContactCounts();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getContactCounts();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getContactCounts();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getContactCounts();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
