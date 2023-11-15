import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Account {
    User user;
    double balance;
    TransferMoney transferMoney;
    List<Bill> bills = new ArrayList<Bill>();

    public Account(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    public void setTransferMoney(TransferMoney transferMoney) {
        this.transferMoney = transferMoney;
    }

    // this function to set account number in bank account case
    // and set mobile number of wallet in mobile wallet case
    abstract public void setbase(String number);

    abstract public String getbase();// to return account bank number or mobile wallet number

    abstract public void transferMoney(List<Account> instaPayAccounts);

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        user.setName(u.getName());
        user.setPassword(u.getPassword());
        user.setEmail(u.getEmail());
        user.setPhoneNumber(u.getPhoneNumber());
        user.setAddress(u.getAddress());
    }

    public void setBill(Bill bill) {
        if (bill == null) {
            System.out.println("Bill is null");
            return;
        }
        else
            bills.add(bill);
    }

    public void printBills() {
        for (Bill bill : bills) {
            bill.printBill();
        }
    }

    public Bill getBill(int index) {
        return bills.get(index);
    }

    public void inquireBalance() {
        System.out.println("Your Current Balance is: " + this.balance);
    }

    public void payBill() {
        System.out.println("Pay Bill Using InstaPay Account");
        System.out.println("You have " + bills.size() + " Bills: ");
        System.out.println("=====================================");
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(i + 1 + ". " + bills.get(i).getClass().getName() + " " + bills.get(i).getAmount());
        }
        System.out.println("=====================================");

        System.out.println("Do You want to Pay Bill? (Y/N)");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        if (choice.equals("Y") || choice.equals("y")) {
            System.out.println("Enter Bill Number: ");
            int billNumber = input.nextInt();
            Bill bill = bills.get(billNumber - 1);
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

