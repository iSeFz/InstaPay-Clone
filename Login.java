import java.util.Scanner;
import java.util.List;

public class Login {
    // Login to an existing account
    public Account login(List<Account> accounts) {
        System.out.println("\n\tLogin To Your Account");
        Account loggedIn = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        loggedIn = checkUsername(username, accounts);
        if (loggedIn == null) {
            sc.close();
            return null;
        }
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        loggedIn = checkPassword(password, loggedIn);
        sc.close();
        return loggedIn;
    }

    // Check if username is registered to an account before
    public Account checkUsername(String username, List<Account> accounts) {
        for (Account acc : accounts) {
            if (username.equals(acc.getUser().getName())) {
                return acc;
            }
        }
        System.err.println("Username not found, Register a new account first!");
        return null;
    }

    // Check for account if it is stored before in the system
    public Account checkPassword(String password, Account account) {
        if (password.equals(account.getUser().getPassword())) {
            System.out.println("\n\tLogin Successfull!");
            return account;
        } else {
            System.err.println("\tPassword is incorrect!");
            return null;
        }
    }
}
