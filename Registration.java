import java.util.List;
import java.util.Scanner;

public abstract class Registration {
    public Scanner in = new Scanner(System.in);

    public Account register(List<Account> list) {
        System.out.println("\n\tRegister New InstaPay Account");
        User newUser = new User("", "", "", "", "");
        // Store the created account in a variable to return later
        Account newAccount = adding(newUser);
        // Continue check for remaining user data
        if (!verifyAccount(newAccount, list)) {
            return null;
        }
        if (!verifyMobilNumber(newUser, list)) {
            return null;
        }
        if (!verifyName(newUser, list)) {
            return null;
        }
        if (!verifyPassword(newUser)) {
            return null;
        }
        // Set user data in account
        newAccount.getUser().setUser(newUser);
        // Create dummy bills for each new user
        Bill eBill = new ElectricityBill();
        eBill.createBill();
        newAccount.setBill(eBill);
        Bill gBill = new GasBill();
        gBill.createBill();
        newAccount.setBill(gBill);
        Bill wBill = new WaterBill();
        wBill.createBill();
        newAccount.setBill(wBill);
        // Return the newly created account
        return newAccount;
    }

    abstract public boolean verifyAccount(Account user, List<Account> list);

    abstract public Account adding(User user);

    public boolean verifyMobilNumber(User user, List<Account> list) {
        String mobile;
        System.out.print("Please Enter Your Phone Number: ");
        mobile = in.nextLine();
        while (!mobile.matches("^01[0125]\\d{8}$")) {
            System.out.println("Please Enter Valid Mobile Number or 0 To Cancel Registration:");
            mobile = in.nextLine();
            if (mobile.equals("0")) {
                System.out.println("Registration canceled!\n");
                return false;
            }
        }
        for (Account account : list) {
            if (account.getUser().getPhoneNumber().equals(mobile)) {
                System.out.println("this number was used in another account");
                System.out.println("Registration failed!");
                return false;
            }
        }
        String Otp;
        OTP otp = new OTP();
        otp.generateOTP();
        otp.sendOTP();
        System.out.print("Please Enter Otp recently send: ");
        Otp = in.nextLine();
        while (!otp.verifyOTP(Otp)) {
            System.out.print("Please Enter correct OTP or 0 to Cancel Registration: ");
            Otp = in.nextLine();
            if (Otp.equals("0")) {
                System.out.println("Registration canceled!\n");
                return false;
            }
        }
        user.setPhoneNumber(mobile);
        return true;
    }

    public boolean verifyPassword(User user) {
        String password;
        System.out.print("Please Enter Your Password: ");
        password = in.nextLine();
        while (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
            System.out.println("This Password was weak\n" +
                    "Strong password should contain:\n" +
                    "Lower case characters\n" +
                    "Upper case characters\n" +
                    "Numbers");
            System.out.print("Please Enter Strong Password Or 0 to cancel: ");
            password = in.nextLine();
            if (password.equals("0"))
                return false;
        }
        user.setPassword(password);
        return true;
    }

    public boolean verifyName(User user, List<Account> list) {
        System.out.print("Please Enter unique Name or 0 To Cancel Registration: ");
        String name = in.nextLine();
        if (name.equals("0"))
            return false;
        for (Account a : list) {
            if (name.equals(a.getUser().getName())) {
                System.out.print("this name was used\n");
                return verifyName(user, list);
            }
        }
        user.setName(name);
        return true;
    }
}