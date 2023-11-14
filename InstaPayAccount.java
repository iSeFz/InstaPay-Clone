import java.util.List;
import java.util.Scanner;

public abstract class InstaPayAccount {
    User user;
    double balance;
    public InstaPayAccount(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }
    // this function to set account number in bank account  case
    // and set mobile number of wallet in mobile wallet case
    abstract public void setbase(String number);
    abstract public String getbase();// to return account bank number or mobile wallet number
    abstract public void transferMoney(List<InstaPayAccount> instaPayAccounts );
    public User getUser(){
        return user;
    }
    public void setUser(User u){
        user.setName(u.getName());
        user.setPassword(u.getPassword());
        user.setEmail(u.getEmail());
        user.setPhoneNumber(u.getPhoneNumber());
        user.setAddress(u.getAddress());
    }

    public void inquirBalance(){
        System.out.println("Your Current Balance is: " + this.balance);
    }

    public void payBill(Bill bill) {
        System.out.println("Pay Bill Using InstaPay Account");
        System.out.println("You have Bill with Amount: " + bill.getAmount());
        Boolean check = bill.deducateBill();

        if (!check) {
            System.out.println("Do You Want to Pay the Bill? (Y/N)");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            if (choice.equals("Y") || choice.equals("y")) {
                if (bill.getAmount() <= this.balance) {
                    this.balance -= bill.getAmount();
                    bill.setStatus(false);
                    System.out.println("Bill Paid Successfully");
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Bill Not Paid");
            }
        }
    }
}