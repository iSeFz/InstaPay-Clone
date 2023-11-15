import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<Account> accounts = new ArrayList<>();

    // Registration helper method for more readable code
    private void registrationHelper() {
        Account account = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Which account type do you want to register?\n" +
                    "1. Bank Account\n" +
                    "2. Wallet Account");
            System.out.print("Enter your choice (1-2): ");
            String accountType = sc.nextLine();
            if (accountType.equals("1")) {
                RegistrationBankAccount newBankAccount = new RegistrationBankAccount();
                account = newBankAccount.register(accounts);
                break;
            } else if (accountType.equals("2")) {
                RegistrationMobileWallet newWalletAccount = new RegistrationMobileWallet();
                account = newWalletAccount.register(accounts);
                break;
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
        sc.close();
        // If the registration was successfull
        // Add the user to the list of accounts stored on the system
        if (account != null) {
            accounts.add(account);
            subMenu(account);
        } else {
            System.out.println("\n\tRegistration Failed!");
        }
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
                account.payBill(); // Here Must be Modified ==> Talk With Mostafa
            } else if (choice.equals("4")) {
                sc.close();
                break;
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
    }

    // Main menu that appear at the start of the program
    public void runSystem() {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        Account account = null;
        System.out.println("\tWelcome to InstaPay Clone!");
        while (!choice.equals("3")) {
            System.out.println("\n1. Register a new account\n" +
                    "2. Login into existing account\n" +
                    "3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\n\tRegistering a new account");
                registrationHelper();
                break;
            } else if (choice.equals("2")) {
                if (accounts != null) {
                    Login loginObj = new Login();
                    account = loginObj.login(accounts);
                    if (account != null) {
                        subMenu(account);
                        break;
                    } else {
                        System.err.println("\n\tLogin Failed!");
                    }
                } else {
                    System.err.println("\tNo account found, Register a new account first!");
                }
            } else {
                System.err.println("\n\tINVALID CHOICE");
            }
        }
        System.out.println("\tThank you for using InstaPay Clone!");
        sc.close();
    }

    public static void main(String[] args) {
        InstaPaySystem sys = new InstaPaySystem();
        sys.runSystem();
    }
}