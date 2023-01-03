package model;

public class Customer {
    private java.lang.String name ;
    private java.lang.String birthday ;
    private java.lang.String address ;
    private java.lang.String image ;

    public Customer(java.lang.String name, java.lang.String birthday, java.lang.String address, java.lang.String image) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
