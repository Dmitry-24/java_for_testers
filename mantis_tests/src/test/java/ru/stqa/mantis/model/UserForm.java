package ru.stqa.mantis.model;

public record UserForm(String name, String realname, String email, String password) {

    public UserForm() {
        this("", "","", "");
    }

    public UserForm withName(String name) {
        return new UserForm(name, this.realname, this.email, this.password);
    }

    public UserForm withReal(String realname) {
        return new UserForm(this.name, realname, this.email, this.password);
    }


    public UserForm withEmail(String email) {
        return new UserForm(this.name, this.realname, email, this.password);
    }
    public UserForm withPassword(String password) {
        return new UserForm(this.name, this.realname, this.email, password);
    }
}
