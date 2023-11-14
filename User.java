class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    public User(String name, String email, String password, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setEmail(String Email){
        email = Email;
    }
    public void setName(String Name){
        name = Name;
    }
    public void setPhoneNumber(String Phone){
        phoneNumber = Phone;
    }
    public void setPassword(String Password){
        password = Password;
    }
    public void setAddress(String Address){
        address = Address;
    }
}