package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;

public class UserRegistrtationTests extends TestBase {



    @Test
    void canRegisterUser() {
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


        //создать пользователя(адресс) на почтовом сервере(JamesHelper)
        //заполняе форму создания и отправляем (браузер)
        //ждём письмо(MailHelper)
        //извлекаем сслыку из письма
        //пороходим по ссылке и завершаем регистрацию пользователя(браузер)
        //проверяем что пользователь может залогиниться(HttpSessionHelper)





}
