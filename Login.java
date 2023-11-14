import java.util.Scanner;
import java.util.List;

public class Login {
    // Login to an existing account
    public InstaPayAccount login(List<InstaPayAccount> accounts) {
        System.out.println("\n\tLogin To Your Account");
        InstaPayAccount loggedIn = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        loggedIn = checkUsername(username, accounts);
        if(loggedIn == null){
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
    public InstaPayAccount checkUsername(String username, List<InstaPayAccount> accounts) {
        for (InstaPayAccount acc : accounts) {
            if (username.equals(acc.getUser().getName())) {
                return acc;
            }
        }
        System.err.println("Username not found, Register a new account first!");
        return null;
    }

    // Check for account if it is stored before in the system
    public InstaPayAccount checkPassword(String password, InstaPayAccount account) {
        if(password.equals(account.getUser().getPassword())){
            System.out.println("\n\tLogin Successfull!");
            return account;
        } else {
            System.err.println("\tPassword is incorrect!");
            return null;
        }
    }
}
