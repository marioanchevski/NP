package labs.lab03.phone_book;

import java.util.Arrays;

public class PhoneBook {
    private Contact[] contacts;
    public static final int MAX_CONTACTS = 250;
    private int numberOfContacts;

    public PhoneBook() {
        contacts = new Contact[MAX_CONTACTS];
        numberOfContacts = 0;
    }

    public void addContact(Contact contact) throws MaximumSizeExceddedException, InvalidNameException {
        if(numberOfContacts == MAX_CONTACTS)
            throw new MaximumSizeExceddedException();
        for (Contact c : contacts)
            if (c.getName().equals(contact.getName()))
                throw new InvalidNameException();
        contacts[numberOfContacts++] =  contact;
    }
    public Contact getContactForName(String name){
        Contact c = null;
        for(Contact contact: contacts)
            if (contact.getName().equals(name)){
                c = contact;
                break;
            }
        return c;
    }

    public int numberOfContacts(){
        return numberOfContacts;
    }

    public Contact[] getContacts(){
        Contact[] result = Arrays.copyOf(contacts, contacts.length);
        Arrays.sort(result);
        return result;
    }

    public boolean removeContact(String name){
        int index = 0;
        for(int i=0;i<numberOfContacts;i++){
            if (name.equals(contacts[i].getName())){
                contacts[i] = null;
                return true;
            }
        }
        return false;
    }


}
