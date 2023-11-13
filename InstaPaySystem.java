import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<InstaPayAccount> instaPayAccounts;
    public InstaPaySystem() {
        instaPayAccounts = new ArrayList<>();
    }
    public void addInstaPayAccount(InstaPayAccount instaPayAccount) {
        instaPayAccounts.add(instaPayAccount);
    }
    List<InstaPayAccount> getInstaPayAccount() {
        return instaPayAccounts;
    }
    void Display () {
        for (InstaPayAccount instaPayAccount : instaPayAccounts) {
            if (instaPayAccount instanceof InsatPayBankAccount) {
                System.out.println("Name: " + instaPayAccount.user.getName());
                System.out.println("Email: " + instaPayAccount.user.getEmail());
                System.out.println("Phone Number: " + instaPayAccount.user.getPhoneNumber());
                System.out.println("Address: " + instaPayAccount.user.getAddress());
                System.out.println("Account Number: " + ((InsatPayBankAccount) instaPayAccount).accountNumber);
                System.out.println("InstaPay Bank Balance: " + instaPayAccount.balance);
                System.out.println();
            } else if (instaPayAccount instanceof InstaPayWallet) {
                System.out.println("Name: " + instaPayAccount.user.getName());
                System.out.println("Email: " + instaPayAccount.user.getEmail());
                System.out.println("Phone Number: " + instaPayAccount.user.getPhoneNumber());
                System.out.println("Address: " + instaPayAccount.user.getAddress());
                System.out.println("InstaPay Wallet Balance: " + instaPayAccount.balance);
                if (instaPayAccount instanceof InstaPayWalletVodafone) {
                    System.out.println("Type of Wallet: Vodafone");
                } else if (instaPayAccount instanceof InstaPayWalletEtisalat) {
                    System.out.println("Type of Wallet: Etisalat");
                }
                System.out.println();
            }
        }
    }
    public void runSystem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tWelcome to InstaPay Clone!");
        while (true) {
            System.out.println("\n1. Register a new account\n" +
                    "2. Login into existing account\n" +
                    "3. Exit");
            System.out.print("Enter your choice (1-3): ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\tRegistering a new account...");
            } else if (choice.equals("2")) {
                if(accounts == null){
                    System.err.println("\tNo account found, Register a new account first!");
                    continue;
                }
                Login loginObj = new Login();
                loginObj.login(accounts);
            } else if (choice.equals("3")) {
                System.out.println("\tThank you for using InstaPay Clone!");
                break;
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        InstaPaySystem sys = new InstaPaySystem();
        sys.runSystem();
    }
}