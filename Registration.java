import java.util.List;
import java.util.Scanner;

public abstract class Registration {
    public Scanner in = new Scanner(System.in);
    public boolean register(InstaPayAccount user, List<InstaPayAccount> list) {
        User temp = new User("", "" , "" , "" , "");
        System.out.println("Register New User:-");
        if(!verifyAccount(user)){
            System.out.println("Registration canceled!\n");
            return false;
        }
        if(!verifyEmail(temp)){
            System.out.println("Registration canceled!\n");
            return false;
        }
        if(!verifyMobilNumber(temp , list)){
            return false;
        }
        if(!verifyName(temp, list)){
            System.out.println("Registration canceled!\n");
            return false;
        }

        if(!verifyPassword(temp)){
            System.out.println("Registration canceled!\n");
            return false;
        }
        System.out.println("Please Enter Your Address");
        temp.setAddress(in.nextLine());
        user.getUser().setUser(temp);
        return true;
    }
    public boolean verifyEmail(User user){
        String mail;
        System.out.println("Please Enter You Email");
        mail = in.nextLine();
        while(!mail.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            System.out.println("Invalid Email\nPlease Enter valid mail or 0 to cancel:");
            mail = in.nextLine();
            if(mail.equals("0")){
                return false;
            }
        }
        user.setEmail(mail);
        return true;
    }
    abstract public boolean verifyAccount(InstaPayAccount user);
    public boolean verifyMobilNumber(User user , List<InstaPayAccount> list){
        String mobile;
        System.out.println("Please Enter Your Phone Number:");
        mobile = in.nextLine();
        while(!mobile.matches("^01[0125]\\d{8}$")){
            System.out.println("Please Enter Valid Mobile Number or 0 To Cancel Registration:");
            mobile = in.nextLine();
            if(mobile.equals("0")){
                System.out.println("Registration canceled!\n");
                return false;
            }
        }
        for(InstaPayAccount account: list){
            if(account.getUser().getPhoneNumber().equals(mobile)){
                System.out.println("this number was used in another account");
                System.out.println("Registration failed!");
                return false;
            }
        }
        String Otp;
        OTP otp = new OTP();
        otp.generateOTP();
        otp.sendOTP();
        System.out.println("Please Enter Otp recently send:");
        Otp = in.nextLine();
        while (!otp.verifyOTP(Otp)){
            System.out.println("Please Enter correct OTP or 0 to Cancel Registration:");
            Otp = in.nextLine();
            if(Otp.equals("0")){
                return false;
            }
        }
        user.setPhoneNumber(mobile);
        return true;
    }
    public boolean verifyPassword(User user){
        String password;
        System.out.print("Please Enter Your Password");
        password = in.nextLine();
        while(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")){
            System.out.print("This Password was weak\nStrong password should contain:\nlower case character\nupper case character \nnumbers\nPlease Enter Strong Password Or 0 to cancel:");
            password = in.nextLine();
            if(password.equals("0"))
                return false;
        }
        user.setPassword(password);
        return true;
    }
    public boolean verifyName(User user , List<InstaPayAccount> list){
        System.out.println("Please Enter unique Name or 0 To Cancel Registration:");
        String name = in.nextLine();
        if(name.equals("0"))
            return false;
        for(InstaPayAccount a : list){
            if(name.equals(a.getUser().getName())){
                System.out.print("this name was used\n");
                return verifyName(user , list);
            }
        }
        user.setName(name);
        return true;
    }
}
class RegistrationBankAccount extends Registration {
    @Override
    public boolean verifyAccount(InstaPayAccount user){
        String AccountNumber;
        System.out.println("Please Enter Account Number Or 0 to Cancel Registration:");
        AccountNumber = in.nextLine();
        if(AccountNumber.equals("0"))
            return false;
        while(AccountNumber.length() != 12){
            System.out.println("It is invalid Account Number\nPlease Enter valid Number or 0 to Cancel Registration:");
            AccountNumber = in.nextLine();
            if(AccountNumber.equals("0"))
                return false;
        }
        user.setbase(AccountNumber);
        return true;
    }

}

class RegistrationMobileWallet extends Registration {
    @Override
    public boolean verifyAccount(InstaPayAccount user){
        return true;
    }

}