import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class adminPanel {
    private int accountNumber;
    List<Transaction> transaction = new ArrayList<>();

    public adminPanel() throws IOException, ParseException {
        //WCZYTUJE WSZYSTKIE TRANSAKCJE I ZAPISUJE JE DO LISTY
        String name;
        Date date;
        double cash;
        int accountNumber;
        SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        FileReader in = new FileReader("transaction.txt");

        BufferedReader br = new BufferedReader(in);
        String line;

        while((line = br.readLine()) != null){
            String[] split = line.split(",");
            name = split[0];
            accountNumber = Integer.parseInt(split[1]);
            date = date1.parse(split[2]);
            cash = Double.parseDouble(split[3]);

            Transaction t = new Transaction(name, date, cash, accountNumber);
            transaction.add(t);
        }




    }

    public String printAccountInformation(int client){
        Printer p = new Printer(transaction);
        String transactions = p.print(t -> t.getAccountNumber() == client);



        return transactions;
    }

    interface Filtr{
        boolean accept(Transaction t);
    }

    class Printer{
        List<Transaction> transaction;

        public Printer(List<Transaction> transaction){
            super();
            this.transaction = transaction;
        }

        public String print(Filtr f){
            String s = "";
            for(Transaction t:transaction){
                if(f.accept(t))
                    s +=t.toString() + "\n\n";
            }

            return s;
        }

    }
}


