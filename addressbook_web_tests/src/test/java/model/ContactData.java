package model;

public record ContactData(String id,
                          String firstName,
                          String lastName,
                          String address,
                          String phone,
                          String email,
                          String home,
                          String mobile,
                          String work,
                          String secondary,
                          String email2,
                          String email3) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "");

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastName, this.address, this.phone, this.email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastName, this.address, this.phone, this.email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, lastName, this.address, this.phone, this.email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.lastName, address, this.phone, this.email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, phone, this.email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, home, this.mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, mobile, this.work, this.secondary, this.email2, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, this.mobile, work, this.secondary, this.email2, this.email3);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, this.mobile, this.work, secondary, this.email2, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, this.mobile, this.work, this.secondary, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phone, email, this.home, this.mobile, this.work, this.secondary, this.email2, email3);
    }









}