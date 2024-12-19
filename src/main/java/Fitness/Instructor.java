package Fitness;

import static Fitness.Application.notApprovedArticles;

public class Instructor extends User{
    private Status status;

    public Instructor() {
        super();
        status= Status.Active;
    }

    public Instructor(String name, int age, String gender, String address, String email, String pass, Status status) {
        super(name,age,gender,address,email,pass,Role.Instructor);
        this.status=status;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "["+super.toString()+",status="+status+"]\n";
    }

    public void addWallness(Article article) {
        notApprovedArticles.add(article);
    }
}
