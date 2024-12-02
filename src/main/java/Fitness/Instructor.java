package Fitness;

public class Instructor extends User{
    private UserStatus status;
    public Instructor(String name,int age,String gender,String address,String email,String pass,UserStatus status) {
        super(name,age,gender,address,email,pass,Role.Instructor);
        this.status=status;
    }
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus userStatus) {
        this.status = userStatus;
    }
}
