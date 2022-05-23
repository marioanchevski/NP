package labs.lab01.contacts;

public abstract class Contact implements Comparable<Contact> {
    private String date;

    public Contact(String date) {
        this.date = date;
    }

    public boolean isNewerThan(Contact c){
        return this.date.compareTo(c.date)>0;
    }

    public abstract String getType();

    @Override
    public int compareTo(Contact o) {
        return this.date.compareTo(o.date);
    }
}
