import java.util.List;

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
}