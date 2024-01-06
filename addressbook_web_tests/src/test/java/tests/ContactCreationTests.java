package tests;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        openContactsPage();
        createContact("first_name", "last_name", "address", "123456789", "test@email.ru");
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        openContactsPage();
        createContact("", "", "", "", "");

    }
}
