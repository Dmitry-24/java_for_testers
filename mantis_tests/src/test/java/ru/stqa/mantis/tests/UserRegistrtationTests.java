package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrtationTests extends TestBase {



    @Test
    void canRegisterUser(Object username) {
        var email = String.format("%slocalhost", username);
    }


        //создать пользователя(адресс) на почтовом сервере(JamesHelper)

        //заполняе форму создания и отправляем (браузер)
        //ждём письмо(MailHelper)
        //извлекаем сслыку из письма
        //пороходим по ссылке и завершаем регистрацию пользователя(браузер)
        //проверяем что пользователь может залогиниться(HttpSessionHelper)





}
