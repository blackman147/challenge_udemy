package ArrayList_challenge.bankapp;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Access Bank");

        bank.addBranch("CMD");
        bank.addCustomer("CMD", "Blackie", 50000.00);
        bank.addCustomer("CMD", "joy", 5000.30);
        bank.addCustomer("CMD", "Ini", 80000.00);

        bank.addBranch("sabo");
        bank.addCustomer("sabo", "dami", 100000);

        bank.listTransactions("CMD", true);
        bank.listTransactions("sabo", true);


        if (!bank.addBranch("sabo")){
            System.out.println("Branch sabo already exist");
        }

        if (!bank.addCustomer("jibowu", "dele", 50.00)){
            System.out.println("Customer does not exist at branch");
        }
    }

}
