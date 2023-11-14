import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<InstaPayAccount> accounts;

    public InstaPaySystem() {
        accounts = new ArrayList<>();
    }

    /* ##### For TESTING Purposes #####
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

    // NOTE: This violates the OCP, but it was done for better readability
    // Registration helper method for more readable code
    private void registrationHelper(InstaPayAccount account, List<InstaPayAccount> accounts) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Which account type do you want to register?\n" +
                    "1. Bank Account\n" +
                    "2. Wallet Account");
            System.out.print("Enter your choice (1-2): ");
            String accountType = sc.nextLine();
            if (accountType.equals("1")) {
                RegistrationBankAccount newBankAccount = new RegistrationBankAccount();
                if (newBankAccount.register(account, accounts)) {
                    subMenu(account);
                    break;
                } else break;
            } else if (accountType.equals("2")) {
                RegistrationMobileWallet newWalletAccount = new RegistrationMobileWallet();
                if (newWalletAccount.register(account, accounts)) {
                    subMenu(account);
                    break;
                } else break;
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
        sc.close();
    }

    // Sub menu that appear after logging in to a certain account
    private void subMenu(InstaPayAccount account) {
        System.out.println("\tWelcome " + account.user.getName() + " to InstaPay Clone!");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Transfer Money\n" +
                    "2. Inquire Balance\n" +
                    "3. Pay Bill\n" +
                    "4. Return to the main menu");
            System.out.print("Enter your choice (1-4): ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                account.transferMoney(accounts);
            } else if (choice.equals("2")) {
                account.inquirBalance();
            } else if (choice.equals("3")) {
                Bill billToPay = null;
                account.payBill(billToPay);
            } else if (choice.equals("4")) {
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
                System.out.println("\n\tRegistering a new account");
                registrationHelper(account, accounts);
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