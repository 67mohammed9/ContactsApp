package sample;

public class Contacts {
    private String first;
    private String last;
    private String phoneNumber;
    private String email;

    public Contacts(String first, String last, String phoneNumber, String email) {
        this.first = first;
        this.last = last;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
    public String toString() {return getFirst() + " " + getLast();}
}
