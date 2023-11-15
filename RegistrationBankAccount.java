import java.util.List;

class RegistrationBankAccount extends Registration {
    @Override
    public boolean verifyAccount(Account user, List<Account> list) {
        String AccountNumber;
        System.out.print("Please Enter Account Number Or 0 to Cancel Registration: ");
        AccountNumber = in.nextLine();
        if (AccountNumber.equals("0"))
            return false;
        while (AccountNumber.length() != 12) {
            System.out.print("Invalid Account Number\nPlease Enter valid Number or 0 to Cancel Registration: ");
            AccountNumber = in.nextLine();
            if (AccountNumber.equals("0"))
                return false;
        }
        for (Account acc : list) {
            if (acc.getbase().equals(AccountNumber)) {
                System.out.println("This Bank account was used\nRegistration failed!");
                return false;
            }
        }
        user.setbase(AccountNumber);
        return true;
    }

    @Override
    public Account adding(User user) {
        Account temp = new BankAccount(user, 100, "BankAccount");
        return temp;
    }

}
