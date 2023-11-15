import java.util.List;

class RegistrationMobileWallet extends Registration {
    private char ch;

    @Override
    public boolean verifyAccount(Account user, List<Account> list) {
        String Mobile;
        System.out.print("Please Enter Mobile Number that has the wallet or 0 To Cancel Registration: ");
        Mobile = in.nextLine();
        if (Mobile.equals("0")) {
            System.out.println("Registration canceled!\n");
            return false;
        }
        while (!Mobile.matches("^01[0125]\\d{8}$")) {
            System.out.print("Invalid Account Number\nPlease Enter valid Number or 0 To Cancel Registration: ");
            Mobile = in.nextLine();
            if (Mobile.equals("0")) {
                System.out.println("Registration canceled!\n");
                return false;
            }
        }
        for (Account account : list) {
            if (account.getUser().getPhoneNumber().equals(Mobile)) {
                System.out.println("This number was used in another account");
                System.out.println("Registration failed!");
                return false;
            }
        }
        ch = Mobile.charAt(2);
        if (ch != '1' && ch != '0') {
            System.out.println("Invalid provider!");
            return false;
        }
        switch (ch) {
            case '0':
                user = new VodafoneWallet(user.getUser(), 100);
                break;
            case '1':
                user = new EtisalatWallet(user.getUser(), 100);
                break;
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
        user.getUser().setPhoneNumber(Mobile);
        user.setbase(Mobile);
        return true;
    }

    @Override
    public Account adding(User user) {
        Account temp = new VodafoneWallet(user, 100);
        switch (ch) {
            case '0':
                temp = new VodafoneWallet(user, 100);
                break;
            case '1':
                temp = new EtisalatWallet(user, 100);
                break;
        }
        return temp;
    }

}