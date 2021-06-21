import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.TreeSet;

class sortingPanel {
    List<PersonalAccount> s1 = new ArrayList<>();
    public sortingPanel() throws IOException {
        String list = "";
        String name;
        String surname;
        String password;
        double cash;
        int accountNumber;

        FileReader in = new FileReader("Accounts.txt");

        BufferedReader br = new BufferedReader(in);
        String line;
        while ((line = br.readLine()) != null) {

            String[] split = line.split(",");
            name = split[0];
            surname = split[1];
            accountNumber = Integer.parseInt(split[2]);
            password = split[3];
            cash = Double.parseDouble(split[4]);

            PersonalAccount t = new PersonalAccount(name, surname, accountNumber, password, cash);
            s1.add(t);
        }
    }
    public String sortingBySurnamePanel() throws IOException, ParseException {
        String list = "";
        Collections.sort(s1);
        for(PersonalAccount str: s1){
             list += str;
        }
        return list;
    }
    public String sortingByBallancePanel() throws IOException, ParseException {
        String list = "";
        Collections.sort(s1, PersonalAccount.UserBallance);
        for(PersonalAccount str: s1){
            list += str;
        }
        return list;
    }

}
