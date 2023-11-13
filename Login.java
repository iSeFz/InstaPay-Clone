import java.util.Scanner;
import java.util.List;

public class Login {
    // Login to an existing account
    public boolean login(List<InstaPayAccount> accounts) {
        System.out.println("\n\tLogin To Your Account");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        if(checkAccount(username, password, accounts)){
            System.out.println("\tLogin Successfull!");
            sc.close();
            return true;
        }
        sc.close();
        return false;
    }

    // Check for account if it is stored before in the system
    public boolean checkAccount(String username, String password, List<InstaPayAccount> accounts) {
        for (InstaPayAccount acc : accounts) {
            if (username.equals(acc.getUser().getName())) {
                if(password.equals(acc.getUser().getPassword())){
                    return true;
                } else {
                    System.err.println("\tPassword is incorrect!");
                    return false;
                }
            }
        }
        System.err.println("Username not found, Register a new account first!");
        return false;
    }
}
