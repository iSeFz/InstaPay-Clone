import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<InstaPayAccount> accounts;

    /* 
    ##### For TESTING Purposes #####
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
    } */

    // Sub menu that appear after logging in to a certain account
    private void subMenu(InstaPayAccount account) {
        System.out.println("\tWelcome " + account.user.getName() + " to InstaPay Clone!");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Transfer Money\n" +
                    "2. Inquire Balance\n" +
                    "3. Pay Bills");
            System.out.print("Enter your choice (1-3): ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                account.transferMoney(accounts);
            } else if (choice.equals("2")) {
                // account.inquireBalance();
                System.out.println("Inquiring Balance! Coming Soon!");
                break;
            } else if (choice.equals("3")) {
                // account.payBills();
                System.out.println("\tPaying Bills! Coming Soon!");
                break;
            } else {
                System.out.println("\n\tINVALID CHOICE");
            }
        }
        sc.close();
    }

    // Main menu that appear at the start of the program
    public void runSystem() {
        Scanner sc = new Scanner(System.in);
        InstaPayAccount account = null;
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
                if (accounts != null) {
                    Login loginObj = new Login();
                    account = loginObj.login(accounts);
                    if (account != null) {
                        subMenu(account);
                    } else {
                        System.err.println("\n\tLogin Failed!");
                    }
                } else {
                    System.err.println("\tNo account found, Register a new account first!");
                }
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