package model;

public class Contacts {
    private int contactsID;
    private String contactsName;

    public Contacts(int contactsID, String contactsName){
        this.contactsID= contactsID;
        this.contactsName = contactsName;
    }
    public int getContactsID() {
        return contactsID;
    }

    public void setContactsID(int contactsID) {
        this.contactsID = contactsID;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {

        this.contactsName = contactsName;
    }
}
