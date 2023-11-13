import java.util.List;
import java.util.Scanner;

public class InstaPayWalletEtisalat extends InstaPayWallet {
    public InstaPayWalletEtisalat(User user, double balance) {
        super(user, balance);
    }

    public void transferMoney(List<InstaPayAccount> instaPayAccounts) {
        System.out.println("Transfer Money Using InstaPay Wallet Etisalat");
        int options = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("0- Exit");
            System.out.println("1- Transfer money to another InstaPay Account");
            System.out.println("2- Transfer money to another Bank Account");
            System.out.println("3- Transfer money to Mobile Wallet");
            System.out.println("Enter your choice");
            options = sc.nextInt();
            if (options == 1) {
                System.out.println("Enter the InstapayAccount Name to transfer");
                String name = sc.next();
                boolean flag = false;
                for (InstaPayAccount instaPayAccount : instaPayAccounts) {
                    if (instaPayAccount.user.getName().equals(name)) {
                        System.out.println("Enter the amount to transfer");
                        double amount = sc.nextDouble();
                        if (amount <= balance) {
                            balance -= amount;
                            instaPayAccount.balance += amount;
                            flag = true;
                            System.out.println("Money Transfered Successfully");
                            break;
                        } else {
                            System.out.println("Insufficient Balance");
                            break;
                        }
                    }
                }
                if (!flag)
                    System.out.println("No such InstaPay Account Found");
            } else if (options == 2) {
                System.out.println("Enter the InstapayAccountBankAccount Number");
                String accountNumber = sc.next();
                boolean flag = false;
                for (InstaPayAccount instaPayAccount : instaPayAccounts) {
                    if (instaPayAccount instanceof InsatPayBankAccount && ((InsatPayBankAccount) instaPayAccount).accountNumber.equals(accountNumber)) {
                        System.out.println("Enter the amount to transfer");
                        double amount = sc.nextDouble();
                        if (amount <= balance) {
                            balance -= amount;
                            instaPayAccount.balance += amount;
                            System.out.println("Money Transfered Successfully");
                            flag = true;
                            break;
                        } else {
                            System.out.println("Insufficient Balance");
                            break;
                        }
                    }
                }
                if (!flag)
                    System.out.println("No such InstaPay Account Found");
            } else if (options == 3) {
                System.out.println("0- Exit");
                System.out.println("1- for transfer money to InstaPay Wallet Vodafone");
                System.out.println("2- for transfer money to InstaPay Wallet Etisalat");
                System.out.println("Enter your choice");
                options = sc.nextInt();
                if (options == 1) {
                    System.out.println("Enter the Mobile Number");
                    String mobileNumber = sc.next();
                    boolean flag = false;
                    for (InstaPayAccount instaPayAccount : instaPayAccounts) {
                        if (instaPayAccount instanceof InstaPayWalletVodafone && instaPayAccount.user.getPhoneNumber().equals(mobileNumber)) {
                            System.out.println("Enter the amount to transfer");
                            double amount = sc.nextDouble();
                            if (amount <= balance) {
                                balance -= amount;
                                instaPayAccount.balance += amount;
                                System.out.println("Money Transfered Successfully");
                                flag = true;
                                break;
                            } else {
                                System.out.println("Insufficient Balance");
                                break;
                            }
                        }
                    }
                    if (!flag)
                        System.out.println("No such InstaPay Account Found");
                } else if (options == 2) {
                    System.out.println("Enter the Mobile Number");
                    String mobileNumber = sc.next();
                    boolean flag = false;
                    for (InstaPayAccount instaPayAccount : instaPayAccounts) {
                        if (instaPayAccount instanceof InstaPayWalletEtisalat && instaPayAccount.user.getPhoneNumber().equals(mobileNumber)) {
                            System.out.println("Enter the amount to transfer");
                            double amount = sc.nextDouble();
                            if (amount <= balance) {
                                balance -= amount;
                                instaPayAccount.balance += amount;
                                System.out.println("Money Transfered Successfully");
                                flag = true;
                                break;
                            } else {
                                System.out.println("Insufficient Balance");
                                break;
                            }
                        }
                    }
                    if (!flag)
                        System.out.println("No such InstaPay Account Found");
                } else if (options == 0) {
                    return;
                } else {
                    System.out.println("Invalid Option");

                }
            } else if (options == 0) {
                return;
            } else {
                System.out.println("Invalid Option");
            }
        }
    }
}