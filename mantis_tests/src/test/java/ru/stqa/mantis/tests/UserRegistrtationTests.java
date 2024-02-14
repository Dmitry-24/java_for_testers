package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;

public class UserRegistrtationTests extends TestBase {

    DeveloperMailUser user;

    @Test
    void canRegisterUser() throws InterruptedException {
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email, password);
        app.user().userRegistrationForMainForm(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var url = app.mail().getUrl(messages);
        app.user().confirmData(url, "testName", password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }

    @Test
    void canRegisterUserWithDeveloperMail() throws InterruptedException {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

        app.user().userRegistrationForMainForm(user.name(), email);

        var message = app.developerMail().receive(user, Duration.ofSeconds(60));
        var url = CommonFunctions.extractLinkText(message);
        app.mail().getUrlLink(url);

        app.user().fillAccount(user.name(), password);
        app.http().login(user.name(), password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }
    
    @Test
    void canRegisterUserApi() throws InterruptedException {
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);

        app.jamesApi().addUser(email, password);
        app.rest().userRegistrationForMainForm(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var url = app.mail().getUrl(messages);
        app.user().confirmData(url, "Bob", password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }

    /*@AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(user);
    }*/



    //создать пользователя(адресс) на почтовом сервере(JamesHelper)
        //заполняе форму создания и отправляем (браузер)
        //ждём письмо(MailHelper)
        //извлекаем сслыку из письма
        //пороходим по ссылке и завершаем регистрацию пользователя(браузер)
        //проверяем что пользователь может залогиниться(HttpSessionHelper)





}
