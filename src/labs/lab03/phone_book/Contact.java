package labs.lab03.phone_book;

import java.util.Arrays;

public class Contact {
    private String name;
    private String[] phoneNumber;
    public static final int MAX_NUMBERS = 5;
    private int numberOfContacts;

    public Contact(String name, String... phoneNumber) throws InvalidNameException, MaximumSizeExceddedException, InvalidNumberException {
        if (!validName(name))
            throw new InvalidNameException();
        this.name = name;
        if (!validPhoneSize(phoneNumber.length))
            throw new MaximumSizeExceddedException();
        if(!validPhone(phoneNumber))
            throw new InvalidNumberException();
        this.phoneNumber = new String[phoneNumber.length];
        for(String number: phoneNumber)
        numberOfContacts = phoneNumber.length;
    }

    private boolean validName(String name){
        if (name == null)
            return false;
        if (name.length() < 4 || name.length() > 10)
            return false;
        for(int i=0;i<name.length();i++){
            if (!(Character.isLetterOrDigit(name.charAt(i))))
                return false;
        }
        return true;
    }

    private boolean validPhoneSize(int length){
        if (length > MAX_NUMBERS || length == 0)
            return false;
        return true;
    }

    private boolean validPhone(String[] phoneNumber){
        if (phoneNumber.length > MAX_NUMBERS)
            return false;
        final String[] alowed ={"070", "071", "072", "075", "076", "078"};
        for (String number: phoneNumber){
            if (number.length()!=9)
                return false;
            for (int i=0;i<alowed.length; i++){
                if (!(alowed[i].contains(number.substring(0,3))))
                    return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String[] getPhoneNumbers() {
        String[] result = Arrays.copyOf(phoneNumber, phoneNumber.length);
        Arrays.sort(result);
        return result;
    }

    public void addNumber(String phonenumber) throws MaximumSizeExceddedException, InvalidNumberException {
        if (numberOfContacts == 5)
            throw new MaximumSizeExceddedException();
        final String[] alowed ={"070", "071", "072", "075", "076", "078"};
        if (phonenumber.length()!=9)
                throw new InvalidNumberException();
            for (int i=0;i<alowed.length; i++){
                if (!(alowed[i].contains(phonenumber.substring(0,3))))
                    throw  new InvalidNumberException();
            }
        phoneNumber[numberOfContacts++] =  phonenumber;
    }

    @Override
    public String toString() {
        return name + '\n' +
                numberOfContacts +
                Arrays.toString(getPhoneNumbers());
    }

    private static Contact valueOf(String s){
        return null;
    }
}
