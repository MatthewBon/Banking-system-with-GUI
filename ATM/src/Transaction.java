import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private String name;
    private Date date;
    private double cash;
    private int accountNumber;

    public Transaction(String name, Date date, double cash, int accountNumber){
        this.name = name;
        this.date = date;
        this.cash = cash;
        this.accountNumber = accountNumber;
    }




    public String getFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);

        return formattedDate;
    }

    @Override
    public String toString() {
        return "Operacja: " + this.name + ", Numer konta: " + this.accountNumber + ", Data operacji: " + this.getFormattedDate() + ", Gotówka: " + this.cash;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
