package Fitness;

public class Client extends User {
    private UserStatus status;
    public Client(String name, int age, String gender, String address, String email, String pass,UserStatus status) {
        super(name, age, gender, address, email, pass,Role.Client);
        this.status = status;
    }
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus userStatus) {
        this.status = userStatus;
    }


}
