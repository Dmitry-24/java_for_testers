package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserFormHelper extends HelperBase {


    public UserFormHelper(ApplicationManager manager) {
        super(manager);
    }



    public void createNewUserAccount(String username, String email) {
        goToManage();
        goToUsers();
        initNewUserForm();
        fillNewUserData(username, email);
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

    private void fillNewUserData(String username, String email){
        click(By.id("user-username"));
        type(By.id("user-username"), username);
        click(By.id("email-field"));
        type(By.id("email-field"), username);

    }

    private void submitNewUser() {
        click(By.cssSelector("input[type='submit']"));

    }


    public void userRegistrationForMainForm(String username, String email) {
        click(By.linkText("Signup for a new account"));
        type(By.id("username"), username);
        type(By.id("email-field"), email);
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

}
