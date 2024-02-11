package ru.stqa.mantis.model;

public record UserForm(String name, String email, String password) {

    public UserForm() {
        this("", "","");
    }


    public UserForm withName(String name) {
        return new UserForm(name, this.email, this.password);
    }

    public UserForm withEmail(String email) {
        return new UserForm(this.name, email, this.password);
    }
    public UserForm withPassword(String password) {
        return new UserForm(this.name, this.email, password);
    }
}
