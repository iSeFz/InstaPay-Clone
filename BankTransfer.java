import java.util.List;
import java.util.Scanner;

class BankTransfer implements TransferMoney {
    @Override
    public void transferMoney(List<Account> instaPayAccounts, Account user) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0- Exit");
            System.out.println("1- Transfer money to another InstaPay Account");
            System.out.println("2- Transfer money to another Bank Account");
            System.out.println("3- Transfer money to Mobile Wallet");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter the InstaPay Account Name");
                String name = scanner.next();
                Boolean flag = false;
                for (Account instaPayAccount : instaPayAccounts) {
                    if (instaPayAccount.user.getName().equals(name)) {
                        System.out.println("Enter the amount");
                        double amount = scanner.nextDouble();
                        flag = true;
                        if (amount > user.balance && amount > 0) {
                            System.out.println("Insufficient Balance");
                        } else {
                            user.balance -= amount;
                            instaPayAccount.balance += amount;
                            System.out.println("Money Transferred Successfully");
                        }
                    }
                }
                if (!flag) {
                    System.out.println("No such InstaPay Account");
                }
            }else if (choice == 2) {
                System.out.println("Enter the Bank Account Number");
                String accountNumber = scanner.next();
                Boolean flag = false;
                for (Account instaPayAccount : instaPayAccounts) {
                    if (instaPayAccount instanceof BankAccount) {
                        BankAccount insatPayBankAccount = (BankAccount) instaPayAccount;
                        if (insatPayBankAccount.accountNumber.equals(accountNumber)) {
                            System.out.println("Enter the amount");
                            double amount = scanner.nextDouble();
                            flag = true;
                            if (amount > user.balance && amount > 0) {
                                System.out.println("Insufficient Balance");
                            } else {
                                user.balance -= amount;
                                insatPayBankAccount.balance += amount;
                                System.out.println("Money Transferred Successfully");
                            }
                        }
                    }
                }
                if (!flag) {
                    System.out.println("No such Bank Account");
                }
            } else if (choice == 3) {
                Boolean flag = false;
                while (true) {
                    System.out.println("Enter 0-Break 1 for Etisalat Wallet ar 2 for Vodafone Wallet");
                    int choice1 = scanner.nextInt();
                    if (choice1 == 0) {
                        break;
                    }
                    if (choice1 == 1) {
                        System.out.println("Enter the Mobile Etisalat Number");
                        String mobileNumber = scanner.next();
                        for (Account instaPayAccount : instaPayAccounts) {
                            if (instaPayAccount instanceof EtisalatWallet) {
                                EtisalatWallet etisalatWalletAccount = (EtisalatWallet) instaPayAccount;
                                if (instaPayAccount.user.getPhoneNumber().equals(mobileNumber)) {
                                    System.out.println("Enter the amount");
                                    double amount = scanner.nextDouble();
                                    flag = true;
                                    if (amount > user.balance && amount > 0) {
                                        System.out.println("Insufficient Balance");
                                    } else {
                                        user.balance -= amount;
                                        etisalatWalletAccount.balance += amount;
                                        System.out.println("Money Transferred Successfully");
                                    }
                                }
                            }
                        }
                        if (!flag) {
                            System.out.println("No such Mobile Number");
                        }
                    } else if (choice1 == 2) {
                        System.out.println("Enter the Mobile Vodafone Number");
                        String mobileNumber = scanner.next();
                        for (Account instaPayAccount : instaPayAccounts) {
                            if (instaPayAccount instanceof VodafoneWallet) {
                                VodafoneWallet vodafoneWalletAccount = (VodafoneWallet) instaPayAccount;
                                if (instaPayAccount.user.getPhoneNumber().equals(mobileNumber)) {
                                    System.out.println("Enter the amount");
                                    double amount = scanner.nextDouble();
                                    flag = true;
                                    if (amount > user.balance && amount > 0) {
                                        System.out.println("Insufficient Balance");
                                    } else {
                                        user.balance -= amount;
                                        vodafoneWalletAccount.balance += amount;
                                        System.out.println("Money Transferred Successfully");
                                    }
                                }
                            }
                        }
                        if (!flag) {
                            System.out.println("No such Mobile Number");
                        }
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            }
        }
    }
}