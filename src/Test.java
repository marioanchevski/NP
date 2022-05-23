import labs.lab01.contacts.Contact;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static boolean isNewerThan(String c){
        int year, month, day;
        year = Integer.parseInt(c.substring(0,4));
        month = Integer.parseInt(c.substring(5,7));
        day = Integer.parseInt(c.substring(8,10));
        //this later than c
        String date = "2004-09-14";
        int myYear, myMonth, myDay;
        myYear = Integer.parseInt(date.substring(0,4));
        myMonth = Integer.parseInt(date.substring(5,7));
        myDay = Integer.parseInt(date.substring(8,10));
        if (myYear>year)
            return true;
        if (myYear==year && myMonth>month)
            return true;
        if (myYear==year && myMonth==month && myDay>day)
            return true;
        if (myYear==year && myMonth==month && myDay==day)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String date1 ="2004-03-22";
        String date2 ="2004-09-14";
        System.out.println(isNewerThan("2004-1-22"));

    }


    static boolean checkNameValid(String name){
        if (name == null)
            return false;
        if (name.length() < 4 || name.length() > 10)
            return false;
        String alowed = "abcdefghijklmnopqrstuvqxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i=0;i<name.length();i++)
        {
            char c = name.charAt(i);
            if (!(alowed.contains(Character.toString(c))))
                return false;

        }
        return true;
    }

    private boolean validPhone(String[] phoneNumber){
        if (phoneNumber.length > 5)
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
}