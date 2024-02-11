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


}
