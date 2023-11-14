import java.util.List;

public abstract class Registration {
    public boolean register(InstaPayAccount user, List<InstaPayAccount> list) {
        return true;
    }
    public boolean verifyEmail(User user){
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