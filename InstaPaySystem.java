import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {
    private List<InstaPayAccount> accounts;
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