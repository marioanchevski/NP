package labs.lab01.contacts;

public class PhoneContact extends Contact{
    private String phone;
    private Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
        setOperator();
    }

    private void setOperator(){
        char operator = phone.charAt(2);
        if ((operator == '0') || (operator == '1') || (operator == '2'))
                this.operator = Operator.TMOBILE;
        else if ((operator == '5') || (operator == '6'))
            this.operator = Operator.ONE;
        else if ((operator == '7') || (operator == '8'))
            this.operator = Operator.VIP;
        else
            this.operator = null;
    }

    @Override
    public String getType() {
        return "Phone";
    }

    public String getPhone() {
        return phone;
    }

    public Operator getOperator() {
        return operator;
    }
}
