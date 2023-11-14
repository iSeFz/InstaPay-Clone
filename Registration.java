import java.util.List;
import java.util.Scanner;

public abstract class Registration {
    public Scanner in = new Scanner(System.in);
    public boolean register(InstaPayAccount user, List<InstaPayAccount> list) {
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
    public boolean verifyMobilNumber(User user){
        return true;
    }
    public boolean verifyPassword(User user){
        return true;
    }
    public boolean verifyName(User user , List<InstaPayAccount> list){
        return true;
    }
}
class RegistrationBankAccount extends Registration {
    @Override
    public boolean verifyAccount(InstaPayAccount user){
        return true;
    }

}

class RegistrationMobileWallet extends Registration {
    @Override
    public boolean verifyAccount(InstaPayAccount user){
        return true;
    }

}