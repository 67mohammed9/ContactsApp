package sample;


import java.awt.*;

public class Contacts {
    private String first;
    private String last;
    private String phoneNumber;
    private String email;
    private Image image;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private String imagePath;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public Contacts(String first, String last, String phoneNumber, String email, Image image, String imagePath) {
        this.first = first;
        this.last = last;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image = image;
        this.imagePath = imagePath;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {return getLast() + ", " + getFirst();}
}
//Cool