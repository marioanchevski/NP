package labs.lab01.contacts;

import java.util.Arrays;

public class Student {
    private Contact[] contacts;
    private String firstName;
    private String lastName;
    private String city;
    private int age;
    private long index;
    private int numberOfContacts;
    private int maxContacts;


    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        numberOfContacts = 0;
        maxContacts = 15;
        contacts = new Contact[maxContacts];
    }

    public int getNumberOfContacts(){
        return numberOfContacts;
    }

    public void addEmailContact(String date, String email){
        if (numberOfContacts == maxContacts){
            contacts = Arrays.copyOf(contacts, maxContacts * 2);
            maxContacts *= 2;
        }
        contacts[numberOfContacts++] = new EmailContact(date, email);
    }
    public void addPhoneContact(String date, String phone){
        if (numberOfContacts == maxContacts){
            contacts = Arrays.copyOf(contacts, maxContacts * 2);
            maxContacts *= 2;
        }
        contacts[numberOfContacts++] = new PhoneContact(date, phone);
    }

    public Contact[] getEmailContacts(){
        Contact[] emailContacts = new Contact[contacts.length];
        int emailNumberContacts = 0;
        for (Contact c : contacts)
            if (c!=null && c.getType().equals("Email")){
                emailContacts[emailNumberContacts++] = c;
            }
        emailContacts = Arrays.copyOf(emailContacts, emailNumberContacts);
        return emailContacts;
    }
    public Contact[] getPhoneContacts(){

        Contact[] phoneContacts = new Contact[contacts.length];
        int phoneNumberContacts = 0;
        for (Contact c : contacts)
            if (c!=null && c.getType().equals("Phone")){
                phoneContacts[phoneNumberContacts] = c;
                phoneNumberContacts++;
            }
        phoneContacts = Arrays.copyOf(phoneContacts, phoneNumberContacts);
        return phoneContacts;
    }

    public String getCity(){
        return city;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public long getIndex(){
        return index;
    }

    public Contact getLatestContact(){
        int index = 0;
        for(int i=1;i<contacts.length;i++) {
            if(contacts[i] != null && contacts[i].isNewerThan(contacts[index])){
                index = i;
            }
        }
        return contacts[index];
    }

    @Override
    public String toString() {
        return
                "{ime:" + firstName + ", " +
                "orezune:" + lastName + ", " +
                "vozrast:" + age + ", " +
                "grad:" + city + ", " +
                "inedx:" + index + ", " +
                "telefonskiKontakti:" + Arrays.toString(getPhoneContacts()) + ", " +
                "emailKontakti:" + Arrays.toString(getEmailContacts());
    }
}
