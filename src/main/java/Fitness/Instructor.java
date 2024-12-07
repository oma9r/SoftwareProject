package Fitness;

import io.cucumber.java.be.I;

import static Fitness.Application.notApprovedArticles;

public class Instructor extends User{
    private UserStatus status;

    public Instructor() {
        super();
        status=UserStatus.Active;
    }

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

    @Override
    public String toString() {
        return "["+super.toString()+",status="+status+"]\n";
    }

    public void addWallness(Article article) {
        notApprovedArticles.add(article);
    }
}
