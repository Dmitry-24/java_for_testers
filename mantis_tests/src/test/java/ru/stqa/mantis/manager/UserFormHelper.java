package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserFormHelper extends HelperBase {


    public UserFormHelper(ApplicationManager manager) {
        super(manager);
    }



    public void createNewUserAccount(String user, String email) {
        goToManage();
        goToUsers();
        initNewUserForm();
        fillNewUserData(user, email);
        submitNewUser();

    }

    private void goToManage () {
        click(By.xpath("//i[@class='fa fa-gears menu-icon']"));
    }

    private void goToUsers() {
        click(By.xpath("//a[text()='Users']"));
    }


    private void initNewUserForm() {
        click(By.xpath("//a[text()='Create New Account']"));
    }

    private void fillNewUserData(String user, String email){
        click(By.id("user-username"));
        type(By.id("user-username"), user);
        click(By.id("email-field"));
        type(By.id("email-field"), user);

    }

    private void submitNewUser() {
        click(By.cssSelector("input[type='submit']"));

    }


    public void userRegistrationForMainForm(String user, String email) throws InterruptedException {
        click(By.linkText("Signup for a new account"));
        type(By.id("username"), user);
        type(By.id("email-field"), email);
        Thread.sleep(5000);
        click(By.cssSelector("input[type='submit']"));
    }

    public void confirmData(String url, String realName, String password) {
        manager.driver().get(url);
        click(By.cssSelector("input[id='realname']"));
        type(By.cssSelector("input[id='realname']"), realName);
        click(By.cssSelector("input[id='password']"));
        type(By.cssSelector("input[id='password']"), password);
        click(By.cssSelector("input[id='password-confirm']"));
        type(By.cssSelector("input[id='password-confirm']"), password);
        click(By.cssSelector("button[type='submit']"));
    }

    public void fillAccount(String username, String password) {
        type(By.id("realname"), username);
        type(By.id("password"), password);
        type(By.id("password-confirm"), password);
        click(By.cssSelector("button[type='submit']"));
    }



}
