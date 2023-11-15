import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<Account> accounts;

    public InstaPaySystem() {
        accounts = new ArrayList<>();
    }

    // NOTE: This violates the OCP, but it was done for better readability
    // Registration helper method for more readable code
    private void registrationHelper(Account account, List<Account> accounts) {
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
                } else
                    break;
            } else if (accountType.equals("2")) {
                RegistrationMobileWallet newWalletAccount = new RegistrationMobileWallet();
                if (newWalletAccount.register(account, accounts)) {
                    subMenu(account);
                    break;
                } else
                    break;
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
        sc.close();
    }

    // Sub menu that appear after logging in to a certain account
    private void subMenu(Account account) {
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
                account.inquireBalance();
            } else if (choice.equals("3")) {
                Bill billToPay = null;
                account.payBill(billToPay); // Here Must be Modified ==> Talk With Mostafa
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
        Account account = null;
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